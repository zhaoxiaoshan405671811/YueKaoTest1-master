package com.zyy.yuekaotest1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyy.yuekaotest1.R;
import com.zyy.yuekaotest1.bean.Bean;

import java.util.List;
import java.util.Random;



public class BAdapter extends RecyclerView.Adapter<BAdapter.CViewHolder> {
    private LayoutInflater inflater;
    private List<Bean> list;
    private Context context;

    public BAdapter(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public BAdapter.CViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.b_fragment_item, parent, false);

        CViewHolder viewHolder = new CViewHolder(view);
        ViewGroup.LayoutParams layoutParams = viewHolder.iv.getLayoutParams();
        Random random=new Random();
        int i = random.nextInt(400)+100;
        layoutParams.height=i;
        viewHolder.iv.setLayoutParams(layoutParams);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BAdapter.CViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView iv;

        public CViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.b_title);
            iv= (ImageView) itemView.findViewById(R.id.iv);

        }
    }
}
