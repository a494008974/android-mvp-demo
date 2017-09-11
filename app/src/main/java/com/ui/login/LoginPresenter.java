package com.ui.login;

import com.C;
import com.base.util.SpUtil;
import com.data.Data;
import com.data.entity.StreamInfo;

import rx.functions.Action1;

/**
 * Created by baixiaokang on 16/4/29.
 */
public class LoginPresenter extends LoginContract.Presenter {

    @Override
    public void login(String name, String pass) {
        mRxManage.add(mModel.login(name, pass).subscribe(user -> {
                    SpUtil.setUser(user);
                    mRxManage.post(C.EVENT_LOGIN, user);
                    mView.loginSuccess();
                }, e -> mView.showMsg("登录失败!")
        ));
    }

    @Override
    public void sign(String name, String pass) {
        mRxManage.add(mModel.sign(name, pass)
                .subscribe(res -> mView.signSuccess(),
                        e -> mView.showMsg("注册失败!")));
    }

    @Override
    public void test() {
        mRxManage.add(mModel.getStreamList(0, 10).subscribe(new Action1<Data<StreamInfo>>() {
            @Override
            public void call(Data<StreamInfo> streamInfoData) {
                System.out.println("===============>streamInfoData start<=================");

                if(streamInfoData != null){
                    if(streamInfoData.results != null){
                        for (int i=0; i<streamInfoData.results.size(); i++){
                            StreamInfo info = streamInfoData.results.get(i);
                            System.out.println("==========>"+info.getPicture().getUrl());
                        }
                    }
                }

                System.out.println("===============>streamInfoData end<=================");
            }
        }));
    }
}
