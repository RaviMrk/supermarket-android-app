package com.example.ravi.dairy;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import static android.R.attr.name;

public class OrderDetails extends AppCompatActivity {
    public String name4;
    protected  String product;



   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        final TextView text = (TextView) findViewById(R.id.data);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Response.Listener<String> responceListner= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jesonResponse=new JSONObject(response);
                            boolean success=jesonResponse.getBoolean("success");
                            if(success){
                                String query=jesonResponse.getString("query");
                                //int age=jesonResponse.getInt("age");
                                String msg=" Welcome " +query;
                                text.setText(msg);




                            }else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(OrderDetails.this);
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
                reqest loginRequest=new reqest(responceListner);
                RequestQueue queue= Volley.newRequestQueue(OrderDetails.this);
                queue.add(loginRequest);
            }
        });*/


     //  Intent intent=getIntent();
      //  String name=intent.getStringExtra("name");
        //String msg=" Welcome " +name;
        //text.setText(msg);

            ListView lv;
    ArrayAdapter<String> adapter;
    String address="http://mrk1231k.000webhostapp.com/list.php";
    InputStream is=null;
    String line=null;
    String result=null;
    String[] data;
    String[] data1;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);



        final EditText canceltext=(EditText)findViewById(R.id.canceltext);
        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");
        String msg=" Welcome " +name;
        name4=name;



        final TextView text=(TextView)findViewById(R.id.data);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final String name4=name;
                Intent intent=new Intent(OrderDetails.this,total.class);
                intent.putExtra("name", name);
                OrderDetails.this.startActivity(intent);
            }
        });


       // text.setText(msg);


        lv= (ListView) findViewById(R.id.list6);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        getdata();

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        lv.setAdapter(adapter);

       // text.setText("count");

    }
    public void OnLogin(View view) {
        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        bagound bagound = new bagound(this);
        bagound.execute(name);
    }

    public void OnCancel(View view) {
        Intent intent = getIntent();

        final String name = intent.getStringExtra("name");

        final EditText canceltext=(EditText)findViewById(R.id.canceltext);
        product=canceltext.getText().toString();
        cancel cancel = new cancel(this);
        cancel.execute(name,product);
    }


    private void getdata()  {
        try {
            String name=name4;
            URL url = new URL(address);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            OutputStream outputStream = con.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("name","UTF-8")+"="+ URLEncoder.encode(name,"UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();


            con.setRequestMethod("GET");
            is = new BufferedInputStream(con.getInputStream());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        try {
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while ((line=br.readLine())!=null)
            {
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;
            data=new String[ja.length()];
           // data1=new String[ja.length()];


            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data[i]=jo.getString("prod");
                 //data1[i]=data[i];


               //count= Integer.parseInt(data[i]+count);

            }



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }


    }

