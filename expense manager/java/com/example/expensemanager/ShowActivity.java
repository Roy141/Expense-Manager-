package com.example.expensemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener {
    Button b7,b8;  SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        b7=findViewById(R.id.button7);
        b8=findViewById(R.id.button8);
        // b9=findViewById(R.id.button9);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==b7)
        {
            Intent i=new Intent(this,ShowTripActivity.class);
            startActivity(i);

        }
        if(v==b8)
        {
            Intent i=new Intent(this,ShowExpActivity.class);
            startActivity(i);

        }
    }
}
