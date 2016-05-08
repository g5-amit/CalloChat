package com.callo.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by abhishesh.s on 5/8/16.
 */
public class ContactItem implements Serializable {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("name")
    private String name;

    @SerializedName("mobile")
    private String mobileNumber;

    @SerializedName("user_status")
    private String userStatus;

    @SerializedName("latitude")
    private String latitude; // should be double

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("is_location_shared")
    private String locationShared;

    @SerializedName("is_call")
    private String call;

    private boolean canCall() {
        if (call != null) {
            return call.equals("1");
        }
        return false;
    }

    public boolean isLocationShared() {
        if (locationShared != null) {
            return locationShared.equals("1");
        }
        return false;
    }
}
