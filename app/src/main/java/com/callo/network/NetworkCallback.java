package com.callo.network;

/**
 * Created by abhishesh.s on 5/8/16.
 */
public interface NetworkCallback<Param> {
    void onSuccess(Param param);

    void onFail(Exception e);
}
