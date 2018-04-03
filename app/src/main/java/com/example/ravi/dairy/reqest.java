package com.example.ravi.dairy;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RAVI on 12-10-2017.
 */

public class reqest extends StringRequest {

    private static final   String LOGIN_REQUEST_URL="https://mrk1231k.000webhostapp.com/display.php";
    private Map<String,String> params;

    public reqest(Response.Listener<String>listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params=new HashMap<>();



    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
