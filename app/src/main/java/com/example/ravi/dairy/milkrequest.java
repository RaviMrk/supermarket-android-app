package com.example.ravi.dairy;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RAVI on 04-09-2017.
 */

public class milkrequest extends StringRequest{

    private static final   String MILK_REQUEST_URL="https://mrk1231k.000webhostapp.com/milk.php";
    private Map<String,String> params;
    public milkrequest(int qty ,String name,String prod, Response.Listener<String>listener){
        super(Method.POST,MILK_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("name",name);
        params.put("prod",prod);


        params.put("qty", qty +"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
