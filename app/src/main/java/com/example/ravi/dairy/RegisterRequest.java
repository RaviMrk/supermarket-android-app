package com.example.ravi.dairy;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RAVI on 01-09-2017.
 */

public class RegisterRequest extends StringRequest {

    private static final   String REGISTER_REQUEST_URL="https://mrk1231k.000webhostapp.com/Register.php";
    private Map<String,String> params;

    public RegisterRequest(String name, String username, int age, String password ,String address, Response.Listener<String>listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("password",password);
        params.put("age", age +"");
        params.put("address",address);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
