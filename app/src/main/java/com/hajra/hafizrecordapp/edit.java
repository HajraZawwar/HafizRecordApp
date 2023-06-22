package com.hajra.hafizrecordapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hajra.hafizrecordapp.dbhandler;
import com.hajra.hafizrecordapp.student;

public class edit extends AppCompatActivity
{

    dbhandler db;
    student s;
    EditText ed1, ed2, ed3, ed4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);



        b1= findViewById(R.id.btn_save);


        int value = getIntent().getExtras().getInt("StudentID");
        Toast.makeText(this,Integer.toString(value),Toast.LENGTH_LONG).show();
        db = new dbhandler(getApplicationContext());
        student s = db.selectStudent(value);

        ed1 = findViewById(R.id.et_id);
        ed2 = findViewById(R.id.et_name);
        ed3 = findViewById(R.id.et_roll_no);
        ed4 = findViewById(R.id.et_class);
        //b1 = findViewById(R.id.btn_save);

        ed1.setText(Integer.toString(s.getID()));
        ed2.setText(s.getName());
        ed3.setText(Integer.toString(s.getage()));
        ed4.setText(Integer.toString(s.getClass1()));



       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ed1 = findViewById(R.id.et_id);
                //ed2 = findViewById(R.id.et_name);
               // ed3 = findViewById(R.id.et_roll_no);
               // ed4 = findViewById(R.id.et_class);
               // b1 = findViewById(R.id.btn_save);

                // Toast.makeText(getBaseContext(),"Hello World",Toast.LENGTH_LONG).show();
                db = new dbhandler(getApplicationContext());
                student sv= new student();


                sv.setID(Integer.parseInt(ed1.getText().toString()));
                sv.setName(ed2.getText().toString());
                sv.setage(Integer.parseInt(ed3.getText().toString()));
                sv.setClass1(Integer.parseInt(ed4.getText().toString()));


                //Toast.makeText(getBaseContext(), Integer.toString(sv.getID()) ,Toast.LENGTH_LONG).show();
               // Toast.makeText(getBaseContext(), sv.getName() ,Toast.LENGTH_LONG).show();
                //Toast.makeText(getBaseContext(), Integer.toString(sv.getage()) ,Toast.LENGTH_LONG).show();
                //Toast.makeText(getBaseContext(), Integer.toString(sv.getClass1()) ,Toast.LENGTH_LONG).show();

                db.updateStudent(sv);




            }


        });



    }
}