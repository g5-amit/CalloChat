package com.callo.ui.fragments;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.callo.R;
import com.callo.models.User;
import com.callo.network.NetworkCallback;
import com.callo.network.NetworkRequest;
import com.callo.utils.UrlEndpoints;
import com.callo.utils.Util;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by abhishesh.s on 5/8/16.
 */
public class RegisterFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

     private EditText mEditName;
     private EditText mEditEmail;
     private EditText mEditPhone;
     private Button mButtonSignup;

    private OnSignUpCompletedListener mCallback;
    public RegisterFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View v = layoutInflater.inflate(R.layout.layout_signup, container,false);
        mEditEmail = (EditText) v.findViewById(R.id.edit_email);
        mEditEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!Util.isValidEmail(mEditEmail.getText().toString())){
                    mEditEmail.setError("wrong email entered");
                }
            }
        });

        mEditPhone = (EditText) v.findViewById(R.id.edit_mobile);
        mEditPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!Util.isValidPhoneNumber(mEditPhone.getText().toString())){
                    mEditPhone.setError("wrong phone entered");
                }
            }
        });
        mEditName = (EditText) v.findViewById(R.id.edit_name);
        mEditName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!Util.isValidName(mEditName.getText().toString())){
                    mEditName.setError("wrong phone entered");
                }
            }
        });
        mButtonSignup = (Button) v.findViewById(R.id.btn_signup);
        mButtonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnSignUpCompletedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }


    public void submit() {

        boolean userDetail = Util.isEditTextEmpty(mEditEmail, mEditPhone, mEditName);
        if(userDetail){
            Toast.makeText(RegisterFragment.this.getActivity(), "enter ALL detail first", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Util.isValidPhoneNumber(mEditPhone.getText().toString())){
            Toast.makeText(RegisterFragment.this.getActivity(), "enter valid phone number first", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Util.isValidName(mEditName.getText().toString())){
            Toast.makeText(RegisterFragment.this.getActivity(), "enter valid name first", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Util.isValidEmail(mEditEmail.getText().toString())){
            Toast.makeText(RegisterFragment.this.getActivity(), "enter valid email first", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User();
        User.UserData userData = new User.UserData();
        userData.setDeviceId("132547698");
        userData.setMobile(mEditPhone.getText().toString());
        userData.setName(mEditName.getText().toString());
        user.setUserData(userData);
        NetworkRequest.INSTANCE.postData(UrlEndpoints.REGISTRATION_URL, user, User.class, new NetworkCallback<User>() {
            @Override
            public void onSuccess(User user) {
                mCallback.onSignUpCompleted();
            }

            @Override
            public void onFail(Exception e) {
            }
        });
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    public interface OnSignUpCompletedListener{
        void onSignUpCompleted();
    }
}
