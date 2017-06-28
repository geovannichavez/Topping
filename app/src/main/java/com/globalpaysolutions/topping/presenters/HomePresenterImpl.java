package com.globalpaysolutions.topping.presenters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.globalpaysolutions.topping.interactors.MainInteractor;
import com.globalpaysolutions.topping.presenters.interfaces.IHomePresenter;
import com.globalpaysolutions.topping.views.HomeView;

/**
 * Created by Josué Chávez on 19/06/2017.
 */

public class HomePresenterImpl implements IHomePresenter
{
    private static final String TAG = HomePresenterImpl.class.getSimpleName();
    private Context mContext;
    HomeView mView;

    public HomePresenterImpl(Context pContext, AppCompatActivity pActivity, HomeView pView)
    {
        this.mContext = pContext;
        this.mView = pView;
    }

    @Override
    public void initializeViews()
    {
        mView.initializeDrawer();
        mView.setInitialFragment();
    }

    @Override
    public void setInitialFragment()
    {
        mView.setInitialFragment();
    }

    @Override
    public boolean handleMenuItemSelected(int pID)
    {
        Log.i(TAG, "Item Id clicked: " + String.valueOf(pID));
        return mView.navigationItemSelected(pID);
    }

}
