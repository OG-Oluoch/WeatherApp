package com.example.weatherapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class CityDataService {

    public static final String QUERY_FOR_COUNTRY_NAME = "https://api.weatherapi.com/v1/current.json?key=fe745592cea241d9904124007252706&q=";
    static Context context;
    static String country;

    public CityDataService(Context context) {
        this.context = context;
    }


    public static String getCountryName(String cityName) {

        String url = QUERY_FOR_COUNTRY_NAME + cityName;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {



                try {
                    JSONObject cityInfo = response.getJSONObject("location");
                    country = cityInfo.getString("country");

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                Toast.makeText(context, "The country is " + country, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();

            }
        });

        TheSingleton.getInstance(context).addToRequestQueue(request);

        return country;
    }
}
   /* public List<CityReportModel> getCityInfo(String cityInfo){


    }

    public List<CityReportModel> getCityName(String cityName){


    }
}*/
