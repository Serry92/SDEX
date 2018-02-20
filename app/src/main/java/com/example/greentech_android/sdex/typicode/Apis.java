package com.example.greentech_android.sdex.typicode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public interface Apis {
    @GET("photos")
    Call<List<Photos>> getPhotos();
}
