package com.example.expensemanager;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertExpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et3,et4,et5,et6,et7,et8;
    Button b12; SQLiteDatabase db;String n,n1,n2,n3,n4,n5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_exp);
        et3=findViewById(R.id.editText3);
        et4=findViewById(R.id.editText4);
        et5=findViewById(R.id.editText5);
        et6=findViewById(R.id.editText6);
        et7=findViewById(R.id.editText7);
       // et8=findViewById(R.id.editText8);
        b12=findViewById(R.id.button12);
        db=openOrCreateDatabase("RCPL INDIA",MODE_PRIVATE,null);

       /* Intent i=new Intent(this,DataBaseActivity.class);
        i.putExtra("N",n);
        i.putExtra("N1",n1);
        i.putExtra("N2",n2);
        i.putExtra("N3",n3);
        i.putExtra("N4",n4);
        startActivity(i);*/
        b12.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        n=et3.getText().toString();
        n1=et4.getText().toString();
        n2=et5.getText().toString();
        n3=et6.getText().toString();
        n4=et7.getText().toString();
        //n5=et8.getText().toString();
        String sq="insert into exp values('"+n+"','"+n1+"','"+n2+"','"+n3+"','"+n4+"')";
        db=openOrCreateDatabase("EXPENSE",MODE_PRIVATE,null);
        try {
            db.execSQL(sq);
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Error"+e, Toast.LENGTH_SHORT).show();
        }
    }

}

