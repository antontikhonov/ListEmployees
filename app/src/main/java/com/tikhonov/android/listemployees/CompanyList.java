package com.tikhonov.android.listemployees;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyList {

    @SerializedName("company")
    @Expose
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}