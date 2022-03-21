package com.pramod.transport.sharedPreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.pramod.transport.LoginActivity;
import com.pramod.transport.model.signin.User;
import com.pramod.transport.model.signin.Users;

public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private  Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_SCHOOL = "school";


    public SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }



    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }


    public void saveUser(Users user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_ID, user.getId());
              int i = user.getId();
        Log.e(String.valueOf(i),"Shared");
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_NAME, user.getName());


        Log.e(user.getEmail(),"Sharedemail");
        editor.putString(KEY_SCHOOL, user.getSchool());
        Log.e(user.getSchool(),"SharedSchool");

        editor.apply();
        editor.commit();
    }




    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
    }


    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_NAME, null),
                sharedPreferences.getString(KEY_SCHOOL, null)

        );
    }


    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
       // mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
    }


}
