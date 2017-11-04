package io.aditilabs.mobilecomputingproject.View.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import io.aditilabs.mobilecomputingproject.View.Fragment.HomeFragment;
import io.aditilabs.mobilecomputingproject.View.Fragment.TrendingFragment;
import io.aditilabs.mobilecomputingproject.View.Fragment.UploadFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter{

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new HomeFragment() ;

            case 1:return new TrendingFragment() ;

            case 2:return new UploadFragment() ;

            default: return new HomeFragment() ;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String pageTitle ;
        switch (position){
            case 0 : pageTitle = "Home" ;
            break;
            case 1 : pageTitle = "Favorites" ;
                break;
            case 2 : pageTitle = "Upload" ;
                break;

                default: pageTitle = "Home" ;
        }

        return pageTitle ;
    }
}
