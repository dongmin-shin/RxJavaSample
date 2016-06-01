package com.example.dongminshin.sample.chapter8.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dongminshin.rxjavasample.R;
import com.example.dongminshin.sample.chapter8.SampleApiManager;
import com.example.dongminshin.sample.chapter8.models.User;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by DongMinShin on 16. 6. 1..
 */
public class StackExchangeActivity extends AppCompatActivity {

    @BindView(R.id.stack_exchange_recycler_view)
    RecyclerView recyclerView;

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_exchange);
        ButterKnife.bind(this);

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));

        recyclerView.setHasFixedSize(true);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<>());
        recyclerView.setAdapter(recyclerViewAdapter);

        refreshUserList();
    }

    private void refreshUserList() {
        SampleApiManager.getInstance().getMostPopularSOusers(10)
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("TEST", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TEST", "onError", e);
                    }

                    @Override
                    public void onNext(List<User> userList) {
                        recyclerViewAdapter.updateUserList(userList);
                    }
                });
    }

}
