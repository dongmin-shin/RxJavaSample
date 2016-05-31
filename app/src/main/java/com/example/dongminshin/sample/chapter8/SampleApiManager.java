package com.example.dongminshin.sample.chapter8;

import com.example.dongminshin.sample.chapter8.models.User;
import com.example.dongminshin.sample.chapter8.models.UsersResponse;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by DongMinShin on 16. 6. 1..
 */
public class SampleApiManager {

    public static final String HTTPS_API_STACKEXCHANGE_URL = "https://api.stackexchange.com";
    private static SampleApiManager INSTANCE;

    private final StackExchangeAPI stackExchangeAPI;

    private SampleApiManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HTTPS_API_STACKEXCHANGE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        stackExchangeAPI = retrofit.create(StackExchangeAPI.class);
    }

    public static SampleApiManager getInstance() {
        if (INSTANCE == null) {
            return new SampleApiManager();
        }

        return INSTANCE;
    }

    public Observable<List<User>> getMostPopularSOusers(int howMany) {
        return stackExchangeAPI
                .getMostPopularSOusers(howMany)
                .map(new Func1<UsersResponse, List<User>>() {
                    @Override
                    public List<User> call(UsersResponse usersResponse) {
                        return usersResponse.getUsers();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
