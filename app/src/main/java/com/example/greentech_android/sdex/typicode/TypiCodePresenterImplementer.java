package com.example.greentech_android.sdex.typicode;

import android.view.View;

import com.example.greentech_android.sdex.Utilities.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public class TypiCodePresenterImplementer implements TypiCodePresenter {
    private TypiCodeView typiCodeView;

    TypiCodePresenterImplementer(TypiCodeView typiCodeView) {
        this.typiCodeView = typiCodeView;
    }

    @Override
    public void onCreate(View rootView) {
        typiCodeView.initViews(rootView);
    }

    @Override
    public void getPhotos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.GET_TYPICODE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apis apis = retrofit.create(Apis.class);
        Call<List<Photos>> listCall = apis.getPhotos();
        listCall.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                List<Photos> photosList = response.body();
                typiCodeView.setList(photosList);
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {

            }
        });

    }
}
