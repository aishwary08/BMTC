package com.example.user;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Print_Query4 extends Activity {

	TableLayout tl;
	TableRow tr,tr1;
	TextView label,col1,col0;

	String[] s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_print_query_4);

		tl = (TableLayout) findViewById(R.id.tableLayout1);

		Intent in = getIntent();
		s = (String[]) in.getExtras().get("Data");
		addHeader();
		for (int i = 0 ; i<s.length ; i++ ) {
			String[] content = s[i].split("#");
			tr = new TableRow(this);
			label = new TextView(this);
			label.setText(content[0]);
			label.setId(65);
			label.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
			label.setPadding(5, 5, 5, 5);
			label.setBackgroundColor(Color.GRAY);
			label.setGravity(Gravity.CENTER);
			LinearLayout Ll = new LinearLayout(this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(5, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(label,params);
			tr.addView((View)Ll); // Adding textView to tablerow.

			/** Creating Qty Button **/
			TextView place = new TextView(this);
			place.setText(content[1]);
			place.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));
			place.setPadding(5, 5, 5, 5);
			place.setBackgroundColor(Color.GRAY);
			place.setGravity(Gravity.CENTER);
			Ll = new LinearLayout(this);
			params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(place,params);
			tr.addView((View)Ll); // Adding textview to tablerow.

			//* Creating Qty Button *
			TextView col3 = new TextView(this);
			col3.setText(content[2]);
			col3.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));
			col3.setPadding(5, 5, 5, 5);
			col3.setBackgroundColor(Color.GRAY);
			col3.setGravity(Gravity.CENTER);
			Ll = new LinearLayout(this);
			params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(col3,params);
			tr.addView((View)Ll); // Adding textview to tablerow.



			TextView col4 = new TextView(this);
			col4.setText(content[3]);
			col4.setId(55);
			col4.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
			col4.setPadding(5, 5, 5, 5);
			col4.setBackgroundColor(Color.GRAY);
			col4.setGravity(Gravity.CENTER);
			Ll = new LinearLayout(this);
			params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(5, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(col4,params);
			tr.addView((View)Ll); // Adding textView to tablerow.

			/** Creating Qty Button **/
			TextView col5 = new TextView(this);
			col5.setText(content[4]);
			col5.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));
			col5.setPadding(5, 5, 5, 5);
			col5.setBackgroundColor(Color.GRAY);
			col5.setGravity(Gravity.CENTER);
			Ll = new LinearLayout(this);
			params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(col5,params);
			tr.addView((View)Ll); // Adding textview to tablerow.

			/** Creating Qty Button **/
			TextView col6 = new TextView(this);
			col6.setText(content[5]);
			col6.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));
			col6.setPadding(5, 5, 5, 5);
			col6.setBackgroundColor(Color.GRAY);
			col6.setGravity(Gravity.CENTER);
			Ll = new LinearLayout(this);
			params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(col6,params);
			tr.addView((View)Ll); // Adding textview to tablerow.

			/** Creating Qty Button **/
			TextView col7 = new TextView(this);
			col7.setText(content[6]);
			col7.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));
			col7.setPadding(5, 5, 5, 5);
			col7.setBackgroundColor(Color.GRAY);
			col7.setGravity(Gravity.CENTER);
			Ll = new LinearLayout(this);
			params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(col7,params);
			tr.addView((View)Ll); // Adding textview to tablerow.




			// Add the TableRow to the TableLayout
			tl.addView(tr, new TableLayout.LayoutParams(
					TableLayout.LayoutParams.MATCH_PARENT,
					TableLayout.LayoutParams.WRAP_CONTENT));
		}

	}

	void addHeader()
	{
		tl = (TableLayout) findViewById(R.id.tableLayout1);


		tr = new TableRow(this);
		// Creating a TextView to add to the row
		col1 = new TextView(this);
		col1.setText("DEPARTURE TIME");
		col1.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
		col1.setPadding(5, 5, 5, 5);
		col1.setBackgroundColor(Color.parseColor("#1abc9c"));
		col1.setGravity(Gravity.CENTER);
		col1.setTypeface(Typeface.create("serif", Typeface.NORMAL));
		LinearLayout Ll = new LinearLayout(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT);
		params.setMargins(5, 5, 5, 5);
		Ll.addView(col1,params);
		tr.addView((View)Ll); // Adding textView to tablerow.

		// Creating Qty Button
		TextView col2 = new TextView(this);
		col2.setText("DRIVER ID");
		col2.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
		col2.setPadding(5, 5, 5, 5);
		col2.setBackgroundColor(Color.parseColor("#1abc9c"));
		col2.setGravity(Gravity.CENTER);
		col2.setTypeface(Typeface.create("serif", Typeface.NORMAL));
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 5, 5, 5);
		Ll.addView(col2,params);
		tr.addView((View)Ll); // Adding textview to tablerow.

		// Creating Qty Button
		TextView col3 = new TextView(this);
		col3.setText("DRIVER NAME");
		col3.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
		col3.setPadding(5, 5, 5, 5);
		col3.setBackgroundColor(Color.parseColor("#1abc9c"));
		col3.setGravity(Gravity.CENTER);
		col3.setTypeface(Typeface.create("serif", Typeface.NORMAL));
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 5, 5, 5);
		Ll.addView(col3,params);
		tr.addView((View)Ll); // Adding textview to tablerow.

		// Creating a TextView to add to the row
		TextView col4 = new TextView(this);
		col4 = new TextView(this);
		col4.setText("CONTACT NUMBER");
		col4.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
		col4.setPadding(5, 5, 5, 5);
		col4.setBackgroundColor(Color.parseColor("#1abc9c"));
		col4.setGravity(Gravity.CENTER);
		col4.setTypeface(Typeface.create("serif", Typeface.NORMAL));
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT);
		params.setMargins(5, 5, 5, 5);
		Ll.addView(col4,params);
		tr.addView((View)Ll); // Adding textView to tablerow.

		// Creating Qty Button
		TextView col5 = new TextView(this);
		col5.setText("ROUTE NUMBER");
		col5.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
		col5.setPadding(5, 5, 5, 5);
		col5.setBackgroundColor(Color.parseColor("#1abc9c"));
		col5.setGravity(Gravity.CENTER);
		col5.setTypeface(Typeface.create("serif", Typeface.NORMAL));
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 5, 5, 5);
		Ll.addView(col5,params);
		tr.addView((View)Ll); // Adding textview to tablerow.

		// Creating Qty Button
		TextView col6 = new TextView(this);
		col6.setText("SOURCE STATION");
		col6.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
		col6.setPadding(5, 5, 5, 5);
		col6.setBackgroundColor(Color.parseColor("#1abc9c"));
		col6.setGravity(Gravity.CENTER);
		col6.setTypeface(Typeface.create("serif", Typeface.NORMAL));
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 5, 5, 5);
		Ll.addView(col6,params);
		tr.addView((View)Ll); // Adding textview to tablerow.


		// Creating Qty Button
		TextView col7 = new TextView(this);
		col7.setText("DESTINATION");
		col7.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
		col7.setPadding(5, 5, 5, 5);
		col7.setBackgroundColor(Color.parseColor("#1abc9c"));
		col7.setGravity(Gravity.CENTER);
		col7.setTypeface(Typeface.create("serif", Typeface.NORMAL));
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 5, 5, 5);
		Ll.addView(col7,params);
		tr.addView((View)Ll); // Adding textview to tablerow


		tl.addView(tr, new TableLayout.LayoutParams(
				TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
	}
}
