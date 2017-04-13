package com.example.ahmed.projectlms.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.ahmed.projectlms.Fragment.AnnouncementFragment;
import com.example.ahmed.projectlms.R;

/**
 * Created by Mohab on 4/4/2017.
 */

public class AnnouncementActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        Fragment fragment = new AnnouncementFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.announcement_fragment_container, fragment, fragment.getClass().getSimpleName())
                .commit();
    }
}
