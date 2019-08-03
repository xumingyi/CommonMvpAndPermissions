package com.ftd.mvp.View;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ftd.mvp.Utils.PermissionUtil;
import com.ftd.mvp.Utils.log.Logger;
import com.ftd.mvp.constant.Constant;


/**
 * @author xmy
 */
public class BaseActivity extends AppCompatActivity{

    /**
     * Whether response to skin changing after create
     */
    private String mClassName = BaseActivity.class.getSimpleName();

    String[] permissionsLog = new String[]{
            Manifest.permission.READ_LOGS
    };
    protected boolean isNeedConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //透明状态栏/导航栏
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        String funName = "onResume ";
        super.onResume();
        //当页面中途跳转的时候，当前页面UI不显示, 直接显示下一个页面UI,防止UI闪烁。
        getWindow().getDecorView().setVisibility(View.VISIBLE);

        //请求动态权限，请求弹窗和设置系统权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(!PermissionUtil.hasDynamicPermissions(this)){
                ActivityCompat.requestPermissions(this, PermissionUtil.DynamicPermissions,
                        Constant.REQUEST_CODE_DYNAMICPERMISSIONS);
            }
            if (!Settings.System.canWrite(this)) {
                Logger.debug(mClassName, funName + "to requestWriteSettings");
                requestWriteSettings();
                return;
            }else{
                Logger.debug(mClassName, funName + "has WRITE_SETTINGS Permission");
            }
            //检查是否已经授予权限, 动态申请悬浮窗权限。
            if (!Settings.canDrawOverlays(this)) {
                //若未授权则请求权限
                getOverlayPermission();
                return;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //配合resume时序
        getWindow().getDecorView().setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode, @Nullable Intent data ) {
        String funName = "onActivityResult ";
        Logger.info(Constant.COMMON_PAGE_FLAG + mClassName, funName);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_CODE_WRITE_SETTINGS) {
            Logger.debug(mClassName, funName + "request WRITE_SETTINGS OK to grantLogPermission");
            grantLogPermission();
            return;
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void requestWriteSettings() {
        if(Build.VERSION.SDK_INT >=  Build.VERSION_CODES.M) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, Constant.REQUEST_CODE_WRITE_SETTINGS);
        }
    }

    //请求悬浮窗权限
    @TargetApi(Build.VERSION_CODES.M)
    private void getOverlayPermission() {
        if(Build.VERSION.SDK_INT >=  Build.VERSION_CODES.M){
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, Constant.REQUEST_CODE_OVERLOAD);
        }

    }

    //push 依赖
    private void grantLogPermission(){
        String funName = "grantLogPermission ";
        if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_LOGS)) {
            ActivityCompat.requestPermissions(this, permissionsLog, Constant.REQUEST_CODE_READ_LOGS);
        } else {
            Logger.debug(mClassName, funName + "has grantLogPermission");
        }
    }

}
