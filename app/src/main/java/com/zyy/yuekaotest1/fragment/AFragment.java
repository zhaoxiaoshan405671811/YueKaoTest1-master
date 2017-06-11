package com.zyy.yuekaotest1.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zyy.yuekaotest1.DetailActivity;
import com.zyy.yuekaotest1.R;
import com.zyy.yuekaotest1.adapter.AAdapter;
import com.zyy.yuekaotest1.bean.Bean;

import java.util.ArrayList;
import java.util.List;



public class AFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Bean> list = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private AAdapter aAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, container, false);
        initView(view);
        init();
        return view;
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler01);
    }

    private void init() {
        for (int i = 0; i < 10; i++) {
            list.add(new Bean("Title" + i, "The description of the news content" + i));
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        aAdapter = new AAdapter(list, getActivity());

        recyclerView.setAdapter(aAdapter);
        aAdapter.setOnItemClickListener(new AAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("content", list.get(postion).getContent());
                startActivity(intent);
            }
        });
        //设置布局管理器
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        //添加分隔线
        recyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(Color.GRAY)
                        .build());
    }
}
