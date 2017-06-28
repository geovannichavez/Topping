package com.globalpaysolutions.topping.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.globalpaysolutions.topping.R;
import com.globalpaysolutions.topping.presenters.SigninPresenterImpl;
import com.globalpaysolutions.topping.views.SigninView;

public class Signin extends AppCompatActivity implements SigninView
{
    //MVP
    private SigninPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mPresenter = new SigninPresenterImpl(this, this, this);
    }

    @Override
    public void navigateNext()
    {
        Intent home = new Intent(this, Home.class);
        startActivity(home);
    }

    public void navigateNext(View view)
    {
        mPresenter._navigateNext();
    }
}
