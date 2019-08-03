package com.ftd.mvp.View.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Unbinder;

import com.ftd.mvp.R;
import com.ftd.mvp.Utils.log.Logger;
import com.ftd.mvp.View.BaseActivity;
import com.ftd.mvp.View.SubActivity;
import com.ftd.mvp.View.contract.IMainContract;
import com.ftd.mvp.View.presenter.MainPresenter;
import com.ftd.mvp.constant.Constant;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements IMainContract.View{

    private ImageView mIVQrcode;
    private MainPresenter mMainPresenter = null;
    private Context mContext = null;
    private String mClassName = MainActivity.class.getSimpleName();
    private RelativeLayout mQrcodeLayout;
    private RelativeLayout mQrcodeErrorLayout;
    private TextView mQrcodeHintTV;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String funName = "onCreate ";
        Logger.info(Constant.COMMON_PAGE_FLAG + mClassName,  funName, true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    @Override
    protected void onDestroy() {
        String funName = "onDestroy ";
        Logger.info(Constant.COMMON_PAGE_FLAG + mClassName, funName, true);
        getLifecycle().removeObserver(mMainPresenter);
        super.onDestroy();
        mUnbinder.unbind();
    }

    @Override
    public void onStart() {
        String funName = "onStart ";
        Logger.info(Constant.COMMON_PAGE_FLAG + mClassName,  funName, true);
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    private void initView(){
        mContext = this;
        mMainPresenter = new MainPresenter(this);
        mMainPresenter.setContext(mContext);
        getLifecycle().addObserver(mMainPresenter);
        findViewById(R.id.test_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.onClick();
            }
        });
    }

    // 更新数据
    public void initData() {

    }

//    /**
//     * On click.
//     *
//     * @param v the v
//     */
//    @OnClick({R.id.title_bar_left_ll, R.id.qrcode_login_refresh_btn})
//    public void onClick(View v){
//        switch (v.getId()){
//            case R.id.title_bar_left_ll:
//                finish();
//                break;
//            default:
//                break;
//        }
//    }

    //启动个人中心登录页返回数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setPresenter(IMainContract.Presenter presenter) {

    }

    @Override
    public AppCompatActivity getActivity() {
        return this;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        String funName = "onRequestPermissionsResult ";
        Logger.info(mClassName, funName);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}