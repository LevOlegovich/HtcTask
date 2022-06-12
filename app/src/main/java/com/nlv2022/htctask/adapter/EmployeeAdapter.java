package com.nlv2022.htctask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nlv2022.htctask.R;
import com.nlv2022.htctask.pojo.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);

        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.name.setText(employee.getName());
        holder.phoneNumber.setText(employee.getPhoneNumber());
        holder.skills.setText(employee.getSkills().toString());//.replace("[", "/").replace("]", "/"));


    }

    @Override
    public int getItemCount() {
        return employees.size();
    }


    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView phoneNumber;
        private TextView skills;


        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            phoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            skills = itemView.findViewById(R.id.tvSkills);

        }
    }


}
