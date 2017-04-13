package com.example.ahmed.projectlms.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.ahmed.projectlms.Fragment.OverViewFragment;
import com.example.ahmed.projectlms.Models.Notification_model;
import com.example.ahmed.projectlms.R;

/**
 * Created by ahmed on 4/6/2017.
 */

public class NotificationActivity extends AppCompatActivity {

    private Notification_model notification_model ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

    }


}
