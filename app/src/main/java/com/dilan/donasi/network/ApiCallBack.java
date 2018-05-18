package com.dilan.donasi.network;



import retrofit2.HttpException;
import rx.Subscriber;

/**
 * Created by Rosinante24 on 10/01/18.
 */

public abstract class ApiCallBack<M> extends Subscriber<M> {

    public abstract void onSuccess(M data);

    public abstract void onFailure(String msg);

    public abstract void onFinish();

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            if (code == 504) {
                msg = "Error Response";
            }
            if (code == 502 || code == 404) {
                msg = "Error Connect";
            }
            onFailure(msg);
        } else {
            onFailure(e.getMessage());
        }
        onFinish();

    }

    @Override
    public void onNext(M data) {
        onSuccess(data);

    }

    @Override
    public void onCompleted() {
    }
}

