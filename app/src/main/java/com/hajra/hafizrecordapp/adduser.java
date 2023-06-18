package com.hajra.hafizrecordapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hajra.hafizrecordapp.dbhandler;
import com.hajra.hafizrecordapp.student;

public class adduser extends AppCompatActivity {

    dbhandler db;
    student s;
    EditText ed1, ed2, ed3, ed4;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

            b1= findViewById(R.id.btn_save);
            b2=findViewById(R.id.btn_delete);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1 = findViewById(R.id.et_id);
                ed2 = findViewById(R.id.et_name);
                ed3 = findViewById(R.id.et_roll_no);
                ed4 = findViewById(R.id.et_class);
                b1 = findViewById(R.id.btn_save);

               // Toast.makeText(getBaseContext(),"Hello World",Toast.LENGTH_LONG).show();


                db = new dbhandler(getApplicationContext());
                db.insertStudent(s);

                s.setID(Integer.parseInt(ed1.getText().toString()));
                s.setName(ed2.getText().toString());
                s.setage(Integer.parseInt(ed3.getText().toString()));
                s.setClass1(Integer.parseInt(ed4.getText().toString()));

                //Toast.makeText(getBaseContext(),"Hello World1",Toast.LENGTH_LONG).show();

                //Toast.makeText(getBaseContext(),"Hello World2",Toast.LENGTH_LONG).show();

            }


        });

      /*  b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1 = findViewById(R.id.et_id);

                if (ed1= )

                Toast.makeText(getBaseContext(),"Hello World",Toast.LENGTH_LONG).show();

                s.setID(Integer.parseInt(ed1.getText().toString()));
                s.setName(ed2.getText().toString());
                s.setage(Integer.parseInt(ed3.getText().toString()));
                s.setClass1(Integer.parseInt(ed4.getText().toString()));

                Toast.makeText(getBaseContext(),"Hello World1",Toast.LENGTH_LONG).show();

                db = new dbhandler(getApplicationContext());
                db.deleteStudent(s);
                Toast.makeText(getBaseContext(),"Hello World2",Toast.LENGTH_LONG).show();

            }


        });*/


    }
}
