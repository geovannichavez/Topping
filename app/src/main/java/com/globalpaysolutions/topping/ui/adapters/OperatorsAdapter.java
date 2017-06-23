package com.globalpaysolutions.topping.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.globalpaysolutions.topping.R;
import com.globalpaysolutions.topping.api.VolleySingleton;
import com.globalpaysolutions.topping.models.CountryOperator;

/**
 * Created by Josué Chávez on 22/06/2017.
 */

public class OperatorsAdapter extends ArrayAdapter<CountryOperator>
{
    private Context AdapterContext;
    private int AdapResource;
    int SelectedItem;

    public OperatorsAdapter(Context pContext, int pResource)
    {
        super(pContext, pResource);

        AdapterContext = pContext;
        AdapResource = pResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;

        final CountryOperator currentItem = getItem(position);

        if (view == null)
        {
            LayoutInflater inflater = ((Activity) AdapterContext).getLayoutInflater();
            view = inflater.inflate(AdapResource, parent, false);
        }

        view.setTag(currentItem);

        NetworkImageView imageView = (NetworkImageView) view.findViewById(R.id.networkViewOperador);

        ImageLoader imageLoader = VolleySingleton.getInstance(AdapterContext).getImageLoader();
        imageView.setImageUrl(currentItem.getLogoUrl(), imageLoader);

        return view;
    }

}
