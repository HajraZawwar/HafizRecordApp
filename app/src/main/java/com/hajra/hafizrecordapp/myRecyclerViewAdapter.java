package com.hajra.hafizrecordapp;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH> {

    List<student> studentList;

    public myRecyclerViewAdapter(List<student> studentList)
    {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_entry, parent, false);

        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position)
    {

        student s = new student();

        holder.data=studentList.get(position);
        holder.textViewFriendID.setText(Integer.toString(holder.data.getID()));
        holder.textViewFriendName.setText(holder.data.getName());
        holder.textViewdateFriend.setText(String.valueOf(holder.data.getage()));
        holder.textViewCity.setText(Integer.toString(holder.data.getClass1()));
        holder.delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
              dbhandler db= new dbhandler(view.getContext());
                Toast.makeText(view.getContext(), Integer.toString(holder.data.getID()),Toast.LENGTH_LONG).show();
                db.deleteStudent(holder.data.getID());



            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               /* dbhandler db= new dbhandler(view.getContext());
                Toast.makeText(view.getContext(),  Integer.toString(holder.data.getID()),Toast.LENGTH_LONG).show();*/
                Intent I;

                I = new Intent(view.getContext(), edit.class);


                I.putExtra("StudentID",holder.data.getID());
                view.getContext().startActivity(I);
            }
        });


        holder.progress.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               /* dbhandler db= new dbhandler(view.getContext());
                Toast.makeText(view.getContext(),  Integer.toString(holder.data.getID()),Toast.LENGTH_LONG).show();*/
                Intent I;

                I = new Intent(view.getContext(), MainActivity2.class);


                I.putExtra("StudentID",holder.data.getID());
                view.getContext().startActivity(I);
            }
        });


        //holder.edit.getContext();


       /*View itemView= null;

        Button delete = itemView.findViewById(R.id.btn_delete);

        Button edit = itemView.findViewById(R.id.btn_edit);

        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "new delete",Toast.LENGTH_LONG).show();

            }


        });

        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "new edit",Toast.LENGTH_LONG).show();

            }


        });*/
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {

        public View myRecyclerViewAdapter;
        TextView textViewFriendID;
        TextView textViewFriendName;

        TextView textViewdateFriend;
        TextView textViewCity;
        student data;

        Button delete, edit, progress;
        public MyVH(@NonNull View itemView) {
            super(itemView);

            textViewFriendID= itemView.findViewById(R.id.textViewFriendID);
            textViewFriendName = itemView.findViewById(R.id.textViewFriendName);
            textViewdateFriend = itemView.findViewById(R.id.textViewDate);
            textViewCity = itemView.findViewById(R.id.textViewCity);
            delete=itemView.findViewById(R.id.btn_delete);
            edit=itemView.findViewById(R.id.btn_edit);
            progress=itemView.findViewById(R.id.btn_progress);

        }



    }
}