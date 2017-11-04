package io.aditilabs.mobilecomputingproject.View.Activity;


import android.app.ActionBar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.Html;

import io.aditilabs.mobilecomputingproject.R;
import io.aditilabs.mobilecomputingproject.View.Adapter.SectionsPagerAdapter;

public class MainActivity extends BaseActivity implements android.support.v7.app.ActionBar.TabListener{


    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager mViewPager;
    android.support.v7.app.ActionBar actionBar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(sectionsPagerAdapter);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#F7FBFB\">" + getString(R.string.app_name) + "</font>"));

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        for (int i = 0; i < sectionsPagerAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(sectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }

    }


    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}
