package com.qf.vmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.vmovie.R;
import com.qf.vmovie.bean.PindaoBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class Shouye_PindaoAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    private List<PindaoBean.DataBean> list;

    public Shouye_PindaoAdapter(Context context, List<PindaoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        MyViewHolder holder;

        if (convertView == null) {

            //初始化inflate
            inflater = LayoutInflater.from(context);

            convertView = inflater.inflate(R.layout.gridview_item, parent, false);

            holder = new MyViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.gridView_itemImage);
            holder.title_tv = (TextView) convertView.findViewById(R.id.title_name);

            convertView.setTag(holder);
        } else {

            holder = (MyViewHolder) convertView.getTag();
        }

        //下载图片并设置
        Picasso.with(context).load(list.get(i).getIcon())
                .into(holder.imageView);
        //设置文字
        holder.title_tv.setText(list.get(i).getCatename());

        return convertView;
    }

    public void setList(List<PindaoBean.DataBean> list) {
        this.list = list;
    }

    static class MyViewHolder {

        public ImageView imageView;
        public TextView title_tv;
    }
}
