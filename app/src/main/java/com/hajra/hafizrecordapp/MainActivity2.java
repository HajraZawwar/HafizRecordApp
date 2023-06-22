package com.hajra.hafizrecordapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    dbhandler db;
    student s;

    TextView ed1, ed5, ed6;
    CheckBox c1;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db= new dbhandler(this);
        int student_id= getIntent().getExtras().getInt("StudentID");
        s= db.selectStudent(student_id);
        //Toast.makeText(getBaseContext(), Integer.toString(student_id) ,Toast.LENGTH_LONG).show();



        ed1 = findViewById(R.id.editsabaq);
        ed5= findViewById(R.id.textView21);
        ed6= findViewById(R.id.textView22);


        ed1.setText(Integer.toString(s.getSabaq()));
        //ed5.setText(s.getSabaqi());
        //ed6.setText(s.getManzil());










      c1 = findViewById(R.id.cb_completed);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                   // db.updateStudent(s.getManzil());

                }
            }
        });




    }
}