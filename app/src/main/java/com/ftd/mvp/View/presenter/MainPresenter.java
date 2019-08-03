package com.ftd.mvp.View.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.Intent;

import com.ftd.mvp.Utils.log.Logger;
import com.ftd.mvp.View.SubActivity;
import com.ftd.mvp.View.contract.IMainContract;

/**
 * The type Pc login presenter.
 *
 * @author FTD_2014
 */
public class MainPresenter implements IMainContract.Presenter, LifecycleObserver {

    private IMainContract.View mView = null;
    private Context mContext = null;
    private String mClassName = MainPresenter.class.getSimpleName();

    /**
     * Instantiates a new Pc qrcode presenter.
     *
     * @param view the view
     */
    public MainPresenter(IMainContract.View view) {
        mView = view;
    }

    @Override
    public void setContext(Context context) {
        mContext = context;
    }

    @Override
    public void onClick() {
        Logger.info(mClassName, " mvp逻辑处理 onClick enter");
        mContext.startActivity(new Intent(mContext,
                SubActivity.class));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        String funName = "onCreate ";
        Logger.info(mClassName, funName);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestory(){
        String funName = "onDestory ";
        Logger.info(mClassName, funName);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        String funName = "onResume ";
        Logger.info(mClassName, funName);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        String funName = "onPause ";
        Logger.info(mClassName, funName);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        String funName = "onStart ";
        Logger.info(mClassName, funName);
        regReceiver();
        regHandler();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        String funName = "onStop ";
        Logger.info(mClassName, funName);
        unregHandler();
        unregReceiver();
    }

    private void regReceiver() {
    }

    private void unregReceiver() {
    }

    private void regHandler() {
    }

    private void unregHandler() {
    }

}
