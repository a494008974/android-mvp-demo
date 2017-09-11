package com.ui.main;


/**
 * Created by Administrator on 2017/8/15.
 */
public class MainPresenter extends MainContract.Presenter {


    @Override
    public void configData() {
        mModel.configData();
    }

    @Override
    public void onStart() {
        super.onStart();

//        if (SpUtil.isConfig()){
            configData();
//            SpUtil.setConfig(App.getAppContext(),true);
//        }


    }
}
