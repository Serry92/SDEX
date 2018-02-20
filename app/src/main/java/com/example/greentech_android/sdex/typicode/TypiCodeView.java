package com.example.greentech_android.sdex.typicode;

import android.view.View;

import com.example.greentech_android.sdex.facebook.FbFriendModel;

import java.util.List;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public interface TypiCodeView {
    void initViews(View rootView);

    void setList(List<Photos> fbFriendModelList);

    void showProgress();
}
