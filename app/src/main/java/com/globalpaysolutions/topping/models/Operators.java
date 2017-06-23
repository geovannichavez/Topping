package com.globalpaysolutions.topping.models;

import java.util.List;

/**
 * Created by Josué Chávez on 22/06/2017.
 */

public class Operators
{
    private List<CountryOperator> countryOperators = null;

    public List<CountryOperator> getCountryOperators()
    {
        return countryOperators;
    }

    public void setCountryOperators(List<CountryOperator> countryOperators)
    {
        this.countryOperators = countryOperators;
    }
}
