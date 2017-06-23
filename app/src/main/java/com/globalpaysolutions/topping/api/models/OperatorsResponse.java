package com.globalpaysolutions.topping.api.models;

import com.globalpaysolutions.topping.models.Operators;

/**
 * Created by Josué Chávez on 22/06/2017.
 */

public class OperatorsResponse
{
    private Operators operators;
    private Integer count;

    public Operators getOperators()
    {
        return operators;
    }

    public void setOperators(Operators operators)
    {
        this.operators = operators;
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }
}
