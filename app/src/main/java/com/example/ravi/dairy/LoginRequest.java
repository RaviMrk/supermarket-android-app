package com.example.ravi.dairy;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RAVI on 01-09-2017.
 */

public class LoginRequest extends StringRequest {

    private static final   String LOGIN_REQUEST_URL="https://mrk1231k.000webhostapp.com/Login.php";
    private Map<String,String> params;

    public LoginRequest(String name, String password , Response.Listener<String>listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params=new HashMap<>();

        params.put("name",name);
        params.put("password",password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
