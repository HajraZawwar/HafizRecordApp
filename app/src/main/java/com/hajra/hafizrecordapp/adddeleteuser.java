package com.hajra.hafizrecordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class adddeleteuser extends AppCompatActivity {

    dbhandler db;
    student s;
    EditText ed1, ed2, ed3,ed4;
    Button b1;

    protected void oncreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddeleteuser);


        ed1 = findViewById(R.id.et_id);
        ed2 = findViewById(R.id.et_name);
        ed3= findViewById(R.id.et_roll_no);
        ed4= findViewById(R.id.et_class);
        b1 = findViewById(R.id.btn_save);

        s.setID(Integer.parseInt(ed1.getText().toString()));
        s.setName(ed1.getText().toString());
        s.setage(Integer.parseInt(ed1.getText().toString()));
        s.setClass1(Integer.parseInt(ed1.getText().toString()));

        db = new dbhandler(getApplicationContext());
        db.insertStudent(s);

    };




}