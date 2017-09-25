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

    private LinearLayout _mLayoutPagerIndicator = null;
    private ImageView[] _mIndicators = null;

    private Drawable _mUnselectedIndicator = null;
    private Drawable _mSelectedIndicator = null;


    /**
     * Here you need to set the Layout that contains the Indicator and the number of indicator that appear
     * @param _context The context that contain the viewpager
     * @param _layoutPagerIndicator The layout that contain the indicators
     * @param _countIndicators The number of indicators
     */
    public PagerIndicator(Context _context, LinearLayout _layoutPagerIndicator, int _countIndicators)
    {
        _mContext = _context;
        _mLayoutPagerIndicator = _layoutPagerIndicator;
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

        _mUnselectedIndicator = _mContext.getResources().getDrawable(_defaultIndicator, _theme);
        _mSelectedIndicator = _mContext.getResources().getDrawable(_selectedIndicator, _theme);

        for(int i = 0; i < _mCountIndicators; i++)
        {
            _mIndicators[i] = new ImageView(_mContext);
            _mIndicators[i].setImageDrawable(_mUnselectedIndicator);

            LinearLayout.LayoutParams _params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            _params.setMargins(0, 0, 0, 0);

            _mLayoutPagerIndicator.addView(_mIndicators[i], _params);
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
            _mIndicators[i].setImageDrawable(_mUnselectedIndicator);
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
