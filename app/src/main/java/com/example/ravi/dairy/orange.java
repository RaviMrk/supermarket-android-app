package com.example.ravi.dairy;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class orange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange);

        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");
        final Button orangeadd=(Button)findViewById(R.id.orangeadd);
        final EditText orangeqty=(EditText)findViewById(R.id.orangeqty);


        orangeadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name1=name;
                final String prod="orange";
                final int oqty = Integer.parseInt(orangeqty.getText().toString());
                final int price=oqty*62;

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponce = new JSONObject(response);
                            boolean success = jsonResponce.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(),"your order is placed successfully",Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(orange.this);
                                builder.setMessage(" Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }


                };
                OrderRequest registerRequest=new OrderRequest(oqty,name1,prod,price,responseListener );
                RequestQueue queue= Volley.newRequestQueue(orange.this);
                queue.add(registerRequest);




            }
        });


    }
}
