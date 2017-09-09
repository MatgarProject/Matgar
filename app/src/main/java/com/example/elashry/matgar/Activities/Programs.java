package com.example.elashry.matgar.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.elashry.matgar.Adapters.ViewPagerAdapter;
import com.example.elashry.matgar.Fragments.Mobile;
import com.example.elashry.matgar.Fragments.Web;
import com.example.elashry.matgar.Fragments.Webapp;
import com.example.elashry.matgar.R;


public class Programs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Programs.this, Login.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
