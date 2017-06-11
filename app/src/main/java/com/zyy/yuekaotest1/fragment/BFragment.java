package com.zyy.yuekaotest1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyy.yuekaotest1.R;
import com.zyy.yuekaotest1.adapter.BAdapter;
import com.zyy.yuekaotest1.bean.Bean;

import java.util.ArrayList;
import java.util.List;


public class BFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Bean> list = new ArrayList<>();
    private StaggeredGridLayoutManager staggeredGridLayoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02, container, false);
        initView(view);
        init();
        return view;
    }

    private void init() {
        for (int i = 0; i < 10; i++) {
            list.add(new Bean("Title" + i));
        }
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler02);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        BAdapter bAdapter = new BAdapter(list, getActivity());

        recyclerView.setAdapter(bAdapter);

        //设置布局管理器
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//        //添加分隔线
//        recyclerView.addItemDecoration(
//                new HorizontalDividerItemDecoration.Builder(getActivity())
//                        .color(Color.GRAY)
//                        .build());
    }
}
