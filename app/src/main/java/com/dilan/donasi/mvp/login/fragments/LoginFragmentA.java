package com.dilan.donasi.mvp.login.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dilan.donasi.R;
import com.dilan.donasi.base.BaseFragment;
import com.dilan.donasi.constants.Fonts;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LoginFragmentA extends BaseFragment<Fragment> {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFont();
    }

    @BindView(R.id.motto)
    TextView motto;
    @BindView(R.id.sign_in)
    TextView signIn;
    @BindView(R.id.no_account)
    TextView noAccount;
    @BindView(R.id.sign_up)
    TextView signUp;

    void initFont() {
        motto.setTypeface(getFont(getActivity(), Fonts.MONTSERRATLIGHT));
        signIn.setTypeface(getFont(getActivity(), Fonts.MONTSERRATMEDIUM));
        noAccount.setTypeface(getFont(getActivity(), Fonts.MONTSERRATLIGHT));
        signUp.setTypeface(getFont(getActivity(), Fonts.MONTSERRATBOLD));
    }

    @Override
    public Fragment newInstance() {
        return new LoginFragmentA();
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_login_a;
    }

    @OnClick({R.id.sign_in, R.id.sign_up})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in:
                getActivity().overridePendingTransition(R.anim.slide_in_up, R.anim.stay);
                addFragmentOnTopSlideUp((AppCompatActivity) getActivity(), new LoginFragmentB(), R.id.frame_login);
                break;
            case R.id.sign_up:
                addFragmentOnTopSlideUp((AppCompatActivity) activity, new RegisterFragmentA(), R.id.frame_login);
                break;
        }
    }
}
