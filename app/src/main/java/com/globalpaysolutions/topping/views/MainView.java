package com.globalpaysolutions.topping.views;

import com.globalpaysolutions.topping.models.CountryOperator;

import java.util.List;

/**
 * Created by Josué Chávez on 23/06/2017.
 */

public interface MainView
{
    void initializeViews();
    void renderOperators(List<CountryOperator> pOperators);
}
