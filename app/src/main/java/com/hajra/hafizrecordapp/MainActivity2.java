package com.hajra.hafizrecordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    dbhandler db;
    student s;

    TextView ed1, ed2, ed3,ed4, ed5, ed6;
    CheckBox c1;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db= new dbhandler(this);
        int student_id= getIntent().getExtras().getInt("student_id");
        s= db.selectStudent(student_id);

        ed1 = findViewById(R.id.et_id1);
        ed2 = findViewById(R.id.et_name);
        ed3= findViewById(R.id.et_roll_no);
        ed4= findViewById(R.id.et_class);
        ed5= findViewById(R.id.textView21);
        ed5= findViewById(R.id.textView22);


        ed1.setText(s.getID());
        ed2.setText(s.getName());
        ed3.setText(s.getage());
        ed4.setText(s.getClass1());
        ed5.setText(s.getSabaqi());
        ed6.setText(s.getManzil());





    }
}