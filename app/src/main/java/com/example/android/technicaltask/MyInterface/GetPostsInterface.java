package com.example.android.technicaltask.MyInterface;

import com.example.android.technicaltask.Models.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetPostsInterface {

    @GET("posts")
    Call<List<PostsModel>> getPosts();

}
