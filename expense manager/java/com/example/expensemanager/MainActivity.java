package com.example.expensemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button b10,b12,b13;
    SQLiteDatabase db;String sq;
    Spinner sp;
    String[] op={"Select Operation to perform","Update Table","Insert into Table","Show Table","Delete from Table"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.spinner);

       /* b7=findViewById(R.id.button7);
        b8=findViewById(R.id.button8);
        b9=findViewById(R.id.button9);*/
        b10=findViewById(R.id.button10);
        //b11=findViewById(R.id.button11);
        b12=findViewById(R.id.button12);
        b13=findViewById(R.id.button13);
        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,op);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(this);

       /* b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);*/
        b10.setOnClickListener(this);
        //b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);
        String sq="create table  if not exists trip(id varchar primary key,Destination varchar,StartFrom varchar,Dateofstart varchar,Dateofend varchar,ApprovredBudget varchar)";
        try {
            db.execSQL(sq);
            //Toast.makeText(this, "Table Created", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Error"+e, Toast.LENGTH_SHORT).show();
        }
        db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);
        sq="create table  if not exists exp(expenseid integer primary key,Category varchar,Amount varchar,Date varchar,id varchar)";
        try {
            db.execSQL(sq);
            //Toast.makeText(this, "Table Created", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Error"+e, Toast.LENGTH_SHORT).show();
        }

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
        db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);
       String s="create table  if not exists catexpense(id varchar,dest varchar,cat varchar ,spend varchar)";
        try {
            db.execSQL(s);
        //    Toast.makeText(this, "Table Created", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Error"+e, Toast.LENGTH_SHORT).show();
        }
        db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);
       String q="create table  if not exists dayexpense(id varchar,dest varchar,date varchar,spend varchar)";
        try {
            db.execSQL(q);
          //  Toast.makeText(this, "Table Created", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Error"+e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
    /*    if(v==b7)
        {
            Intent i=new Intent(this,CreateActivity.class);
            startActivity(i);

        }
        if(v==b8)
        {
            Intent i=new Intent(this,InsertActivity.class);
            startActivity(i);

        }
        if(v==b9)
        {
            Intent i=new Intent(this,ShowActivity.class);
            startActivity(i);

        }*/
        if (v == b10) {
            String sq = "Delete  from tripexpense";
            db = openOrCreateDatabase("EXPENSE", MODE_PRIVATE, null);
            try {
                db.execSQL(sq);
                //Toast.makeText(MainActivity.this, "Data Dleleted", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Error" + e, Toast.LENGTH_SHORT).show();
            }

            Intent i = new Intent(this, TripWiseexpenseActivity.class);
            startActivity(i);

        }
        /*if(v==b11)
        {
            Intent i=new Intent(this,DeleteActivity.class);
            startActivity(i);

        }*/
        if (v == b12) {
            String sq = "Delete  from catexpense";
            db = openOrCreateDatabase("EXPENSE", MODE_PRIVATE, null);
            try {
                db.execSQL(sq);
                //Toast.makeText(MainActivity.this, "Data Dleleted", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Error" + e, Toast.LENGTH_SHORT).show();
            }
            Intent i = new Intent(this, CategoryWiseExpActivity.class);
            startActivity(i);

        }
        if (v == b13) {
            String sq = "Delete  from dayexpense";
            db = openOrCreateDatabase("EXPENSE", MODE_PRIVATE, null);
            try {
                db.execSQL(sq);
                //Toast.makeText(MainActivity.this, "Data Dleleted", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Error" + e, Toast.LENGTH_SHORT).show();
            }
            Intent i = new Intent(this, DayWiseExpActivity.class);
            startActivity(i);

        }

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
if(position==1)
{
    Intent i=new Intent(this,CreateActivity.class);
    startActivity(i);

}
if(position==2)
{
    Intent i=new Intent(this,InsertActivity.class);
    startActivity(i);

}
if(position==3)
{
    Intent i=new Intent(this,ShowActivity.class);
    startActivity(i);

}
if(position==4)
{
    Intent i=new Intent(this,DeleteActivity.class);
    startActivity(i);

}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
