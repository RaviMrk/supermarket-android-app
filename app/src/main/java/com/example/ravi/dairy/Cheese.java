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

public class Cheese extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheese);

        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");

        final EditText cheeseqty=(EditText) findViewById(R.id.chqty);
        final Button chbtn=(Button) findViewById(R.id.chadd);


        chbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name1=name;
                final String prod="cheese";
                final int chqty = Integer.parseInt(cheeseqty.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponce = new JSONObject(response);
                            boolean success = jsonResponce.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(),"your order is placed successfully",Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Cheese.this);
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
                OrderRequest registerRequest=new OrderRequest(chqty,name1,prod,chqty*108, responseListener );
                RequestQueue queue= Volley.newRequestQueue(Cheese.this);
                queue.add(registerRequest);


            }
        });


    }
}
