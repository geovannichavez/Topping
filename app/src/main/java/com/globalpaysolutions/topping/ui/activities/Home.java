package com.globalpaysolutions.topping.ui.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.globalpaysolutions.topping.R;
import com.globalpaysolutions.topping.presenters.HomePresenterImpl;
import com.globalpaysolutions.topping.ui.fragments.Main;
import com.globalpaysolutions.topping.views.HomeView;

public class Home extends AppCompatActivity implements HomeView, NavigationView.OnNavigationItemSelectedListener
{
    public static final String TAG = Home.class.getSimpleName();

    //Views and Layouts
    Toolbar toolbar;
    NavigationView navigationView;

    //MVP
    HomePresenterImpl mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPresenter = new HomePresenterImpl(this, this, this);
        mPresenter.initializeViews();
    }

    @Override
    public void initializeView()
    {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Sets the main fragment
        navigationView.setCheckedItem(R.id.nav_home);
        Main mainFragment = new Main();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        toolbar.setTitle("Topping");
        fragmentTransaction.replace(R.id.homeFragment, mainFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void initializeDrawer()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        return false;
    }
}
