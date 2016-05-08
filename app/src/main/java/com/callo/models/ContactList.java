package com.callo.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by abhishesh.s on 5/8/16.
 */
public class ContactList implements Serializable {

    @SerializedName("contacts")
    private ArrayList<ContactItem>mContactList;
}
