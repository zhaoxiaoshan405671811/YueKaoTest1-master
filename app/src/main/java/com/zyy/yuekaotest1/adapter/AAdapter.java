package com.zyy.yuekaotest1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyy.yuekaotest1.R;
import com.zyy.yuekaotest1.bean.Bean;

import java.util.List;


public class AAdapter extends RecyclerView.Adapter<AAdapter.CViewHolder> {
    private LayoutInflater inflater;
    private List<Bean> list;
    private Context context;
    private MyItemClickListener mItemClickListener = null;

    public AAdapter(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public AAdapter.CViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.a_fragment_item, parent, false);

        CViewHolder viewHolder = new CViewHolder(view, mItemClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AAdapter.CViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface MyItemClickListener {
        void onItemClick(View view, int postion);
    }

    /**
     * 设置Item点击监听
     *
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    class CViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MyItemClickListener mListener;
        TextView title, content;

        public CViewHolder(View itemView, MyItemClickListener listener) {
            super(itemView);
            this.mListener = listener;
            title = (TextView) itemView.findViewById(R.id.a_title);
            content = (TextView) itemView.findViewById(R.id.a_content);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getPosition());
            }
        }
    }
}
