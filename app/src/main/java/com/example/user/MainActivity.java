package com.example.user;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements ValidationResponse{

    LinearLayout linearLayoutPopup;
    RelativeLayout relativeLayout;
    NoInternetPopUp pop;
    GridView gridView;
    String m_Text="Hello";

    static final String[] TITLE = new String[] {"SCHEDULE", "BUSES/DAY","BUSES", "DRIVER DETAILS" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        linearLayoutPopup = (LinearLayout) findViewById(R.id.linearLayoutPopUp);
        relativeLayout = (RelativeLayout)findViewById(R.id.activity_main);
        linearLayoutPopup.setVisibility(View.GONE);

        pop = new NoInternetPopUp(MainActivity.this,linearLayoutPopup,relativeLayout);
        if(!isNetworkConnected()) pop.noInternet();

        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new ImageAdapter(MainActivity.this, TITLE));
        gridView.setOnItemClickListener(new  AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                /*Toast.makeText(
                        getApplicationContext(),
                        ((TextView) v.findViewById(R.id.grid_item_label)).getText()+ Integer.toString(position), Toast.LENGTH_SHORT).show();*/

                switch (position)
                {
                    case 0: {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Departure Time?");
                        final EditText input = new EditText(MainActivity.this);
                        input.setInputType(InputType.TYPE_CLASS_DATETIME );
                        builder.setView(input);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                m_Text=input.getText().toString();
                                Get_Query conn1 = new Get_Query(MainActivity.this);
                                if(isNetworkConnected()) {
                                    conn1.delegate = MainActivity.this;
                                    Log.d("here","value "+conn1.delegate);
                                    conn1.execute(m_Text,"q1.php");
                                }
                                else
                                    pop.noInternet();
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.show();
                    }
                    break;
                    case 1: {
                           Get_Query conn2 = new Get_Query(MainActivity.this);
                                if(isNetworkConnected()) {
                                conn2.delegate = MainActivity.this;
                                    Log.d("here","value "+conn2.delegate);
                                    conn2.execute(m_Text,"q2.php");
                                }
                                else
                                    pop.noInternet();

                    }
                    break;
                    case 2: {
                        Get_Query conn3 = new Get_Query(MainActivity.this);
                        if(isNetworkConnected()) {
                            conn3.delegate = MainActivity.this;
                            Log.d("here","value "+conn3.delegate);
                            conn3.execute(m_Text,"q3.php");
                        }
                        else
                            pop.noInternet();

                    }
                    break;

                    case 3: {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Driver ID?");
                        final EditText input = new EditText(MainActivity.this);
                        input.setInputType(InputType.TYPE_CLASS_NUMBER );
                        builder.setView(input);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                m_Text=input.getText().toString();
                                Get_Query conn4 = new Get_Query(MainActivity.this);
                                if(isNetworkConnected()) {
                                    conn4.delegate = MainActivity.this;
                                    Log.d("here","value "+conn4.delegate);
                                    conn4.execute(m_Text,"q4.php");
                                }
                                else
                                    pop.noInternet();
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        builder.show();
                    }
                    break;
                }
            }
        });

        /*Get_Query conn = new Get_Query(MainActivity.this);
		if(isNetworkConnected()) {
           conn.delegate = MainActivity.this;
           Log.d("here","value "+conn.delegate);
           conn.execute("2810", "123");
           }
        else
         pop.noInternet();*/
    }

	boolean isNetworkConnected()
	{
		Context context = MainActivity.this;
		boolean result = false;
		ConnectivityManager check = (ConnectivityManager)
		this.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] info = check.getAllNetworkInfo();
		for (int i = 0; i<info.length; i++){
			if (info[i].getState() == NetworkInfo.State.CONNECTED){
				result = true;
				break;
			}
		}
		return result;
	}

    @Override
    public void response(boolean result, String[] s, int rf) {
        if(result)
        {
            if(rf==1) {
                Intent i = new Intent(MainActivity.this, Print_Query1.class);
                i.putExtra("Data", s);
                startActivity(i);
            }
            if(rf==2) {
                Intent i = new Intent(MainActivity.this, Print_Query2.class);
                i.putExtra("Data", s);
                startActivity(i);
            }

            if(rf==3) {
                Intent i = new Intent(MainActivity.this, Print_Query3.class);
                i.putExtra("Data", s);
                startActivity(i);
            }

            if(rf==4) {
                Intent i = new Intent(MainActivity.this, Print_Query4.class);
                i.putExtra("Data", s);
                startActivity(i);
            }
        }
    }

   /* @Override
    public void response(boolean result,String[] s) {
        if(result) {
            Intent i = new Intent(MainActivity.this, Home.class);
            i.putExtra("name", "aishwary");
            i.putExtra("pass", Username);
            i.putExtra("intc", Password);
            startActivity(i);
        }
    }*/
}
