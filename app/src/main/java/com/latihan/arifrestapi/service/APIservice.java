package com.latihan.arifrestapi.service;

import com.latihan.arifrestapi.model.Mahasiswa;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIservice {
    @GET("posts/{id}")
    Call<Mahasiswa> getMahasiswa(@Path("id") int postId);
    @POST("mahasiswas")
    Call<Mahasiswa> createMahasiswa(@Body Mahasiswa post);
}
