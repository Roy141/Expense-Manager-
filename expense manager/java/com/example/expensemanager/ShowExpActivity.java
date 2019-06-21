package com.example.expensemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ShowExpActivity extends AppCompatActivity {
    TableLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_exp);
        tl = findViewById(R.id.tl);
        SQLiteDatabase db = openOrCreateDatabase("EXPENSE", MODE_PRIVATE, null);
        String sq = "Select * from exp";
        Cursor c = db.rawQuery(sq, null);
        while (c.moveToNext()) {
            String id = c.getString(0);
            String cat = c.getString(1);
            String amt = c.getString(2);
            String date = c.getString(3);
            String tripid = c.getString(4);
            TableRow tr = new TableRow(this);
            TextView tv = new TextView(this);
            TextView tv1 = new TextView(this);
            TextView tv2 = new TextView(this);
            TextView tv3 = new TextView(this);
            TextView tv4 = new TextView(this);
            tv.setText("" + id);
            tv1.setText("" + cat);
            tv2.setText("" + amt);
            tv3.setText("" + date);
            tv4.setText("" + tripid);
            tr.addView(tv);
            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);
            tr.addView(tv4);
            tl.addView(tr);


        }
    }
}
