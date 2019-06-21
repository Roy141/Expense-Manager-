package com.example.expensemanager;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteTripActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et9;
    SQLiteDatabase db;
    Button b14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_trip);
        et9=findViewById(R.id.editText10);
        b14=findViewById(R.id.button14);
        b14.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name=et9.getText().toString();
        String sq="Delete from trip where id='"+name+"'";
        db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);
        try {
            db.execSQL(sq);
            Toast.makeText(DeleteTripActivity.this, "Data Dleleted", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(DeleteTripActivity.this, "Error"+e, Toast.LENGTH_SHORT).show();
        }
    }
}
