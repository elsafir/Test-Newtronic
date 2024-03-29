package com.example.testnewtronic;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("directory/dataList")
    Call<DataResponse> getDataList();
}

