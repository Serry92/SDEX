package com.example.greentech_android.sdex.facebook;

import android.view.View;

import java.util.List;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public interface FriendListView {
    void initViews(View rootView);

    void setList(List<FbFriendModel> fbFriendModelList);

    void showProgress();
}
