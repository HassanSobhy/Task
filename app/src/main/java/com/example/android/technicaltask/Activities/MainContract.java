package com.example.android.technicaltask.Activities;

import com.example.android.technicaltask.Models.PostsModel;

import java.util.List;

public interface MainContract {


    //Call when user interact with the view and other when view OnDestroy()
    interface Presenter {

        void onDestroy();
        
        void requestDataFromServer();

    }


    //  the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
    interface MainView {


        void setDataToRecyclerView(List<PostsModel> postsModels);

        void onResponseFailure(Throwable throwable);

    }

    // Interactors are classes built for fetching data from your database, web services, or any other data source.
    interface GetPostInteractors {

        interface OnFinishedListener {
            void onFinished(List<PostsModel> postsModels);

            void onFailure(Throwable t);
        }

        void getPostsList(OnFinishedListener onFinishedListener);
    }
}
