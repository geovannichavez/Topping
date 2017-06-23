package com.globalpaysolutions.topping.interactors;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.globalpaysolutions.topping.api.VolleySingleton;
import com.globalpaysolutions.topping.api.models.OperatorsResponse;
import com.globalpaysolutions.topping.interactors.interfaces.IMainInteractor;
import com.globalpaysolutions.topping.utils.Constants;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Josué Chávez on 22/06/2017.
 */

public class MainInteractor implements IMainInteractor
{
    private static String TAG = MainInteractor.class.getSimpleName();
    private Context mContext;

    public MainInteractor(Context pContext)
    {
        this.mContext = pContext;
    }

    @Override
    public void fetchOperators(final MainListener pListener)
    {
        VolleySingleton.getInstance(mContext).addToRequestQueue(
                new JsonObjectRequest(
                        Request.Method.GET,
                        Constants.OPERATORS,
                        null,
                        new Response.Listener<JSONObject>()
                        {
                            @Override
                            public void onResponse(JSONObject response)
                            {
                                Log.d(TAG, response.toString());
                                Gson gson = new Gson();
                                OperatorsResponse operatorsResponse = gson.fromJson(response.toString(), OperatorsResponse.class);
                                pListener.onGetOperatorsSuccess(operatorsResponse.getOperators().getCountryOperators());
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Log.e(TAG, "Something went wrong: " + error.getLocalizedMessage());
                            }
                        }
                )
                {

                    @Override
                    public Map<String, String> getHeaders()
                    {
                        Map<String, String> headers = new HashMap<String, String>();
                        headers.put("Country-Type", "69");
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        return headers;
                    }
                }
                , 1);
    }
}
