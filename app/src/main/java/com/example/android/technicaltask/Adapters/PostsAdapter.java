package com.example.android.technicaltask.Adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.technicaltask.Models.PostsModel;
import com.example.android.technicaltask.R;

import java.util.List;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {


    Context mContext;
    List<PostsModel> mPostsModels;

    public PostsAdapter(Context context, List<PostsModel> postsModels) {
        mContext = context;
        mPostsModels = postsModels;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_item, parent, false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {

        holder.mUserIdTextView.setText("id : " + String.valueOf(mPostsModels.get(position).getUserId()));
        holder.mIdTextView.setText("user id : " + String.valueOf(mPostsModels.get(position).getId()));
        holder.mTitleTextView.setText("title : " + mPostsModels.get(position).getTitle() + "\n");
        holder.mBodyTextView.setText("body : " +mPostsModels.get(position).getBody() + "\n");
    }

    @Override
    public int getItemCount() {

        if (mPostsModels == null)
            return 0;

        return mPostsModels.size();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder {

        TextView mUserIdTextView;
        TextView mIdTextView;
        TextView mTitleTextView;
        TextView mBodyTextView;


        public PostsViewHolder(View itemView) {
            super(itemView);

            mUserIdTextView = itemView.findViewById(R.id.user_id_tv);
            mIdTextView = itemView.findViewById(R.id.id_tv);
            mTitleTextView = itemView.findViewById(R.id.title_tv);
            mBodyTextView = itemView.findViewById(R.id.body_tv);

        }
    }

}
