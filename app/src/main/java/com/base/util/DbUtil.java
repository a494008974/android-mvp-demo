package com.base.util;

import android.content.Context;

import com.data.entity.DaoMaster;
import com.data.entity.DaoSession;
import com.data.entity.User;
import com.data.entity.Zhou;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

/**
 * Created by Administrator on 2017/8/18.
 */
public class DbUtil {
    public static final boolean ENCRYPTED = false;
    private static DaoSession daoSession;
    public static void init(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, ENCRYPTED ? "zmvp-db-encrypted" : "zmvp-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static void delete(Object obj){
        if(daoSession == null){
            return ;
        }
        AbstractDao dao;
        if(obj instanceof User){
            dao = daoSession.getUserDao();
            dao.delete((User) obj);
        }else if(obj instanceof Zhou){
            dao = daoSession.getZhouDao();
            dao.delete((Zhou)obj);
        }
    }

    public static void insertOrReplace(Object obj){
        if(daoSession == null){
            return ;
        }
        AbstractDao dao;
        if(obj instanceof User){
            dao = daoSession.getUserDao();
            dao.insertOrReplace((User) obj);
        }else if(obj instanceof Zhou){
            dao = daoSession.getZhouDao();
            dao.insertOrReplace((Zhou)obj);
        }
    }


}
