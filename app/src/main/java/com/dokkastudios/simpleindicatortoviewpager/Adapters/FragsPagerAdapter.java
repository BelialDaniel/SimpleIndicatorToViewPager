package com.dokkastudios.simpleindicatortoviewpager.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dokkastudios.simpleindicatortoviewpager.Classes.FragmentF;
import com.dokkastudios.simpleindicatortoviewpager.Classes.Fragments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BelialDaniel on 9/16/17.
 */

public class FragsPagerAdapter extends FragmentPagerAdapter
{
    private List<String> _mTitles = null;
    private List<Fragments> _mFragments = null;

    public FragsPagerAdapter(FragmentManager _fm)
    {
        super(_fm);
        _mFragments = new ArrayList<>();
        _mTitles = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position)
    {
        return _mFragments.get(position);
    }

    public void addFragment(Class _class, String _name)
    {
        _mFragments.add(FragmentF.getFragment(_class));
        _mTitles.add(_name);
    }

    public void addFragment(Class _class)
    {
        _mFragments.add(FragmentF.getFragment(_class));
    }

    @Override
    public int getCount()
    {
        return _mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return _mTitles.get(position);
    }
}