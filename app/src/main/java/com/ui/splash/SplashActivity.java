package com.ui.splash;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.C;
import com.base.BaseActivity;
import com.ui.main.R;

import java.io.File;

import butterknife.Bind;

public class SplashActivity extends BaseActivity<SplashPresenter,SplashModel> implements SplashContract.View{
    @Bind(R.id.splash_title)
    TextView splashTitle;

    @Bind(R.id.splash_load)
    ImageView splashLoad;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {

        File file = new File(C.SPLASH_PATH);
        if(file.exists()){
            try {
                Bitmap bmp = BitmapFactory.decodeFile(C.SPLASH_PATH);
                splashLoad.setImageBitmap(bmp);
            }catch (Exception e){

            }
        }else{
            splashLoad.setImageResource(R.drawable.splash);
        }
        ListView listView = new ListView(this);

    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


    @Override
    public void showStatus(String msg) {
        splashTitle.setText(msg);
    }
}
