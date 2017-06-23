package com.globalpaysolutions.topping.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.globalpaysolutions.topping.R;
import com.globalpaysolutions.topping.models.CountryOperator;
import com.globalpaysolutions.topping.presenters.MainPresenterImpl;
import com.globalpaysolutions.topping.ui.adapters.OperatorsAdapter;
import com.globalpaysolutions.topping.views.MainView;

import java.util.List;

public class Main extends Fragment implements MainView
{
    private static final String TAG = Main.class.getSimpleName();

    //Layouts y Adapters
    GridView mOperatorsGridView;
    OperatorsAdapter mOperatorsAdapter;

    //MVP
    MainPresenterImpl mPresenter;

    public Main()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mPresenter = new MainPresenterImpl(getActivity(), this, this);

        //Adapters
        mOperatorsAdapter = new OperatorsAdapter(getActivity(), R.layout.custom_operator_gridview_item);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View mainView = inflater.inflate(R.layout.fragment_main, container, false);

        //Views
        mOperatorsGridView = (GridView) mainView.findViewById(R.id.gvOperadores);
        mOperatorsGridView.setAdapter(mOperatorsAdapter);

        mPresenter.initializeViews();
        mPresenter.fetchOperators();

        return mainView;
    }

    @Override
    public void initializeViews()
    {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Override
    public void renderOperators(List<CountryOperator> countryOperators)
    {
        mOperatorsAdapter.notifyDataSetChanged();
        mOperatorsGridView.setNumColumns(countryOperators.size());
        mOperatorsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                CountryOperator operator = ((CountryOperator) parent.getItemAtPosition(position));
                Toast.makeText(getContext(), "Clicked a carrier: " + operator.getName(), Toast.LENGTH_LONG).show();
            }
        });

        //Llenado de items en el GridView
        try
        {
            mOperatorsAdapter.clear();
            for (CountryOperator item : countryOperators)
            {
                mOperatorsAdapter.add(item);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
