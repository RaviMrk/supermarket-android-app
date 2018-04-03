package com.example.ravi.dairy;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etName=(EditText) findViewById(R.id.etNname);
        final EditText etPassword=(EditText) findViewById(R.id.etPassword);
        final Button bLogin=(Button) findViewById(R.id.bLogin);
        final TextView registerLink=(TextView) findViewById(R.id.tvRegisterhere);


        registerLink.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, Registeractivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name=etName.getText().toString();
                final String password=etPassword.getText().toString();

                Response.Listener<String> responceListner= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jesonResponse=new JSONObject(response);
                            boolean success=jesonResponse.getBoolean("success");
                            if(success){
                               String name=jesonResponse.getString("name");
                                //int age=jesonResponse.getInt("age");

                                Intent intent=new Intent(MainActivity.this,Nevigate.class);
                                intent.putExtra("name",name);
                                //intent.putExtra("username",name);
                                //intent.putExtra("age",age);

                                MainActivity.this.startActivity(intent);


                            }else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                LoginRequest loginRequest=new LoginRequest(name,password,responceListner);
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);


            }
        });
    }
}
