package com.example.greentech_android.sdex.typicode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.greentech_android.sdex.R;
import com.example.greentech_android.sdex.Utilities.Constants;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public class TypiCodeRecyclerAdapter extends RecyclerView.Adapter<TypiCodeRecyclerAdapter.CardViewHolder> {
    private List<Photos> photosList;
    private Context mContext;

    public TypiCodeRecyclerAdapter(List<Photos> photosList, Context mContext) {
        this.photosList = photosList;
        this.mContext = mContext;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_friend, parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, final int position) {
        holder.tvName.setText(photosList.get(position).getTitle());
        Picasso.with(mContext).load(photosList.get(position).getThumbnailUrl()).into(holder.ivProfilePic, new Callback() {
            @Override
            public void onSuccess() {
                holder.ivProfilePic.setVisibility(View.VISIBLE);
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                holder.ivProfilePic.setVisibility(View.VISIBLE);
                holder.progressBar.setVisibility(View.GONE);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Photos photo = photosList.get(position);
                Intent intent = new Intent(mContext, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constants.KEY_INTENT, photo);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivProfilePic;
        ProgressBar progressBar;
        CardView cardView;

        private CardViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            ivProfilePic = itemView.findViewById(R.id.iv_profile);
            progressBar = itemView.findViewById(R.id.progress_bar);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
