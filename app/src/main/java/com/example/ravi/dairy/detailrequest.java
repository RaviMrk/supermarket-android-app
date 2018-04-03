package com.example.ravi.dairy;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RAVI on 07-09-2017.
 */

public class detailrequest extends StringRequest {

    private static final   String DETAIL_REQUEST_URL="https://mrk1231k.000webhostapp.com/Detail.php";
    private Map<String,String> params;

    public detailrequest(String name2 , Response.Listener<String>listener){
        super(Request.Method.POST,DETAIL_REQUEST_URL,listener,null);
        params=new HashMap<>();

        params.put("name2",name2);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
