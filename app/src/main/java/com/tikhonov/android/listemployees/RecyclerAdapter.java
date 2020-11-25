package com.tikhonov.android.listemployees;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    private List<Employee> persons;
    private Context context;

    public RecyclerAdapter(List<Employee> persons, Context context) {
        this.persons = persons;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_view, parent, false);
        return new EmployeeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        Employee person = persons.get(position);
        holder.bind(person);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
