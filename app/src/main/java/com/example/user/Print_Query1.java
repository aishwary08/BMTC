package com.example.user;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Print_Query1 extends Activity {

	TableLayout tl;
	TableRow tr;
	TextView label,col1;

	String[] s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_print_query);

		tl = (TableLayout) findViewById(R.id.tableLayout1);

		Intent in = getIntent();
		s = (String[]) in.getExtras().get("Data");
		addHeader();
		for (int i = 0 ; i<s.length ; i++ ) {
			String[] content = s[i].split("#");
			tr = new TableRow(this);
			label = new TextView(this);
			label.setText(content[0]);
			label.setId(50);
			label.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
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
			place.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
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
		col1.setText("LICENSE NUMBER");
		col1.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
		col1.setPadding(5, 5, 5, 5);
		col1.setBackgroundColor(Color.parseColor("#1abc9c"));
		col1.setGravity(Gravity.CENTER);
		col1.setTypeface(Typeface.create("serif",Typeface.NORMAL));
		LinearLayout Ll = new LinearLayout(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT);
		params.setMargins(5, 5, 5, 5);
		Ll.addView(col1,params);
		tr.addView((View)Ll); // Adding textView to tablerow.

		// Creating Qty Button
		TextView col2 = new TextView(this);
		col2.setText("DEPARTURE TIME");
		col2.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
		col2.setPadding(5, 5, 5, 5);
		col2.setBackgroundColor(Color.parseColor("#1abc9c"));
		col2.setGravity(Gravity.CENTER);
		col2.setTypeface(Typeface.create("serif",Typeface.NORMAL));
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 5, 5, 5);
		Ll.addView(col2,params);
		tr.addView((View)Ll); // Adding textview to tablerow.

		tl.addView(tr, new TableLayout.LayoutParams(
				TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.WRAP_CONTENT));
	}
}
