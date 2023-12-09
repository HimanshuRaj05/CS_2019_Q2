package com.intreve.cs_2019_q2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnUpdate, btnLog;

    MyDatabaseHelper myDB;

    //IMPORTANT: READ THE COMMENTS

    //The answer to this question is the whole MyDatabaseHelper class code

    //For exam writing the code of MainActivity is mostly optional, not necessary in this question

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert=findViewById(R.id.btnInsert);
        btnUpdate=findViewById(R.id.btnUpdate);

        myDB=new MyDatabaseHelper(MainActivity.this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.insertMultipleRecords();
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.updateTableEntries("Title1", "Title5");
            }
        });

    }
}