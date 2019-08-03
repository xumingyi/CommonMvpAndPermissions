package com.ftd.mvp.View.contract;

import android.content.Context;
import com.ftd.mvp.interfacehelper.BasePresenter;
import com.ftd.mvp.interfacehelper.BaseView;


/**
 * Created by xmy
 */
public interface IMainContract {

    /**
     * The interface View.
     */
    interface View extends BaseView<Presenter> {

        @Override
        void setPresenter(Presenter presenter);

    }

    /**
     * The interface Presenter.
     */
    interface Presenter extends BasePresenter {

        @Override
        void setContext(Context context);

        void onClick();
    }



}
