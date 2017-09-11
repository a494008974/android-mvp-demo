package com.ui.splash;

import com.data.entity.LZBaseInfo;

/**
 * Created by Administrator on 2017/8/15.
 */
public class SplashModel implements SplashContract.Model {

    @Override
    public void configdefaultData() {
        for(int i=0; i<9; i++){
            for (int j=0; j<15; j++){
                LZBaseInfo info = new LZBaseInfo();
                info.setPkg("zhou"+i+"<===>"+j);
                if((j+1)/10 > 0){
                    info.setTag((i+1)+""+(j+1));
                }else{
                    info.setTag((i+1)+"0"+(j+1));
                }
            }
        }
    }
}
