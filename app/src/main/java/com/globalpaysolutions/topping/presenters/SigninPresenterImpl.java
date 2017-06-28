package com.globalpaysolutions.topping.presenters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.globalpaysolutions.topping.presenters.interfaces.ISigninPresenter;
import com.globalpaysolutions.topping.views.SigninView;

/**
 * Created by Josué Chávez on 23/06/2017.
 */

public class SigninPresenterImpl implements ISigninPresenter
{
    private static final String TAG = SigninPresenterImpl.class.getSimpleName();

    private Context mContext;
    private SigninView mView;

    public SigninPresenterImpl(Context pContext, AppCompatActivity pActivity, SigninView pView)
    {
        this.mContext = pContext;
        this.mView = pView;
    }

    @Override
    public void authenticateUser()
    {

    }

    @Override
    public void _navigateNext()
    {
        mView.navigateNext();
    }
}
