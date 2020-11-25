package com.tikhonov.android.listemployees;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MockyApi {
    @GET("/v2/5ddcd3673400005800eae483")
    Call<CompanyList> getCompanyList();
}
