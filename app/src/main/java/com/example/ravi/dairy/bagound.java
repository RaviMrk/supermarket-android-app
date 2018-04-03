package com.example.ravi.dairy;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by RAVI on 21-10-2017.
 */

public class bagound extends AsyncTask<String, Object, String> {
    Context context;
    AlertDialog alertDialog;
    bagound(Context ctx){
        context=ctx;
    }




    @Override
    protected String doInBackground(String... params) {

        String login_url = "https://mrk1231k.000webhostapp.com/display.php";
        try {
            String name=params[0];
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("name","UTF-8")+"="+ URLEncoder.encode(name,"UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line;
            while((line = bufferedReader.readLine())!= null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("your total bill is");
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
       // String x = result.substring(result.indexOf("sum(price)"),result.indexOf("'}]")+3);
       // String x = result.substring(result.indexOf("sum(price)")+13,result.indexOf("'}]"));
        alertDialog.setMessage(result);
        alertDialog.show();


    }

    @Override
    protected void onProgressUpdate(Object... values) {
        super.onProgressUpdate(values);
    }



}
