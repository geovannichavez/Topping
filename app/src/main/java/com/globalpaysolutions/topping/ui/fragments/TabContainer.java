package com.globalpaysolutions.topping.ui.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.globalpaysolutions.topping.R;
import com.globalpaysolutions.topping.ui.adapters.ViewPagerAdapter;


public class TabContainer extends Fragment
{
    public TabContainer()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tab_container, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new TabHistoryToday(), "Today");
        adapter.addFragment(new TabHistoryYesterday(),"Yesterday");
        adapter.addFragment(new TabHistoryWeek(), "Week");
        /*adapter.addFragment(new TabHistoryToday(), "Today");
        adapter.addFragment(new TabHistoryYesterday(),"Yesterday");
        adapter.addFragment(new TabHistoryWeek(), "Week");
        adapter.addFragment(new TabHistoryToday(), "Today");
        adapter.addFragment(new TabHistoryYesterday(),"Yesterday");
        adapter.addFragment(new TabHistoryWeek(), "Week");*/
        viewPager.setAdapter(adapter);
    }

}
