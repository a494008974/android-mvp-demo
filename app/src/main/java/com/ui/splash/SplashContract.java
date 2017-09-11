package com.ui.splash;

import com.base.BaseModel;
import com.base.BasePresenter;
import com.base.BaseView;

/**
 * Created by Administrator on 2017/8/15.
 */
public interface SplashContract {
    interface Model extends BaseModel {
        public void configdefaultData();
    }

    interface View extends BaseView {
        public void showStatus(String msg);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void configdefaultData();
        @Override
        public void onStart() {}
    }
}
