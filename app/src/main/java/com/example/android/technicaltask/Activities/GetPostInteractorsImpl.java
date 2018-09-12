package com.example.android.technicaltask.Activities;

import android.widget.Toast;

import com.example.android.technicaltask.Models.PostsModel;
import com.example.android.technicaltask.MyInterface.GetPostsInterface;
import com.example.android.technicaltask.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPostInteractorsImpl implements MainContract.GetPostInteractors {

    @Override
    public void getPostsList(final OnFinishedListener onFinishedListener) {

        // Create handle for the RetrofitInstance interface
        GetPostsInterface postsInterface = RetrofitInstance.getRetrofitInstance().create(GetPostsInterface.class);

        //Call the method with parameter in the interface to get the post data
        Call<List<PostsModel>> connection = postsInterface.getPosts();

        connection.enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
