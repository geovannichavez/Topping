package com.globalpaysolutions.topping.presenters;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.globalpaysolutions.topping.interactors.MainInteractor;
import com.globalpaysolutions.topping.interactors.MainListener;
import com.globalpaysolutions.topping.models.CountryOperator;
import com.globalpaysolutions.topping.presenters.interfaces.IMainPresenter;
import com.globalpaysolutions.topping.views.MainView;

import java.util.List;

/**
 * Created by Josué Chávez on 23/06/2017.
 */

public class MainPresenterImpl implements IMainPresenter, MainListener
{
    private static final String TAG = MainPresenterImpl.class.getSimpleName();

    private Context mContext;
    private MainView mView;
    private MainInteractor mInteractor;

    public MainPresenterImpl(Context pContext, Fragment pFragment, MainView pView)
    {
        this.mContext = pContext;
        this.mView = pView;
        this.mInteractor = new MainInteractor(mContext);
    }

    @Override
    public void initializeViews()
    {
        mView.initializeViews();
    }

    @Override
    public void fetchOperators()
    {
        mInteractor.fetchOperators(this);
    }

    @Override
    public void onError(int pCodeStatus, Throwable pThrowable)
    {

    }

    @Override
    public void onGetOperatorsSuccess(List<CountryOperator> pCountryOperators)
    {
        this.mView.renderOperators(pCountryOperators);
    }
}
