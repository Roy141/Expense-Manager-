package com.example.expensemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ShowTripActivity extends AppCompatActivity {
    TableLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_trip);
        tl = findViewById(R.id.tl);
        SQLiteDatabase db = openOrCreateDatabase("EXPENSE", MODE_PRIVATE, null);
        String sq = "Select * from trip";
        Cursor c = db.rawQuery(sq, null);
        while (c.moveToNext()) {
            String id = c.getString(0);
            String des = c.getString(1);
            String from = c.getString(2);
            String dos = c.getString(3);
            String doe = c.getString(4);
            String apb = c.getString(5);
            TableRow tr = new TableRow(this);
            TextView tv = new TextView(this);
            TextView tv1 = new TextView(this);
            TextView tv2 = new TextView(this);
            TextView tv3 = new TextView(this);
            TextView tv4 = new TextView(this);
            TextView tv5 = new TextView(this);
            tv.setText("" + id);
            tv1.setText("" + des);
            tv2.setText("" + from);
            tv3.setText("" + dos);
            tv4.setText("" + doe);
            tv5.setText("" + apb);
            tr.addView(tv);
            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);
            tr.addView(tv4);
            tr.addView(tv5);
            tl.addView(tr);
        }

    }
}
