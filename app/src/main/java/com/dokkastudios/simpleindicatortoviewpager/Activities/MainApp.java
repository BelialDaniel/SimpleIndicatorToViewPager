package com.dokkastudios.simpleindicatortoviewpager.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.dokkastudios.simpleindicatortoviewpager.Adapters.FragsPagerAdapter;
import com.dokkastudios.simpleindicatortoviewpager.Classes.PagerIndicator;
import com.dokkastudios.simpleindicatortoviewpager.Fragments.FOne;
import com.dokkastudios.simpleindicatortoviewpager.Fragments.FTwo;
import com.dokkastudios.simpleindicatortoviewpager.R;

public class MainApp extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main_app);

        FragsPagerAdapter _frags = new FragsPagerAdapter(getSupportFragmentManager());

        _frags.addFragment(FOne.class);
        _frags.addFragment(FTwo.class);

        ViewPager _vp = (ViewPager) findViewById(R.id._viewPagerBackFragments);
        _vp.setAdapter(_frags);
        _vp.setCurrentItem(0, true);

        PagerIndicator _pi = new PagerIndicator(getApplicationContext(), (LinearLayout) findViewById(R.id._indicators), _frags.getCount());
        _pi.setIndicators(R.drawable.indicator_unselected, R.drawable.indicator_selected, null);

        _vp.addOnPageChangeListener(_pi);
    }
}