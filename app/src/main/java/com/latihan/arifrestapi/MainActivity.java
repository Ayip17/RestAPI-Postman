package com.latihan.arifrestapi;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.latihan.arifrestapi.model.Mahasiswa;
import com.latihan.arifrestapi.service.APIclient;
import com.latihan.arifrestapi.service.APIservice;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    APIservice apiService;


    TextView mNama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        mNama = findViewById(R.id.tvNama);


        retrofit = APIclient.getRetrofitInstance();
        apiService = retrofit.create(APIservice.class);


    }


    public void onButtonCick(View v){


        Call<Mahasiswa> call = apiService.getMahasiswa(8);
        call.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {


                Mahasiswa mh = response.body();
                String nama = mh.getNama();
                mNama.setText(nama);


            }


            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable throwable) {


            }
        });
    }

}