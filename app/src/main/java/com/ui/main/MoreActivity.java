package com.ui.main;

import android.content.Context;
import android.widget.GridView;
import android.widget.ListView;

import com.base.BaseActivity;
import com.base.CommonAdapter;
import com.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MoreActivity extends BaseActivity {

    @Bind(R.id.grid_view)
    GridView mGridView;

    private MoreAdapter mMoreAdapter;
    private List<String> mDatas;
    @Override
    public int getLayoutId() {
        return R.layout.activity_more;
    }

    @Override
    public void initView() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
        mMoreAdapter = new MoreAdapter(this,mDatas,R.layout.more_grid_view_item);

        mGridView.setAdapter(mMoreAdapter);
    }

    @Override
    public void initPresenter() {

    }

    class MoreAdapter extends CommonAdapter<String>{

        public MoreAdapter(Context context, List<String> mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(ViewHolder helper, String item) {
            helper.setText(R.id.grid_view_tv,item);
        }
    }
}
