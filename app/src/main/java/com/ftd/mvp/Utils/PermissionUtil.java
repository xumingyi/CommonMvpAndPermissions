package com.ftd.mvp.Utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import com.ftd.mvp.Utils.log.Logger;


public class PermissionUtil {

    private static String mClassName = PermissionUtil.class.getSimpleName();

    //埋点功能需要动态申请的权限
    public static String[] DynamicPermissions = new String[]{
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
//            Manifest.permission.CAMERA
    };

    //动态权限是否有的判断
    public static boolean hasDynamicPermissions(Context context){
        String funName = "hasDynamicPermissions ";
        boolean hasDynamicPermissions = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if ( PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(
                    context, Manifest.permission.READ_PHONE_STATE)
                    || PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(
                    context, Manifest.permission.READ_EXTERNAL_STORAGE)
                    || PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(
                    context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    || PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(
                    context, Manifest.permission.ACCESS_FINE_LOCATION)
                    || PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(
                    context, Manifest.permission.ACCESS_COARSE_LOCATION)
            ) {
                hasDynamicPermissions = false;
            }else{
                hasDynamicPermissions = true;
            }
        }
        Logger.debug(mClassName, funName + "hasDynamicPermissions:"+hasDynamicPermissions);
        return hasDynamicPermissions;
    }

//    /**
//     * 申请权限
//     */
//    public static void requestWriteSettings(Context context)
//    {
//         String funName = "requestWriteSettings";
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            //大于等于23 请求权限
//            if (!Settings.System.canWrite(context))
//            {
//                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
//                intent.setData(Uri.parse("package:" + context.getPackageName()));
//                ((Activity)context).startActivityForResult(intent,Constant.REQUEST_CODE_WRITE_SETTINGS);
//            }else{
//                Logger.info(mClassName, funName + "has WRITE_SETTINGS Permission");
//            }
//        }else{
//            //小于23直接设置,通过Mainfest.xml
//        }
//    }
//
//    //请求悬浮窗权限
//    public static void getOverlayPermission(Context context) {
//        String funName = "getOverlayPermission";
//        if(Build.VERSION.SDK_INT >=  Build.VERSION_CODES.M){
//            if(!Settings.canDrawOverlays(context)){
//                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
//                intent.setData(Uri.parse("package:" + context.getPackageName()));
//                ((Activity)context).startActivityForResult(intent,Constant.REQUEST_CODE_OVERLOAD);
//            }else{
//                Logger.info(mClassName, funName + "has OVERLOAD Permission");
//            }
//        }else{
//            //小于23直接设置,通过Mainfest.xml
//        }
//
//    }
}
