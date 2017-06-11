package com.zyy.yuekaotest1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyy.yuekaotest1.R;

/**
 * description
 * Created by 张芸艳 on 2017/6/10.
 */

public class Fragment03 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment03,container,false);
        return view;
    }

}
