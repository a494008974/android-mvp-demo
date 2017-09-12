package com.ui.main;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.base.BaseActivity;
import com.base.util.AnimationUtil;
import com.view.widget.ContentView;

import butterknife.Bind;

public class MainActivity extends BaseActivity<MainPresenter,MainModel> implements MainContract.View, View.OnFocusChangeListener,View.OnKeyListener,View.OnClickListener{

    @Bind(R.id.main_content)
    RelativeLayout mainContent;

    @Bind(R.id.focus)
    ImageView focus;

    private boolean animType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        if(mainContent != null){
            for(int i=0; i<mainContent.getChildCount(); i++){
                ContentView mContentView = (ContentView) mainContent.getChildAt(i);
                mContentView.setOnKeyListener(this);
                mContentView.setOnFocusChangeListener(this);
                mContentView.setOnClickListener(this);
            }
        }
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


    @Override
    public void showStatus(String msg) {

    }

    @Override
    public void onClick(View v) {
        System.out.println("onClick ==> "+v.getId());
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus){
            focus.setVisibility(View.VISIBLE);
            focus.bringToFront();
            AnimationUtil.moveFocus(v,focus,animType);
            animType = true;
        }else{
            AnimationUtil.cancleFocus(v,animType);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        animType = false;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            System.out.println("KeyEvent.ACTION_DOWN ==> "+v.getId());
        }
        return false;
    }
}
