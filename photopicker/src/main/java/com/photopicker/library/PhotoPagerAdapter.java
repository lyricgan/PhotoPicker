package com.photopicker.library;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class PhotoPagerAdapter<T extends IPhoto> extends PagerAdapter {
    private final List<T> mData;

    public PhotoPagerAdapter(List<T> mData) {
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return onInstantiateItem(container, position, mData.get(position));
    }

    protected abstract View onInstantiateItem(ViewGroup container, int position, T item);
}
