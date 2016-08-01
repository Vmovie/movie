package com.qf.vmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qf.vmovie.bean.DetailBean;
import com.qf.vmovie.paths.Path;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class DetailActivity extends AppCompatActivity {

    private OkHttpClient mOkHttpClient;
    private WebView mWebView;
    private String postid;
    //private List<DetailBean.DataBean> mList=new ArrayList<>();
    private DetailBean.DataBean mDataBean = new DetailBean.DataBean();
    private TextView count_like;
    private TextView count_share;
    private TextView count_comment;
    private String url;
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        //下载数据
        initData();
        //初始化videoView
        initVideoView();


        //设置数据
        setData();

    }

    //初始化vitamio
    private void initVideoView() {

        mVideoView = (VideoView) findViewById(R.id.vitamio);

        //给Vitamio进行初始化
        Vitamio.isInitialized(this);

        //设置播放地址
        //  mVideoView.setVideoPath(path);
        mVideoView.start();


    }

    //设置对应的控件内容
    private void setData() {
        count_like.setText(mDataBean.getCount_like());
        count_share.setText(mDataBean.getCount_share());
        count_comment.setText(mDataBean.getCount_comment());

        WebSettings mWebSettings = mWebView.getSettings();

        //启用js支持
        mWebSettings.setJavaScriptEnabled(true);

        //js可以弹出窗体 对话框
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");

        mWebView.loadUrl(url);


    }

    //初始化控件
    private void initView() {
        //爱好的数量
        count_like = (TextView) findViewById(R.id.count_like);
        //分享的数量
        count_share = (TextView) findViewById(R.id.count_share);
        //评论的总数
        count_comment = (TextView) findViewById(R.id.count_comment);

        mWebView = (WebView) findViewById(R.id.webView);
    }

    //下载json数据
    private void initData() {

        mOkHttpClient = new OkHttpClient();

        FormEncodingBuilder builder = new FormEncodingBuilder();

        Intent intent = getIntent();
        postid = intent.getStringExtra("postId");

       // Log.e("1234", "eeee" + postid);

        builder.add("postid", "postId");

        Request request = new Request.Builder()
                .url(Path.detailPath)
                .post(builder.build())
                .build();

        final Call call = mOkHttpClient.newCall(request);

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Response response = call.execute();

                    DetailBean bean = null;
                    bean = new Gson().fromJson(response.body().string(), DetailBean.class);

                    Log.e("ggg", "ggg " + bean);
                    if (response != null) {

//                        mDataBean=bean.getData();

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }

    //底栏的点击事件
    public void onClick(View view) {

        switch (view.getId()) {
            //收藏
            case R.id.a:


                break;
            //分享
            case R.id.b:

                break;

            //评论
            case R.id.c:

                break;

            //缓存
            case R.id.d:

                break;

        }

    }


}
