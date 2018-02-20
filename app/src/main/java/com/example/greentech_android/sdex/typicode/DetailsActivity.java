package com.example.greentech_android.sdex.typicode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.greentech_android.sdex.R;
import com.example.greentech_android.sdex.Utilities.Constants;
import com.squareup.picasso.Picasso;

/**
 * Created by GreenTech-Android on 2/21/2018.
 */

public class DetailsActivity extends AppCompatActivity {
    TextView tvTitle, tvAlbum, tvID;
    ImageView ivPhoto;
    Photos photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().getSerializable(Constants.KEY_INTENT) != null) {
            photo = (Photos) getIntent().getExtras().getSerializable(Constants.KEY_INTENT);
            if (photo != null) {
                setViews(photo);
            }
        }
    }

    private void setViews(Photos photo) {
        if (photo != null) {
            tvTitle=findViewById(R.id.tv_title);
            tvAlbum=findViewById(R.id.tv_album_id);
            tvID=findViewById(R.id.tv_id);
            ivPhoto=findViewById(R.id.iv_profile);
            tvTitle.setText(photo.getTitle());
            tvAlbum.setText(photo.getAlbumId());
            tvID.setText(photo.getId());
            Picasso.with(this).load(photo.getUrl()).into(ivPhoto);
        }
    }
}

