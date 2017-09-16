package com.dokkastudios.simpleindicatortoviewpager.Classes;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by BelialDaniel on 9/16/17.
 */

public class PagerIndicator implements ViewPager.OnPageChangeListener
{
    private Context _mContext = null;

    private int _mCountIndicators = 0;

    private LinearLayout _mLayoutPagerDotIndicator = null;
    private ImageView[] _mIndicators = null;

    private Drawable _mDefaultIndicator = null;
    private Drawable _mSelectedIndicator = null;


    /**
     *
     * @param _context
     * @param _layoutPagerDotIndicator
     * @param _countIndicators
     */
    public PagerIndicator(Context _context, LinearLayout _layoutPagerDotIndicator, int _countIndicators)
    {
        _mContext = _context;
        _mLayoutPagerDotIndicator = _layoutPagerDotIndicator;
        _mCountIndicators = _countIndicators;
    }

    /**
     *
     * @param _defaultIndicator
     * @param _selectedIndicator
     * @param _theme
     */
    public void setIndicators(int _defaultIndicator, int _selectedIndicator, @Nullable Resources.Theme _theme)
    {
        _mIndicators = new ImageView[_mCountIndicators];

        _mDefaultIndicator  = _mContext.getResources().getDrawable(_defaultIndicator, _theme);
        _mSelectedIndicator = _mContext.getResources().getDrawable(_selectedIndicator, _theme);

        for(int i = 0; i < _mCountIndicators; i++)
        {
            _mIndicators[i] = new ImageView(_mContext);
            _mIndicators[i].setImageDrawable(_mDefaultIndicator);

            LinearLayout.LayoutParams _params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            _params.setMargins(2, 0, 2, 0);

            _mLayoutPagerDotIndicator.addView(_mIndicators[i], _params);
        }

        _mIndicators[0].setImageDrawable(_mSelectedIndicator);
    }

    /**
     *
     * @param _position
     */
    private void setIndicatorSelected(int _position)
    {
        for (int i = 0; i < _mCountIndicators; i++)
            _mIndicators[i].setImageDrawable(_mDefaultIndicator);
        _mIndicators[_position].setImageDrawable(_mSelectedIndicator);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    @Override
    public void onPageSelected(int position)
    {
        setIndicatorSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {

    }
}
