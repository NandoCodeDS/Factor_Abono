package com.pm.factor_abono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.pm.factor_abono.databinding.ActivityAboutBinding;

public class AboutActivity extends DrawerBaseActivity {
    ActivityAboutBinding activityAboutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAboutBinding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_about);
        allocateActivityTittle("About");
    }
}