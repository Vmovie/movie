package com.qf.vmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.vmovie.DetailActivity;
import com.qf.vmovie.R;
import com.qf.vmovie.bean.RecyclerViewBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Shouye_RecyclerView_Adapter extends RecyclerView.Adapter<Shouye_RecyclerView_Adapter.MyViewHolder> implements View.OnClickListener {

    private int flag=1;
    private Context context;
    private List<RecyclerViewBean.DataBean> mRecyclerViewBean;
    //  private List<ViewPagerBean> mViewPagerBean;
    private List<ImageView> mImageViews = new ArrayList<>();
    private Shouye_Position1_ViewPagerAdapter mShouye_position1_viewPagerAdapter;
    private RecyclerView mRecyclerView;
    private String id=null;
    private String url;
    private TextPaint mTextPaint;
    private SharedPreferences sp;

    public Shouye_RecyclerView_Adapter(Context context, List<RecyclerViewBean.DataBean> mRecyclerViewBean) {
        this.context = context;
        this.mRecyclerViewBean = mRecyclerViewBean;
    }

    public void setRecyclerViewBean(List<RecyclerViewBean.DataBean> recyclerViewBean) {
        mRecyclerViewBean = recyclerViewBean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.shouye_zuixin_position2, parent, false);

        //给item设置监听事件
        itemView.setOnClickListener(this);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Picasso.with(context)
                .load(mRecyclerViewBean.get(position).getImage())
                .into(holder.item_image);

        //题目
        holder.title.setText(mRecyclerViewBean.get(position).getTitle());
        //类型
        holder.catename.setText(mRecyclerViewBean.get(position).getCates().get(0).getCatename());

        int time=Integer.parseInt(mRecyclerViewBean.get(position).getDuration());

        if (time <=60) {
            holder.duration.setText(time+"＂");
        }else if(time>60){
            int minutes= (int) Math.floor(time/60);
             int seconds= time%60;

            holder.duration.setText(""+minutes+"'"+seconds+"＂");
        }

        //给字体加粗
        mTextPaint=holder.catename.getPaint();
        mTextPaint=holder.duration.getPaint();
        mTextPaint=holder.title.getPaint();
        mTextPaint.setFakeBoldText(true);

        //加载更多
        if (position == getItemCount()-1) {
            flag++;
            //s设置一个标记

            sp=context.getSharedPreferences("ddd",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putInt("signal",flag);
            editor.commit();

        }

    }

    @Override
    public int getItemCount() {
        return mRecyclerViewBean != null ? mRecyclerViewBean.size() : 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView=recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecyclerView=null;
    }

    //RecyclerView的item 的点击事件
    @Override
    public void onClick(View view) {
        int position=mRecyclerView.getChildAdapterPosition(view);

        id=mRecyclerViewBean.get(position).getPostid();
        url=mRecyclerViewBean.get(position).getRequest_url();

        Intent intent = new Intent(context, DetailActivity.class);

        intent.putExtra("postId",id);
        intent.putExtra("url",url);

        context.startActivity(intent);

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        //ViewPager viewPager;
        TextView title, catename, duration;
        ImageView item_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            catename = (TextView) itemView.findViewById(R.id.catename);
            duration = (TextView) itemView.findViewById(R.id.duration);
            item_image = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }

}
