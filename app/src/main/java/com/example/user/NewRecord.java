package com.example.user;

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
 * Created by LENOVO on 08-10-2016.
 */

public class NewRecord extends AsyncTask<String,Void,String> {

    Context ctx;
    NewRecord(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String resp="";
        try {
            URL dburl = new URL("http://192.168.1.10/user_ins.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) dburl.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
            String data = URLEncoder.encode("us","UTF-8")+"="+URLEncoder.encode(params[0],"UTF-8")+"&"+
                    URLEncoder.encode("pa","UTF-8")+"="+URLEncoder.encode(params[1],"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            InputStream IS = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
            resp = bufferedReader.readLine();
            bufferedReader.close();
            IS.close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(ctx,s,Toast.LENGTH_SHORT).show();
    }
}
