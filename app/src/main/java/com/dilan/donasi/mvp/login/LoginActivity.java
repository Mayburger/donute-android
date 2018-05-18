package com.dilan.donasi.mvp.login;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.dilan.donasi.R;
import com.dilan.donasi.base.BaseActivity;
import com.dilan.donasi.constants.Fonts;
import com.dilan.donasi.mvp.login.fragments.LoginFragmentA;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addFragmentOnTop(this, new LoginFragmentA(),R.id.frame_login);

    }
}
