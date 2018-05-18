package com.dilan.donasi.mvp.login.fragments;


import android.annotation.SuppressLint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dilan.donasi.R;
import com.dilan.donasi.base.BaseFragment;
import com.dilan.donasi.constants.Fonts;
import com.dilan.donasi.constants.Keys;

import butterknife.BindView;
import butterknife.OnClick;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class RegisterFragmentA extends BaseFragment<Fragment> {


    // input-root
    @BindView(R.id.et_root)
    LinearLayout etRoot;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initTheme();
    }

    // title
    @BindView(R.id.title)
    TextView title;
    // input-title
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.password)
    TextView password;
    @BindView(R.id.con_password)
    TextView conPassword;
    // button
    @BindView(R.id.next)
    TextView next;
    // input
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_con_password)
    EditText etConPassword;
    // input-divider
    @BindView(R.id.email_div)
    View emailDiv;
    @BindView(R.id.password_div)
    View passwordDiv;
    @BindView(R.id.con_password_div)
    View conPasswordDiv;
    // footer-text
    @BindView(R.id.sign_in)
    TextView signIn;
    @BindView(R.id.account)
    TextView account;

    void initTheme() {
        // title
        title.setTypeface(getFont(activity, Fonts.MONTSERRATBLACK));
        // input-title
        email.setTypeface(getFont(activity, Fonts.MONTSERRATBLACK));
        password.setTypeface(getFont(activity, Fonts.MONTSERRATBLACK));
        conPassword.setTypeface(getFont(activity, Fonts.MONTSERRATBLACK));
        // input
        etEmail.setTypeface(getFont(activity, Fonts.ROBOLIGHT));
        etPassword.setTypeface(getFont(activity, Fonts.ROBOLIGHT));
        etConPassword.setTypeface(getFont(activity, Fonts.ROBOLIGHT));
        // button
        next.setTypeface(getFont(activity, Fonts.MONTSERRATMEDIUM));
        // footer-text
        account.setTypeface(getFont(getActivity(), Fonts.MONTSERRATLIGHT));
        signIn.setTypeface(getFont(getActivity(), Fonts.MONTSERRATBOLD));

        // input-theme
        initEditText(etEmail, emailDiv);
        initEditText(etPassword, passwordDiv);
        initEditText(etConPassword, conPasswordDiv);
    }

    @Override
    public Fragment newInstance() {
        return new RegisterFragmentA();
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_register_a;
    }

    @OnClick({R.id.back, R.id.sign_in, R.id.next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.sign_in:
                addFragmentOnTopSlideUp((AppCompatActivity) activity, new LoginFragmentB(), R.id.frame_login);
                handler.postDelayed(() -> getFragmentManager().beginTransaction().remove(RegisterFragmentA.this).commit(), 300);
                break;
            case R.id.next:
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                View v = inflater.inflate(R.layout.error_window, null);
                errorPop = new PopupWindow(
                        v,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                errorPop.setBackgroundDrawable(new BitmapDrawable());
                errorPop.setOutsideTouchable(true);

                if (etEmail.getText().toString().equals("")) {
                    errorPop.showAsDropDown(etEmail);
                    errorText(v,R.string.not_empty);
                } else if (etPassword.getText().toString().equals("")) {
                    errorPop.showAsDropDown(etPassword);
                    errorText(v,R.string.not_empty);
                } else if (etConPassword.getText().toString().equals("")) {
                    errorPop.showAsDropDown(etConPassword);
                    errorText(v,R.string.not_empty);
                } else if (!etPassword.getText().toString().equals(etConPassword.getText().toString())) {
                    errorPop.showAsDropDown(etConPassword);
                    errorText(v,R.string.password_not_match);
                } else {
                    if (isEmailValid(etEmail.getText().toString())) {
//                        Bundle bundle = new Bundle();
//                        bundle.putString(Keys.EMAIL, etEmail.getText().toString());
//                        bundle.putString(Keys.PASSWORD, etConPassword.getText().toString());
//                        RegisterFragmentB registerFragmentB = new RegisterFragmentB();
//                        addFragmentOnTop((AppCompatActivity) activity, new RegisterFragmentB(), R.id.frame_login);
                        errorPop.showAsDropDown(etEmail);
                        errorText(v,R.string.email_not_valid);
                        errorPop.dismiss();
                    } else {
                        errorPop.showAsDropDown(etEmail);
                        errorText(v,R.string.email_not_valid);
                    }
                }
                break;
        }
    }

    void errorText(View v, int string) {
        TextView error = v.findViewById(R.id.error);
        error.setTypeface(getFont(activity, Fonts.ROBOLIGHT));
        error.setText(getString(string));
    }

}
