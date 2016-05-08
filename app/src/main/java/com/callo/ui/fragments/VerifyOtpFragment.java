package com.callo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.callo.R;

/**
 * Created by abhishesh.s on 5/8/16.
 */
public class VerifyOtpFragment extends Fragment implements View.OnClickListener{

    private Button mBtnOtp;
    private EditText mEditOtp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =  inflater.inflate(R.layout.layout_otp,container,false);
        mEditOtp = (EditText) view.findViewById(R.id.edit_otp);
        mBtnOtp = (Button) view.findViewById(R.id.btn_otp);
        mBtnOtp.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        //proceed with verify otp url
    }
}
