package com.example.user;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
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
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by LENOVO on 07-10-2016.
 */

public class Get_Query extends AsyncTask<String,Void,String> {
    public ValidationResponse delegate;
    Context ctx;
    Get_Query(Context ctx)
    {
        this.ctx = ctx;
    }
    int rf;

    @Override
    protected String doInBackground(String... params) {
        String resp="";
        rf=Integer.parseInt(params[1].substring(1,2));
        try {
            URL dburl = new URL("http://192.168.1.10/"+params[1]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) dburl.openConnection();
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            if(rf==1 || rf==4) {
                String data=URLEncoder.encode("ID", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8");;
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
            }
            InputStream IS = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
            String line="";
            while((line = bufferedReader.readLine())!=null)
                resp = resp+line;
            bufferedReader.close();
            IS.close();
            httpURLConnection.disconnect();
        }
         catch (SocketTimeoutException e){
            Log.d("SocketTimeoutException","here");
            resp="Connection Error. Please Try Again! ";
        } catch (MalformedURLException e) {
            resp="Connection Error. Please Try Again! ";
        } catch (IOException e) {
            resp="Connection Error. Please Try Again! ";
        }

        return resp;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("dopost", "here" + s);
        if (s.equals("Connection Error. Please Try Again! "))
            Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
        else {
            String[] response = s.split("@");
            boolean result = false;
            if (!response[0].equals("None")) {
                delegate.response(true, response,rf);
            } else
                Toast.makeText(ctx, response[0], Toast.LENGTH_LONG).show();
        }
    }
}
