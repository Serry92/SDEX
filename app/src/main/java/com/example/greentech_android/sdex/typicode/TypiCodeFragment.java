package com.example.greentech_android.sdex.typicode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.greentech_android.sdex.R;
import com.facebook.login.widget.LoginButton;

import java.util.List;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public class TypiCodeFragment extends Fragment implements TypiCodeView {
    TypiCodePresenterImplementer typiCodePresenterImplementer;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    TypiCodeRecyclerAdapter recyclerAdapter;
    ProgressBar progressBar;
    LoginButton loginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        typiCodePresenterImplementer = new TypiCodePresenterImplementer(this);
        typiCodePresenterImplementer.onCreate(rootView);
        typiCodePresenterImplementer.getPhotos();
        return rootView;
    }

    @Override
    public void initViews(View rootView) {
        recyclerView = rootView.findViewById(R.id.rv_data);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        progressBar = rootView.findViewById(R.id.progress_bar);
        loginButton = rootView.findViewById(R.id.login_button);
        loginButton.setVisibility(View.GONE);
    }

    @Override
    public void setList(List<Photos> photosList) {
        progressBar.setVisibility(View.GONE);
        recyclerAdapter = new TypiCodeRecyclerAdapter(photosList, getActivity());
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }
}
