package com.dokkastudios.simpleindicatortoviewpager.Classes;

import com.dokkastudios.simpleindicatortoviewpager.Fragments.FOne;

import com.dokkastudios.simpleindicatortoviewpager.Fragments.FTwo;

/**
 * Created by BelialDaniel on 9/16/17.
 */

public class FragmentF
{
    /**
     *
     * @param _class
     * @return
     */
    public static Fragments getFragment(Class _class)
    {
        Fragments _frag = null;

       if (FOne.class.isAssignableFrom(_class))
           _frag = new FOne();
        else if (FTwo.class.isAssignableFrom(_class))
            _frag = new FTwo();

        _frag.FRAGMENT_TAG = _class.getSimpleName();
        return _frag;
    }
}