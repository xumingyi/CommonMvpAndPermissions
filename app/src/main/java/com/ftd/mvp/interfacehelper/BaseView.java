package com.ftd.mvp.interfacehelper;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by xmy
 */
public interface BaseView<T> {

    void setPresenter(T presenter);

    AppCompatActivity getActivity();
}
