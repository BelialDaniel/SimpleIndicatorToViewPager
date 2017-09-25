package com.dokkastudios.simpleindicatortoviewpager.Classes;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by BelialDaniel on 9/16/17.
 */

public class Fragments extends Fragment
{
    protected int mColumnCount = 1;

    public String FRAGMENT_TAG = "";

    protected View _msView = null;
    protected Context _msContext = null;

    public Fragments() {}

    /**
     * Call this when you work with a RecyclerView
     * @return return the reciclerview
     */
    public RecyclerView getRecyclerView()
    {
        RecyclerView recyclerView = null;
        if (_msView instanceof RecyclerView)
        {
            Context context = _msView.getContext();
            recyclerView = (RecyclerView) _msView;
            recyclerView.setHasFixedSize(true);

            if (mColumnCount <= 1)
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            else
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        return recyclerView;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        _msContext = context;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }
}