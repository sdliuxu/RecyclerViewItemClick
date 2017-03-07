package com.geocompass.zqapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geocompass.zqapp.DetailActivity;
import com.geocompass.zqapp.MainActivity;
import com.geocompass.zqapp.R;

/**
 * Created by liuxu on 2017/3/5.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private static final String TAG = "NewsAdapter";
    private Context mContext;
    private onRecyclerViewItemClickListener itemClickListener;
    private String[] titles = new String[]{
            "•习近平：青年要自觉践行社会主义核心价值观",
            "•习近平在布鲁日欧洲学院的演讲",
            "•习近平同欧洲理事会主席范龙佩举行会谈",
            "•习近平在比利时《晚报》发表署名文章",
            "•习近平在德国科尔伯基金会的演讲（全文）",
            "•习近平在德国《法兰克福汇报》发表署名文章",
            "•在中法建交五十周年纪念大会上的讲话",
            "•习近平在联合国教科文组织总部的演讲",
            "•习近平在法国《费加罗报》发表署名文章",
            "•习近平在荷兰《新鹿特丹商业报》发表署名文章"
    };
    private String[] times = new String[]{
            "2014-05-05 07:04",
            "2014-04-02 07:11",
            "2014-04-01 07:11",
            "2014-03-30 07:48",
            "2014-03-30 07:47",
            "2014-03-29 08:12",
            "2014-03-29 08:02",
            "2014-03-28 07:05",
            "2014-03-26 07:05",
            "2014-03-25 06:57",
    };


    public NewsAdapter(MainActivity mainActivity) {
        this.mContext = mainActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemNews = LayoutInflater.from(mContext).inflate(R.layout.news_item, null);
        itemNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, (Integer) v.getTag());
                }
            }
        });
        return new MyViewHolder(itemNews);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int position) {
        holder.tv_titile.setText(titles[position]);
        holder.tv_time.setText(times[position]);
        holder.itemView.setTag(position);
        this.setOnItemClickListener(new onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
//                Log.e(TAG, "onItemClick: " + position);
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("position",position);
                mContext.startActivity(intent);
            }
        });

    }

    public void setOnItemClickListener(onRecyclerViewItemClickListener listener) {
        this.itemClickListener = listener;
    }


    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView tv_titile;
        TextView tv_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_titile = (TextView) itemView.findViewById(R.id.tv_news_title);
        }

    }

    public interface onRecyclerViewItemClickListener {
        void onItemClick(View v, int position);
    }
}
