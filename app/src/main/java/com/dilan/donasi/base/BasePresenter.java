package com.dilan.donasi.base;

import com.dilan.donasi.network.ApiClient;
import com.dilan.donasi.network.ServiceApi;
import com.google.firebase.database.DatabaseReference;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Alvin on 02/02/2018.
 */

public class BasePresenter<V> {

    private V mvpView;
    private CompositeSubscription compositeSubscription;
    public DatabaseReference databaseReference;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        ServiceApi serviceApi = ApiClient.request().create(ServiceApi.class);
    }


    public void detachView() {
        this.mvpView = null;
        onUnsubscribe();
    }

    public void onUnsubscribe() {
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
        }
    }


    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}