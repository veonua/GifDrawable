package com.veon.example.GifDemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Fragment adapter
 *
 * Created by Veon on 1/4/14.
 */
class FragmentAdapter extends FragmentStatePagerAdapter {
    final static String[] gifs = new String[] {
            "http://i.imgur.com/3elUgix.gif"
            ,"http://i.imgur.com/jELtHBn.gif"
            ,"http://i.imgur.com/S6aA4hc.gif"
            ,"http://i.imgur.com/WvzAsyu.gif"
            ,"http://i.imgur.com/j1O6Od5.gif"
            ,"http://i.imgur.com/y6t8R4J.gif"
            ,"http://i.imgur.com/LfATMUs.gif"
            ,"http://i.imgur.com/GgBqmZn.gif"
            ,"http://i.imgur.com/sNjESje.gif"
            ,"https://31.media.tumblr.com/e898d150a3d680b3a63d24df0a89193f/tumblr_mxnycsZ9L11t5ao9no1_500.gif"
            ,"http://i.imgur.com/ujJPn30.gif"
            ,"http://i.imgur.com/Fy4S1jR.gif"
            ,"http://i.imgur.com/T0v9LK5.gif"
            ,"http://i.imgur.com/cbuox1W.gif"
            ,"http://i.imgur.com/E565OXt.gif"
            ,"http://i.imgur.com/zGl6U4s.gif"
            ,"http://giant.gfycat.com/QuerulousFickleIrishdraughthorse.gif"
            ,"http://i.imgur.com/wziQLhc.gif"
            ,"http://imgur.com/7lUAOuC"
            ,"http://s3-ec.buzzfed.com/static/2013-12/enhanced/webdr07/24/7/anigif_enhanced-buzz-2084-1387886716-6.gif"
            ,"http://i.imgur.com/qL17ztK.gif"
            ,"http://i.imgur.com/fKI9jZ5.gif"
            ,"http://imgur.com/1WsMvyZ"
            ,"http://i.imgur.com/Hf8wrGK.gif"
            ,"http://4.bp.blogspot.com/-s9CU7sCu7MM/Ulqh1FV-CTI/AAAAAAAACXg/mHBmDBhOGKs/s320/Baboon+Grabs+Reporter.gif"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        ImageViewFragment f = new ImageViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", gifs[i]);
        f.setArguments(bundle);
        return f;
    }

    @Override
    public int getCount() {
        return gifs.length;
    }
}
