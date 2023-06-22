package com.hajra.hafizrecordapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<student> studentList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    dbhandler db;

    EditText search;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LinearLayout l= findViewById(R.id.mainactivityroot);

        //View itemView = getLayoutInflater().inflate(R.layout.single_entry, l, false);


       // View itemView = LayoutInflater.from(this).inflate(R.layout.single_entry, null, false);

        b1 = findViewById(R.id.button1);
        //b2 = findViewById(R.id.button);
        //search = findViewById(R.id.editTextNumber) ;


        db = new dbhandler(this);

        student s = new student();

        List<student> sts = db.selectAllStudents();


        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(MainActivity.this);
        //  layoutManager = new LinearLayoutManager(MainActivity.this,
        //  LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(sts);


        recyclerView.setAdapter(adapter);

        //adapter.notifyDataSetChanged();


      b1.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {

             Intent I;

                I = new Intent(MainActivity.this, adduser.class);

                startActivity(I);

              // Toast.makeText(getBaseContext(),"Hello World",Toast.LENGTH_LONG).show();

            }


        });

      /* b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent I = new Intent(MainActivity.this, MainActivity2.class);
                //I.putExtra("ID",  );
                startActivity(I);
            }


        });*/





    }
    }

