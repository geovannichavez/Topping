package com.globalpaysolutions.topping.views;

import com.globalpaysolutions.topping.models.CountryOperator;

import java.util.List;

/**
 * Created by Josué Chávez on 19/06/2017.
 */

public interface HomeView
{
    void initializeDrawer();
    void setInitialFragment();
    boolean navigationItemSelected(int id);
}
