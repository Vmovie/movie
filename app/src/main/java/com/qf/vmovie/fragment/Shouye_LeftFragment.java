package com.qf.vmovie.fragment;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.qf.vmovie.R;
import com.qf.vmovie.adapter.Shouye_RecyclerView_Adapter;
import com.qf.vmovie.bean.RecyclerViewBean;
import com.qf.vmovie.paths.Path;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Shouye_LeftFragment extends Fragment {
    private OkHttpClient mOkHttpClient;
    private RecyclerView mRecyclerView;
    private List<RecyclerViewBean.DataBean> mRecyclerViewBean = new ArrayList<>();
    private Shouye_RecyclerView_Adapter mShouye_recyclerView_adapter;
    private LinearLayoutManager mLinearLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private int page =1;
   // private int flag=0;
    private SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.leftfragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.leftFragment_RecyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData(page);
        setData();


//        sp=getActivity().getSharedPreferences("ddd", Context.MODE_PRIVATE);
//        int flag=sp.getInt("signal",0);
//        //加载更多
//        if () {
//
//            page=flag;
//            initData(page);
//        }

        //布局管理器
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //给recyclerView设置布局管理器
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mSwipeRefreshLayout.setColorSchemeColors(Color.GREEN, Color.BLUE);
        mSwipeRefreshLayout.setDistanceToTriggerSync(100);
        //给刷新设置(手势)监听
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Thread(new Runnable() {
                    @Override

                    public void run() {
                        mRecyclerViewBean.clear();
                        initData(1);
                        //刷新适配器
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mShouye_recyclerView_adapter.notifyDataSetChanged();
                            }
                        });

                        if (mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }
                }).start();
            }
        });

        //这句话是为了首次进入就显示加载的动画
        mSwipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        //mSwipeRefreshLayout.setRefreshing(true);


        //item加载的动画效果
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

//
    }


    private void initData(int page) {


        //下载RecyclerView的json数据
        mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        // string = ""+url+int

        builder.add("p", "page");
        builder.add("size", "20");
        builder.add("tab", "latest");

        Request request = new Request.Builder()
                .url(Path.recyclerViewPath)
                .post(builder.build())//请求参数
                .build();

        final Call call = mOkHttpClient.newCall(request);

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Response response = call.execute();

                    if (response != null) {
                        RecyclerViewBean bean = null;

                        bean = new Gson().fromJson(response.body().string(), RecyclerViewBean.class);
                        //Log.e("AAAA", "33333"+bean );
                        if (bean != null) {

                            mRecyclerViewBean = bean.getData();
                            // Log.e("333", "=="+bean.getData().size());

                            mShouye_recyclerView_adapter.setRecyclerViewBean(mRecyclerViewBean);

                            getActivity().runOnUiThread(
                                    new Runnable() {
                                        @Override
                                        public void run() {

                                            mShouye_recyclerView_adapter.notifyDataSetChanged();

                                        }
                                    }
                            );
                        } else {
                            getActivity().runOnUiThread(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getContext(), "没有更多数据了哦", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                            );

                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


//        //下载viewPager中的json数据
//        Request request1 = new Request.Builder()
//                .url(Path.viewPagerPath)
//                .build();
//
//        final Call call1 = mOkHttpClient.newCall(request1);
//
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    Response response = call1.execute();
//
//                    if (response != null) {
//
//                        ViewPagerBean bean=null;
//                        bean = new Gson().fromJson(response.body().string(), ViewPagerBean.class);
//
//                        Log.e("2222", "++ "+response.body().string());
//
//                        if (bean != null) {
//
//                            mViewPagerBeen.add(bean);
//
//                            getActivity().runOnUiThread(
//                                    new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            mShouye_recyclerView_adapter.notifyDataSetChanged();
//                                        }
//                                    }
//                            );
//                        } else {
//
//                        }
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

    }

    private void setData() {
        //初始化首页的最新模块的adapter
        mShouye_recyclerView_adapter = new Shouye_RecyclerView_Adapter(getActivity(), mRecyclerViewBean);

        mRecyclerView.setAdapter(mShouye_recyclerView_adapter);
    }

}
