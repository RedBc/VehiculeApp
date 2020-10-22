package com.example.vehiculeapp.api;

import com.example.vehiculeapp.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    
    @GET("vehicle/list?icon=1&lang=en-gb&forceStandard=1&outputFormat=json&appToken=8qohg5a9c6q6x58szpyxizvp91yary3setxdxutl10dugtel1syjs6gmrp33oo40a356j2cxt6vdcpzg095drsym5blnyen0hi4bdq32j61clfux2i9vtuhr")
    Call<ApiResponse> getListVehicle();

}