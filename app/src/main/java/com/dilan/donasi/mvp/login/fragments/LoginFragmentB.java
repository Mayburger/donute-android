package com.dilan.donasi.mvp.login.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dilan.donasi.R;
import com.dilan.donasi.base.BaseFragment;
import com.dilan.donasi.constants.Fonts;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LoginFragmentB extends BaseFragment<Fragment> {


    @BindView(R.id.username_div)
    View usernameDiv;
    @BindView(R.id.password_div)
    View passwordDiv;

    @BindView(R.id.root)
    RelativeLayout root;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFont();
        initEditText(etUsername, usernameDiv);
        initEditText(etPassword, passwordDiv);
    }

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.sign_in)
    TextView signIn;
    @BindView(R.id.sign_up)
    TextView signUp;
    @BindView(R.id.no_account)
    TextView noAccount;

    @BindView(R.id.title)
    TextView tvLoginTitle;

    void initFont() {
        etUsername.setTypeface(getFont(activity, Fonts.ROBOLIGHT));
        etPassword.setTypeface(getFont(activity, Fonts.ROBOLIGHT));
        tvLoginTitle.setTypeface(getFont(activity, Fonts.MONTSERRATBLACK));
        signIn.setTypeface(getFont(activity, Fonts.MONTSERRATMEDIUM));
        noAccount.setTypeface(getFont(getActivity(), Fonts.MONTSERRATLIGHT));
        signUp.setTypeface(getFont(getActivity(), Fonts.MONTSERRATBOLD));
    }

    @Override
    public Fragment newInstance() {
        return new LoginFragmentB();
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_login_b;
    }

    @OnClick({R.id.back, R.id.sign_up,R.id.sign_in})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.sign_up:
                addFragmentOnTopSlideUp((AppCompatActivity) activity, new RegisterFragmentA(), R.id.frame_login);
                handler.postDelayed(() -> getFragmentManager().beginTransaction().remove(LoginFragmentB.this).commit(),300);
                break;
            case R.id.sign_in:
                Toast.makeText(activity, "sign", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
