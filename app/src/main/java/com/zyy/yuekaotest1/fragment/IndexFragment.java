package com.zyy.yuekaotest1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyy.yuekaotest1.R;

import java.util.ArrayList;
import java.util.List;



public class IndexFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.index_fragment,container,false);
        initView(view);
        init();
        return view;
    }

    private void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("Tab"+i);
        }
    }

    private void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment;
              if (position==0){
                  fragment=new AFragment();
              }else if (position==1){
                  fragment=new BFragment();
              }else{
                  fragment=new Fragment03();
              }
                return fragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
