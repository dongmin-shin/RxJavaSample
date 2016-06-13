package com.example.dongminshin.sample.chapter8;

import com.example.dongminshin.sample.chapter8.models.stackexchange.User;
import com.example.dongminshin.sample.chapter8.models.stackexchange.UsersResponse;

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
public class StackExchangeAPIManager {

    public static final String HTTPS_API_STACKEXCHANGE_URL = "https://api.stackexchange.com";
    private static StackExchangeAPIManager INSTANCE;

    private final StackExchangeAPI stackExchangeAPI;

    private StackExchangeAPIManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HTTPS_API_STACKEXCHANGE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        stackExchangeAPI = retrofit.create(StackExchangeAPI.class);
    }

    public static StackExchangeAPIManager getInstance() {
        if (INSTANCE == null) {
            return new StackExchangeAPIManager();
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
