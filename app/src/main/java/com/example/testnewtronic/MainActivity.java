package com.example.testnewtronic;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://103.183.75.112/api/directory/dataList";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        // Panggil metode untuk mendapatkan data dari API
        Call<DataResponse> call = apiService.getDataList();
        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()) {
                    // Proses data yang diterima
                    DataResponse dataResponse = response.body();
                    if (dataResponse != null) {
                        List<Data> dataList = dataResponse.getDataList();
                        // Lakukan sesuatu dengan dataList, misalnya tampilkan di Logcat
                        for (Data data : dataList) {
                            Log.d(TAG, "Data Title: " + data.getTitle());
                            // Lakukan sesuatu dengan data lainnya sesuai kebutuhan Anda
                        }
                    }
                } else {
                    Log.e(TAG, "Error: " + response.code());
                    // Tangani kesalahan jika respons tidak berhasil
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
                // Tangani kesalahan saat gagal melakukan panggilan jaringan
            }
        });
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        ViewpagerAdapter adapter = new ViewpagerAdapter(this); // 'this' dapat diganti dengan aktivitas atau fragmen Anda
        viewPager.setAdapter(adapter);

    }
}