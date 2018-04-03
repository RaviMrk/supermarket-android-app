package com.example.ravi.dairy;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        final TextView Milk=(TextView) findViewById(R.id.Milk);
        final TextView Butter=(TextView) findViewById(R.id.Butter);
        final TextView Curd=(TextView) findViewById(R.id.Curd);
        final TextView Cheese=(TextView) findViewById(R.id.Cheese);
        final TextView Pdetail=(TextView) findViewById(R.id.detail);
        final TextView tvmsg=(TextView) findViewById(R.id.tvmsg);
        final EditText milkqty=(EditText) findViewById(R.id.milkqty);
        final EditText butterqty=(EditText) findViewById(R.id.butterqty);
        final EditText curdqty=(EditText) findViewById(R.id.curdqty);
        final EditText cheeseqty=(EditText) findViewById(R.id.cheeseqty);
        final Button   btnplaceorder=(Button) findViewById(R.id.btnplace);


        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        final String name1=name;

        Milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent milkIntent =new Intent(Product.this ,Milk.class);
                        milkIntent.putExtra("name",name1);
                Product.this.startActivity(milkIntent);

            }
        });
        Butter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent butterIntent =new Intent(Product.this ,Butter.class);
                Product.this.startActivity(butterIntent);

            }
        });
        Cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cheeseIntent =new Intent(Product.this ,Cheese.class);
                Product.this.startActivity(cheeseIntent);

            }
        });
        Curd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent curdIntent =new Intent(Product.this ,Curd.class);
                Product.this.startActivity(curdIntent);

            }
        });
       Pdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name=name1;

                Response.Listener<String> responseListener=new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponce= new JSONObject(response);
                            boolean success=jsonResponce.getBoolean("success");
                            if (success){
                                int milk=jsonResponce.getInt("milk");
                                int butter=jsonResponce.getInt("butter");
                                int curd=jsonResponce.getInt("curd");
                                int cheese=jsonResponce.getInt("cheese");


                                Intent intent=new Intent(Product.this, OrderDetails.class);
                                    intent.putExtra("milk",milk);
                                    intent.putExtra("butter",butter);
                                    intent.putExtra("curd",curd);
                                    intent.putExtra("cheese",cheese);



                                Product.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(Product.this);
                                builder.setMessage(" Failed ")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                detailrequest detailRequest=new detailrequest(name, responseListener );
                RequestQueue queue= Volley.newRequestQueue(Product.this);
                queue.add(detailRequest);

            }
        });

        btnplaceorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int milk=Integer.parseInt(milkqty.getText().toString());
                final int butter=Integer.parseInt(butterqty.getText().toString());
                final int curd=Integer.parseInt(curdqty.getText().toString());
                final int cheese=Integer.parseInt(cheeseqty.getText().toString());
                final String name2=name1;

                Response.Listener<String> responseListener=new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponce= new JSONObject(response);
                            boolean success=jsonResponce.getBoolean("success");
                            if (success){
                                Toast.makeText(getApplicationContext(),"your order is placed successfully",Toast.LENGTH_LONG).show();


                            }else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(Product.this);
                                builder.setMessage(" Failed ")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //OrderRequest orderrequest=new OrderRequest(milk,butter,curd,cheese,name2, responseListener );
                //RequestQueue queue= Volley.newRequestQueue(Product.this);
                //queue.add(orderrequest);








            }
        });








        String msg=" Welcome " +name;
        tvmsg.setText(msg);


    }
}
