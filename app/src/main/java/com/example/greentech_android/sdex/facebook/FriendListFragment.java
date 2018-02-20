package com.example.greentech_android.sdex.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.greentech_android.sdex.R;
import com.example.greentech_android.sdex.login.LoginActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;

import java.util.List;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public class FriendListFragment extends Fragment implements FriendListView {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    FriendsPresenterImplementer friendsPresenterImplementer;
    RecyclerAdapter recyclerAdapter;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        friendsPresenterImplementer = new FriendsPresenterImplementer(this);
        friendsPresenterImplementer.onCreate(rootView);
        friendsPresenterImplementer.getFriendsListFromFacebook();
        return rootView;
    }

    @Override
    public void initViews(View rootView) {
        recyclerView = rootView.findViewById(R.id.rv_data);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        progressBar = rootView.findViewById(R.id.progress_bar);

    }

    @Override
    public void setList(List<FbFriendModel> fbFriendModelList) {
        progressBar.setVisibility(View.GONE);
        recyclerAdapter = new RecyclerAdapter(fbFriendModelList, getActivity());
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }
}
