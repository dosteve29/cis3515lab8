package edu.temple.cis3515lab8;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Steve on 4/10/2018.
 */

public class WebPageAdapter extends FragmentStatePagerAdapter {

    public WebPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new WebFragment();
        Bundle args = new Bundle();
        args.putInt(WebFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return "OBJECT " + (position + 1);
    }
}
