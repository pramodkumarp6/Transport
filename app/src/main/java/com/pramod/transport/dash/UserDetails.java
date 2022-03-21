package com.pramod.transport.dash;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.pramod.transport.LoginActivity;
import com.pramod.transport.R;
import com.pramod.transport.databinding.ActivityUserDetailsBinding;
import com.pramod.transport.model.signin.User;
import com.pramod.transport.sharedPreference.SharedPrefManager;

public class UserDetails extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityUserDetailsBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarUserDetails.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;






        mAppBarConfiguration = new AppBarConfiguration.Builder(
               R.id.nav_home,
                R.id.nav_tansportsystem,
                R.id.nav_account,
                R.id.nav_Password,
                R.id.nav_location,
                R.id.nav_userDetail
                )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_details);
        //TextView tv = (TextView)navigationView.findViewById(R.id.textViewsubtitle);
       // tv.setText("Tatatat");

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        NavigationUI.setupWithNavController(navigationView, navController);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.user_details, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {

            case R.id.action_settings:
                Intent i = new Intent(this,ProfileActivity.class);
                startActivity(i);
                break;

            case R.id.action_logout:
                SharedPrefManager.getInstance(getApplicationContext()).logout();
                finish();
                Intent intent = new Intent(new Intent(this, LoginActivity.class));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_user_details);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)

                || super.onSupportNavigateUp();
    }
}