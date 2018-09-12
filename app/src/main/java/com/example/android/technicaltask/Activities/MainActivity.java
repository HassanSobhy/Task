package com.example.android.technicaltask.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android.technicaltask.Adapters.PostsAdapter;
import com.example.android.technicaltask.Models.PostsModel;
import com.example.android.technicaltask.MyInterface.GetPostsInterface;
import com.example.android.technicaltask.Network.RetrofitInstance;
import com.example.android.technicaltask.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private RecyclerView mRecyclerView;
    private PostsAdapter mAdapter;

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        mPresenter = new PresenterImpl(this, new GetPostInteractorsImpl());
        mPresenter.requestDataFromServer();
    }


    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setHasFixedSize(true);

    }


    @Override
    public void setDataToRecyclerView(List<PostsModel> postsModels) {
        mAdapter = new PostsAdapter(this, postsModels);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
