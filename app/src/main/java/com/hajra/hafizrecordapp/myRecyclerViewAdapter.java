package com.hajra.hafizrecordapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyVH holder, int position) {
        holder.data=studentList.get(position);
        holder.textViewFriendID.setText(Integer.toString(holder.data.getID()));
        holder.textViewFriendName.setText(holder.data.getName());
        holder.textViewdateFriend.setText(String.valueOf(holder.data.getage()));
        holder.textViewCity.setText(Integer.toString(holder.data.getClass1()));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {

        TextView textViewFriendID;
        TextView textViewFriendName;

        TextView textViewdateFriend;
        TextView textViewCity;
        student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);

            textViewFriendID= itemView.findViewById(R.id.textViewFriendID);
            textViewFriendName = itemView.findViewById(R.id.textViewFriendName);
            textViewdateFriend = itemView.findViewById(R.id.textViewDate);
            textViewCity = itemView.findViewById(R.id.textViewCity);
        }
    }
}