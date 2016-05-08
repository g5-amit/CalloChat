package com.callo.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by abhishesh.s on 5/8/16.
 */
public class User implements Serializable {

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @SerializedName("credentials")
    private UserData userData;

    public static class UserData implements Serializable {
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @SerializedName("email")
        private String email;

        @SerializedName("device_id")
        private String deviceId;

        @SerializedName("mobile")
        private String mobile;

        @SerializedName("name")
        private String name;

        @Override
        public String toString() {
            return "[ " + name + " " + email + " " + mobile + " " + deviceId + " ]";
        }
    }

    @Override
    public String toString() {
        return "credetials: " + userData;
    }
}
