package com.zia.gankcqupt_mvp.View.Activity.Interface;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

/**
 * Created by zia on 2017/5/19.
 */

public interface IRecyclerActivity {
    String getFlag();
    void toast(String msg);
    Activity getActivity();
    SwipeRefreshLayout getSwipeFreshLayout();
    RecyclerView getRecyclerView();
}
