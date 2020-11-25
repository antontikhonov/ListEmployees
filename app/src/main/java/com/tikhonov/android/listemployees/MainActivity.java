package com.tikhonov.android.listemployees;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<Employee> employees = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MockyApi mockyApi = retrofit.create(MockyApi.class);
        mockyApi.getCompanyList().enqueue(new Callback<CompanyList>() {
            @Override
            public void onResponse(@NonNull Call<CompanyList> call, @NonNull Response<CompanyList> response) {
                if (response.isSuccessful()) {
                    employees.addAll(response.body().getCompany().getEmployees());
                    for (Employee employee : employees) {
                        if (employee.getName() == null) {
                            employee.setName("");
                        }
                    }
                    Collections.sort(employees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
                    recyclerView.setAdapter(new RecyclerAdapter(employees, MainActivity.this));
                } else {
                    Toast.makeText(MainActivity.this, R.string.error + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CompanyList> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, R.string.database_broken, Toast.LENGTH_LONG).show();
            }
        });
    }
}