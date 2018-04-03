package com.example.ravi.dairy;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registeractivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);
        final EditText etAge=(EditText) findViewById(R.id.etAge);
        final EditText etName=(EditText) findViewById(R.id.etName);
        final EditText etUsername=(EditText) findViewById(R.id.etNname);
        final EditText etPassword=(EditText) findViewById(R.id.etPassword);
        final Button bRegister=(Button) findViewById(R.id.bRegister);
        final EditText etaddress=(EditText) findViewById(R.id.etaddress);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name=etName.getText().toString();
                final String username=etUsername.getText().toString();
                final String password=etPassword.getText().toString();
                final int age=Integer.parseInt(etAge.getText().toString());
                final String address=etaddress.getText().toString();

                Response.Listener<String> responseListener=new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponce= new JSONObject(response);
                            boolean success=jsonResponce.getBoolean("success");
                            if (success){
                                Intent intent=new Intent(Registeractivity.this, MainActivity.class);
                                Registeractivity.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(Registeractivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                RegisterRequest registerRequest=new RegisterRequest(name,username,age,password,address, responseListener );
                RequestQueue queue= Volley.newRequestQueue(Registeractivity.this);
                queue.add(registerRequest);


            }
        });
    }
}
