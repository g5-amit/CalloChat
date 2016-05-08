package com.callo.interfaces;

/**
 * Created by abhishesh.s on 5/6/16.
 */
public interface OnContactSelectedListener {

    /**
     * Callback when the contact is selected from the list of contacts
     *
     * @param contactId Long ID of the contact which was selected.
     */
    void onContactNameSelected(long contactId);

    /**
     * Callback when the contact number is selected from the contact details view
     *
     * @param contactNumber String with the number which was selected
     * @param contactName   Name of the contact which was selected as String
     */
    void onContactNumberSelected(String contactNumber, String contactName);
}
