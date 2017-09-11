package com.ui.splash;

import com.App;
import com.base.util.SpUtil;


/**
 * Created by Administrator on 2017/8/15.
 */
public class SplashPresenter extends SplashContract.Presenter {


    @Override
    public void configdefaultData() {
        mModel.configdefaultData();
    }



    @Override
    public void onStart() {
        super.onStart();

        if (!SpUtil.isConfig()){
            configdefaultData();
            SpUtil.setConfig(App.getAppContext(),true);
        }



    }
}
