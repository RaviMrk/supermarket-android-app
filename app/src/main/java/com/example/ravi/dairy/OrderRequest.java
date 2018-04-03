package com.example.ravi.dairy;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RAVI on 05-09-2017.
 */

public class OrderRequest extends StringRequest {


    private static final   String ORDER_REQUEST_URL="https://mrk1231k.000webhostapp.com/Order.php";
    private Map<String,String> params;

    public OrderRequest(int qty ,String name,String prod,int price, Response.Listener<String>listener){
        super(Method.POST,ORDER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("name",name);
        params.put("prod",prod);


        params.put("qty", qty +"");
        params.put("price", price +"");

    }



    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
