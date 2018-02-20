package com.example.greentech_android.sdex.facebook;

import android.os.Bundle;
import android.view.View;

import com.example.greentech_android.sdex.Utilities.Constants;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public class FriendsPresenterImplementer implements FriendsPresenter {
    private FriendListView friendListView;
    private FbFriendModel fbFriendModel;
    private List<FbFriendModel> friendModelList;
    public FriendsPresenterImplementer(FriendListView friendListView) {
        this.friendListView = friendListView;
        this.fbFriendModel = new FbFriendModel();
    }

    @Override
    public void onCreate(View rootView) {
        friendListView.initViews(rootView);

    }

    @Override
    public void getFriendsListFromFacebook() {
        friendListView.showProgress();
        getFriendsFromFriendModel();

    }

    private void getFriendsFromFriendModel() {
        friendModelList = new ArrayList<>();
        Bundle required = new Bundle();
        required.putString("fields",
                "uid, name, picture.width(200).height(200)");
        required.putString("limit", "300");
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                Constants.GET_FRIENDS_LIST,
                required,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                                /* handle the result */
                        JSONObject jsonObject = response.getJSONObject();
                        try {
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonFriend = jsonArray.getJSONObject(i);
                                FbFriendModel friend = new FbFriendModel(jsonFriend.getString("name"), jsonFriend.getJSONObject("picture").getJSONObject("data").getString("url"));
                                friendModelList.add(friend);
                            }
                            friendListView.setList(friendModelList);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
        ).executeAsync();
    }
}
