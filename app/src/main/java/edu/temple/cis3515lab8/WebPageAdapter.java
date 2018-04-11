package edu.temple.cis3515lab8;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Steve on 4/10/2018.
 */

public class WebPageAdapter extends FragmentStatePagerAdapter {
    private ArrayList<WebFragment> webFragList;

    public WebPageAdapter(FragmentManager fm){
        super(fm);
        webFragList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return webFragList.get(position);
    }

    @Override
    public int getCount() {
        return webFragList.size();
    }

    public void createNewWebFragment(){
        webFragList.add(new WebFragment());
        notifyDataSetChanged();
    }
}
