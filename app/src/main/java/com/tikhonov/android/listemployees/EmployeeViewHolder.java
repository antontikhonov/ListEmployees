package com.tikhonov.android.listemployees;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView phoneNumberTextView;
    private TextView skillsTextView;

    public EmployeeViewHolder(View itemView) {
        super(itemView);
        nameTextView = (TextView) itemView.findViewById(R.id.name);
        phoneNumberTextView = (TextView) itemView.findViewById(R.id.phone_number);
        skillsTextView = (TextView) itemView.findViewById(R.id.skills);
    }

    public void bind(Employee person) {
        setNameTextView(person.getName());
        setPhoneNumberTextView(person.getPhoneNumber());
        setSkillsTextView(person.getSkills());
    }

    private void setNameTextView(String name) {
        if (!name.equals("")) {
            nameTextView.setText(name);
        } else {
            nameTextView.setText(R.string.no_name);
        }
    }

    private void setPhoneNumberTextView(String phoneNumber) {
        if (phoneNumber != null) {
            phoneNumberTextView.setText(phoneNumber);
        } else {
            phoneNumberTextView.setText(R.string.no_phone_number);
        }
    }

    private void setSkillsTextView(List<String> skills) {
        if (skills != null) {
            skillsTextView.setText(joinToString(skills));
        } else {
            skillsTextView.setText(R.string.no_skills);
        }
    }

    private String joinToString(List<String> list) {
        StringBuilder result = new StringBuilder("Skills: ");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) result.append(", ");
            result.append(list.get(i));
        }
        return result.toString();
    }
}
