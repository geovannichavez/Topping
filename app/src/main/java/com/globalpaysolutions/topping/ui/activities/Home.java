package com.globalpaysolutions.topping.ui.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.globalpaysolutions.topping.R;
import com.globalpaysolutions.topping.presenters.HomePresenterImpl;
import com.globalpaysolutions.topping.ui.fragments.Main;
import com.globalpaysolutions.topping.ui.fragments.TabContainer;
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

    /*
    *
    *
    *
    *   ACTIVITY OVERRIDES
    *
    *
    * */

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean navigationItemSelected(int id)
    {
        if (id == R.id.nav_home)
        {
            mPresenter.setInitialFragment();
        }
        else if (id == R.id.nav_sales_history)
        {
            TabContainer fragmentInicio = new TabContainer();
            android.support.v4.app.FragmentTransaction fragmentTransactionInicio = getSupportFragmentManager()
                    .beginTransaction();
            fragmentTransactionInicio.replace(R.id.homeFragment, fragmentInicio);
            fragmentTransactionInicio.commit();
        }
        else if (id == R.id.nav_buy_airtime)
        {
            Toast.makeText(this, "Menu buy airtime", Toast.LENGTH_SHORT).show();
            /*Products fragmentProducts = new Products();
            android.support.v4.app.FragmentTransaction fragmentTransactionProducts = getSupportFragmentManager()
                    .beginTransaction();
            toolbar.setTitle("Productos");
            fragmentTransactionProducts.replace(R.id.mainFragment, fragmentProducts);
            fragmentTransactionProducts.commit();*/

        }
        else if (id == R.id.nav_notifications)
        {
            Toast.makeText(this, "Menu notifications", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_special_offers)
        {
            Toast.makeText(this, "Menu offers", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_chat)
        {
            Toast.makeText(this, "Menu chat", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_settings)
        {
            Toast.makeText(this, "Menu settings", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        int menuId = item.getItemId();
        return mPresenter.handleMenuItemSelected(menuId);
    }

    /*
    *
    *
    *
    *   VIEW IMPLEMENTATION
    *
    *
    * */

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
    public void setInitialFragment()
    {
        try
        {
            //Sets the main fragment
            navigationView.setCheckedItem(R.id.nav_home);
            Main mainFragment = new Main();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.homeFragment, mainFragment);
            fragmentTransaction.commit();
        }
        catch (Exception ex) {  ex.printStackTrace();   }
    }
}
