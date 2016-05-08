package com.callo.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by abhishesh.s on 5/8/16.
 */
public class DummyUser implements Serializable {

    @SerializedName("user_id")
    private String userId;
}
