package com.callo.network;


import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by abhishesh.s on 5/8/16.
 */
public enum NetworkRequest {
    INSTANCE;
    public static final MediaType MEDIA_TYPE_JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static final String DEFAULT_TAG = "DEFAULT";
    private final OkHttpClient client = new OkHttpClient();


    public <T> void getData(String url, String tag, final Class<T> responseClass, final NetworkCallback<T> callback) {
        Request request = new Request.Builder()
                .url(url)
                .tag(DEFAULT_TAG)
                .tag(tag)
                .build();
        doNetworkCall(client, request, responseClass, callback);
    }

    public <T> void getData(String url, final Class<T> responseClass, final NetworkCallback<T> callback) {
        Request request = new Request.Builder()
                .url(url)
                .tag(DEFAULT_TAG)
                .build();
        doNetworkCall(client, request, responseClass, callback);
    }


    public <T> void postData(String url, String tag, Object postBean, Class<T> responseClass, NetworkCallback<T> callback) {
        String jsonRequest = null;
        try {
            Gson gson = new Gson();
            jsonRequest = gson.toJson(postBean);
            Request request = new Request.Builder()
                    .url(url)
                    .tag(DEFAULT_TAG)
                    .tag(tag)
                    .post(RequestBody.create(MEDIA_TYPE_JSON, jsonRequest))
                    .build();
            doNetworkCall(client, request, responseClass, callback);
        } catch (Exception e) {

        }
    }

    public <T> void postData(String url, Object postBean, Class<T> responseClass, NetworkCallback<T> callback) {
        String jsonRequest = null;
        try {
            Gson gson = new Gson();
            jsonRequest = gson.toJson(postBean);
//            Log.d("ABHISHESH","jsonRequest: " + jsonRequest);
            Request request = new Request.Builder()
                    .url(url)
                    .tag(DEFAULT_TAG)
                    .post(RequestBody.create(MEDIA_TYPE_JSON, jsonRequest))
                    .build();
            doNetworkCall(client, request, responseClass, callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private <T> void doNetworkCall(OkHttpClient client,
                                   Request request,
                                   final Class<T> responseClass,
                                   final NetworkCallback callback) {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFail(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Reader res = null;

                try {
                    res = response.body().charStream();
/*
                    BufferedReader in = new BufferedReader(res);
                    String line = null;
                    StringBuilder rslt = new StringBuilder();
                    while ((line = in.readLine()) != null) {
                        rslt.append(line);
                    }
                    Log.d("ABHISHESH","res: " + rslt.toString());*/
                    T result = new Gson().fromJson(res, responseClass);
                    callback.onSuccess(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

