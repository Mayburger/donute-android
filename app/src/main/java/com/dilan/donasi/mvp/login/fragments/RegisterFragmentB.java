package com.dilan.donasi.mvp.login.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
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
public class RegisterFragmentB extends BaseFragment<Fragment> {


    // input-root
    @BindView(R.id.et_root)
    LinearLayout etRoot;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        etRoot.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.slide_in_right));
        initTheme();
    }

    // title
    @BindView(R.id.title)
    TextView title;
    // input-title
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.username)
    TextView username;
    // button
    @BindView(R.id.done)
    TextView done;
    // input
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_username)
    EditText etUsername;
    // input-divider
    @BindView(R.id.name_div)
    View nameDiv;
    @BindView(R.id.username_div)
    View usernameDiv;

    void initTheme() {
        // title
        title.setTypeface(getFont(activity, Fonts.MONTSERRATBLACK));
        // input-title
        name.setTypeface(getFont(activity, Fonts.MONTSERRATBLACK));
        username.setTypeface(getFont(activity, Fonts.MONTSERRATBLACK));
        // input
        etName.setTypeface(getFont(activity, Fonts.ROBOLIGHT));
        etUsername.setTypeface(getFont(activity, Fonts.ROBOLIGHT));
        // button
        done.setTypeface(getFont(activity, Fonts.MONTSERRATMEDIUM));

        // input-theme
        initEditText(etName, nameDiv);
        initEditText(etUsername, usernameDiv);
    }



    @Override
    public Fragment newInstance() {
        return new RegisterFragmentB();
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_register_b;
    }

    @OnClick({R.id.back, R.id.done})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.done:
                addFragmentOnTopSlideRight((AppCompatActivity) activity, new LoginFragmentB(), R.id.frame_login);
                handler.postDelayed(() -> getFragmentManager().beginTransaction().remove(RegisterFragmentB.this).commit(), 300);
        }
    }

}
