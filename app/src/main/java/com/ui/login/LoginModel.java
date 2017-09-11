package com.ui.login;

import com.api.LZApi;
import com.base.util.helper.RxSchedulers;
import com.data.CreatedResult;
import com.data.Data;
import com.data.entity.StreamInfo;
import com.data.entity._User;

import rx.Observable;

/**
 * Created by baixiaokang on 16/5/2.
 */
public class LoginModel implements LoginContract.Model {

    @Override
    public Observable<_User> login(String name, String pass) {
//        return Api.getInstance().movieService
//                .login(name, pass)
//                .compose(RxSchedulers.io_main());
        return LZApi.getInstance().remoteService
                .login(name, pass)
                .compose(RxSchedulers.io_main());
    }

    @Override
    public Observable<CreatedResult> sign(String name, String pass) {
//        return Api.getInstance().movieService
//                .createUser(new _User(name, pass))
//                .compose(RxSchedulers.io_main());
        return LZApi.getInstance().remoteService
                .createUser(new _User(name, pass))
                .compose(RxSchedulers.io_main());
    }

    @Override
    public Observable<Data<StreamInfo>> getStreamList(int skip, int limit) {
        return LZApi.getInstance().remoteService
                .getStreamList(skip,limit)
                .compose(RxSchedulers.io_main());
    }
}
