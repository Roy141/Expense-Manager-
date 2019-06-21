package com.example.expensemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DayWiseExpActivity extends AppCompatActivity {
    TableLayout tl;
    SQLiteDatabase db;String sq;
    Cursor c;int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_wise_exp);
        db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);

        sq = "Select * from trip";
        c = db.rawQuery(sq, null);
        while (c.moveToNext()) {
            //   int sum=0;int l=0;
            ++i;
            String id = c.getString(0);
            ArrayList a1=new ArrayList();
            String d = c.getString(1);
            String q = "Select Date from exp where id='" + id + "' ";
            Cursor a = db.rawQuery(q, null);
            while (a.moveToNext()) {
                String y = a.getString(0);
                if (!(a1.contains(y))) {
                    a1.add(y);

                    int sum = 0;
                    // db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);
                    String b = "Select Amount from exp where Date='" + y + "' and id='" + id + "' ";
                    Cursor f = db.rawQuery(b, null);
                    while (f.moveToNext()) {
                        int e = Integer.parseInt(f.getString(0));
                        sum = sum + e;
                    }
                    int g = 122 + i;
                    String t = Integer.toString(g);
                    String id1 = "E" + t;
                    String q1 = "insert into dayexpense values('" + id1 + "','" + d + "','" + y + "','" + sum + "','Expense','Expense','Expense')";
                    db = openOrCreateDatabase("EXPENSE", MODE_PRIVATE, null);
                    try {
                        db.execSQL(q1);
                        //Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(this, "Error" + e, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        tl = findViewById(R.id.tl);
        db = openOrCreateDatabase("EXPENSE", MODE_PRIVATE, null);
        String sq = "Select * from dayexpense";
        c = db.rawQuery(sq, null);
        while (c.moveToNext()) {
            String id=c.getString(0);
            String to = c.getString(1);
            String date = c.getString(2);
            String sp = c.getString(3);
            TableRow tr = new TableRow(this);
            TextView tv1 = new TextView(this);
            TextView tv2 = new TextView(this);
            TextView tv3 = new TextView(this);
            TextView tv4 = new TextView(this);

            tv1.setText(""+id);
            tv2.setText("" + to);
            tv3.setText("" +date );
            tv4.setText("" + sp);
            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);
            tr.addView(tv4);

            tl.addView(tr);


        }
    }
    }

