package com.example.android.technicaltask.Activities;

import com.example.android.technicaltask.Models.PostsModel;

import java.util.List;

public class PresenterImpl implements MainContract.Presenter, MainContract.GetPostInteractors.OnFinishedListener {


    private MainContract.MainView mMainView;
    private MainContract.GetPostInteractors mGetPostInteractors;

    public PresenterImpl(MainContract.MainView mainView, MainContract.GetPostInteractors getPostInteractors) {
        this.mMainView = mainView;
        this.mGetPostInteractors = getPostInteractors;
    }


    @Override
    public void onDestroy() {
        mMainView = null;
    }


    @Override
    public void requestDataFromServer() {
        mGetPostInteractors.getPostsList(this);
    }

    @Override
    public void onFinished(List<PostsModel> postsModels) {
        if(mMainView != null){
            mMainView.setDataToRecyclerView(postsModels);
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mMainView != null){
            mMainView.onResponseFailure(t);
        }
    }
}
