package com.ui.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity<MainPresenter,MainModel> implements MainContract.View{

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private List<String> mDatas;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {


        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }

        MainAdapter adapter = new MainAdapter();
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,5));

        mRecyclerView.setAdapter(adapter);

//        Intent intent = new Intent();
//        intent.setAction("com.starcor.hunan.mgtv");
//        startActivity(intent);

//        Intent intent = new Intent();
//        intent.setAction("com.starcor.hunan.mgtv");
//        intent.putExtra("cmd_ex", "mgtv_jump");
//        intent.putExtra("action_source_id", "xxxx");
//        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
//        sendBroadcast(intent);

//分类接口
//        Intent intent = new Intent();
//        intent.setAction("com.hunantv.license");
//        intent.putExtra("cmd_ex", "show_filmlibrary");
//        intent.putExtra("pageType", "1");
//        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
//        sendBroadcast(intent);
//        综艺 pageType 1
//        电视剧 pageType 2
//        电影 pageType 3
//        教育 pageType 115


//        Intent intent = new Intent();
//        intent.setAction("com.hunantv.license");
//        intent.putExtra("cmd_ex", "mgtv_jump");
//        intent.putExtra("jumpKind", "1");
//        intent.putExtra("jumpId", "51294");
////        intent.putExtra("playpartId", "4096654");
//        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
//        sendBroadcast(intent);
//
//          System.out.println(intent.toUri(0));
//        this.finish();
//        return;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


    @Override
    public void showStatus(String msg) {

    }


    public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MainViewHolder holder = new MainViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.main_recycler_item, parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MainViewHolder mainViewHolder = (MainViewHolder)holder;
            mainViewHolder.id_num.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        public class MainViewHolder extends RecyclerView.ViewHolder{
            TextView id_num;
            public MainViewHolder(View view) {
                super(view);
                id_num = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }
}
