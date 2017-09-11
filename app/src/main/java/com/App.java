package com;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.base.util.DbUtil;
import com.base.util.SpUtil;

import java.io.File;


/**
 * Created by baixiaokang on 16/4/23.
 */
public class App extends Application {
    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        SpUtil.init(this);
        DbUtil.init(this);
        C.SPLASH_PATH = String.format(this.getFilesDir().getPath()+ File.separator+"%s","splash");
    }
    public static Context getAppContext() {
        return mApp;
    }

    public static Resources getAppResources() {
        return mApp.getResources();
    }

}
