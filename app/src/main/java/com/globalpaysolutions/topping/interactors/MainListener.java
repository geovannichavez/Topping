package com.globalpaysolutions.topping.interactors;

import com.globalpaysolutions.topping.models.CountryOperator;

import java.util.List;

/**
 * Created by Josué Chávez on 22/06/2017.
 */

public interface MainListener
{
    void onError(int pCodeStatus, Throwable pThrowable);
    void onGetOperatorsSuccess(List<CountryOperator> pCountryOperators);
}
