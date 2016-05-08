package com.callo.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.callo.R;
import com.callo.models.DummyUser;
import com.callo.models.User;
import com.callo.network.NetworkCallback;
import com.callo.network.NetworkRequest;
import com.callo.ui.fragments.RegisterFragment;
import com.callo.ui.fragments.VerifyOtpFragment;
import com.callo.utils.UrlEndpoints;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by abhishesh.s on 5/8/16.
 */
public class SignupActivity extends AppCompatActivity implements RegisterFragment.OnSignUpCompletedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        Fragment fragment = new RegisterFragment();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public void onSignUpCompleted() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,new VerifyOtpFragment()).commit();
    }
}
