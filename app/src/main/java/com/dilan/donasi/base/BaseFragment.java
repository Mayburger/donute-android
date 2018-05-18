package com.dilan.donasi.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.dilan.donasi.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;

/**
 * Created by Mayburger on 10/01/18.
 */

public abstract class BaseFragment<F extends Fragment> extends Fragment {

    public Activity activity;
    public Handler handler;
    public FirebaseAuth auth;
    public PopupWindow errorPop;
    public View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getFragmentLayout(), container, false);
        ButterKnife.bind(this, rootView);
        activity = getActivity();
        handler = new Handler();
        return rootView;
    }

    public Typeface getFont(Context context, String fontName) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName + ".ttf");
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void initEditText(EditText edit, View div) {
        edit.setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                div.setBackgroundColor(getActivity().getResources().getColor(R.color.colorAccent));
            } else {
                div.setBackgroundColor(getActivity().getResources().getColor(R.color.colorWhiteAlpha));
            }
        });
    }

    public static void addFragmentOnTopSlideUp(AppCompatActivity activity, Fragment fragment, int layout) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in_up, R.anim.stay, R.anim.stay, R.anim.slide_out_down)
                .add(layout, fragment)
                .addToBackStack(null)
                .commit();
    }

    public static void addFragmentOnTopSlideRight(AppCompatActivity activity, Fragment fragment, int layout) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.stay, R.anim.stay, R.anim.slide_out_left)
                .add(layout, fragment)
                .addToBackStack(null)
                .commit();
    }

    public static void addFragmentOnTop(AppCompatActivity activity, Fragment fragment, int layout) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .add(layout, fragment)
                .addToBackStack(null)
                .commit();
    }

    public abstract F newInstance();

    public abstract
    @LayoutRes
    int getFragmentLayout();

}
