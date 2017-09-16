package com.dokkastudios.simpleindicatortoviewpager.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dokkastudios.simpleindicatortoviewpager.Classes.Fragments;
import com.dokkastudios.simpleindicatortoviewpager.R;

public class FTwo extends Fragments
{
    public FTwo() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        _msView = inflater.inflate(R.layout.f_two, container, false);
        return _msView;
    }
}