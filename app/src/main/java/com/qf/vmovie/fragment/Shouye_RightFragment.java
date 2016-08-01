package com.qf.vmovie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.qf.vmovie.DetailActivity;
import com.qf.vmovie.R;
import com.qf.vmovie.adapter.Shouye_PindaoAdapter;
import com.qf.vmovie.bean.PindaoBean;
import com.qf.vmovie.paths.Path;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Shouye_RightFragment extends Fragment {

    private OkHttpClient mOkHttpClient;
    private List<PindaoBean.DataBean> mList = new ArrayList<>();
    private GridView mGridView;
    private Shouye_PindaoAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rightfragment, container, false);

        mGridView = (GridView) view.findViewById(R.id.rightFragment_GridView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();


        adapter=new Shouye_PindaoAdapter(getActivity(),mList);
        mGridView.setAdapter(adapter);

        //给GridView设置监听事件

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转到详情Activity
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                getActivity().startActivity(intent);
            }
        });

    }

    //下载数据
    private void initData() {
        mOkHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(Path.pinDaoPath)
                .build();

        final Call call = mOkHttpClient.newCall(request);

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Response response = call.execute();

                    PindaoBean bean=null;
                    bean = new Gson().fromJson(response.body().string(), PindaoBean.class);

                    if (bean != null) {

                        mList=bean.getData();

                        adapter.setList(mList);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //更新适配器
                                adapter.notifyDataSetChanged();

                            }
                        });

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
