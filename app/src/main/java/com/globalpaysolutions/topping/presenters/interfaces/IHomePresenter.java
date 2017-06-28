package com.globalpaysolutions.topping.presenters.interfaces;

/**
 * Created by Josué Chávez on 19/06/2017.
 */

public interface IHomePresenter
{
    void initializeViews();
    void setInitialFragment();
    boolean handleMenuItemSelected(int pID);
}
