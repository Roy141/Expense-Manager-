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

public class TripWiseexpenseActivity extends AppCompatActivity {
    TextView tv; SQLiteDatabase db;
    TableLayout tl;Cursor c;int f=0;
String sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_wiseexpense);
        /*tv = findViewById(R.id.tv);
        ArrayList a = new ArrayList();

        SQLiteDatabase db = openOrCreateDatabase("EXPENSE", MODE_PRIVATE, null);
        String sq = "Select * from trip";
        Cursor c = db.rawQuery(sq, null);
        while (c.moveToNext()) {
            String id = c.getString(0);
            a.add("" + id);

        }
        //tv.setText("" + a);*/
        db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);
         sq="create table  if not exists tripexpense(id varchar,dest varchar,std varchar,endd varchar,approved varchar,spend varchar,leftamt varchar)";
        try {
            db.execSQL(sq);
            //Toast.makeText(this, "Table Created", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Error"+e, Toast.LENGTH_SHORT).show();
        }
        sq = "Select * from trip";
         c = db.rawQuery(sq, null);
        while (c.moveToNext()) {
            int sum=0;int l=0;
            ++f;
            String id = c.getString(0);
            String d = c.getString(1);
            String dos = c.getString(3);
            String doe = c.getString(4);
            String ap = c.getString(5);
            String s="Select Amount from exp where id='"+id+"'";
            Cursor a = db.rawQuery(s, null);
            while (a.moveToNext()) {
                int res=Integer.parseInt(a.getString(0));

                sum=sum+res;

            }
            int le=Integer.parseInt(ap);
            l=le-sum;
            int g=122+f;
            String t=Integer.toString(g);
            String id1="E"+t;
                String sq="insert into tripexpense values('"+id1+"','"+d+"','"+dos+"','"+doe+"','"+ap+"','"+sum+"','"+l+"')";
            db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);
            try {
                db.execSQL(sq);
              //  Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
            catch(Exception e)
            {
                Toast.makeText(this, "Error"+e, Toast.LENGTH_SHORT).show();
            }

            // a.add("" + id);
        }
        tl = findViewById(R.id.tl);
         db = openOrCreateDatabase("EXPENSE", MODE_PRIVATE, null);
        String sq = "Select * from tripexpense";
         c = db.rawQuery(sq, null);
        while (c.moveToNext()) {
            String id=c.getString(0);
            String to = c.getString(1);
            String sd = c.getString(2);
            String ed = c.getString(3);
            String hv = c.getString(4);
            String sp = c.getString(5);
            String left = c.getString(6);
            TableRow tr = new TableRow(this);
            TextView tv7 = new TextView(this);
            TextView tv = new TextView(this);
            TextView tv1 = new TextView(this);
            TextView tv2 = new TextView(this);
            TextView tv3 = new TextView(this);
            TextView tv4 = new TextView(this);
            TextView tv5 = new TextView(this);
            tv7.setText(""+id);
            tv.setText("" + to);
            tv1.setText("" +sd );
            tv2.setText("" + ed);
            tv3.setText("" + hv);
            tv4.setText("" + sp);
            tv5.setText(""+left);
            tr.addView(tv7);
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