package com.example.expensemanager;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateTripActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et8,et9;
    Button b13;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_trip);
        et8=findViewById(R.id.editText8);
        et9=findViewById(R.id.editText9);
        b13=findViewById(R.id.button13);
        b13.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name=et8.getText().toString();
        String ph=et9.getText().toString();
        String sq="Update trip set  ApprovredBudget='"+ph+"' where id='"+name+"'";
        db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);
        try {
            db.execSQL(sq);
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Error"+e, Toast.LENGTH_SHORT).show();
        }

    }
}
