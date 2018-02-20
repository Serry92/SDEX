package com.example.greentech_android.sdex.facebook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.greentech_android.sdex.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardViewHolder> {
    private List<FbFriendModel> fbFriendList;
    private Context mContext;

    public RecyclerAdapter(List<FbFriendModel> fbFriendList, Context mContext) {
        this.fbFriendList = fbFriendList;
        this.mContext = mContext;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_friend, parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        holder.tvName.setText(fbFriendList.get(position).getName());
        Picasso.with(mContext).load(fbFriendList.get(position).getImgURL()).into(holder.ivProfilePic, new Callback() {
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

    }

    @Override
    public int getItemCount() {
        return fbFriendList.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivProfilePic;
        ProgressBar progressBar;

        private CardViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            ivProfilePic = itemView.findViewById(R.id.iv_profile);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }
    }
}
