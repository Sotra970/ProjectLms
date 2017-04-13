package com.example.ahmed.projectlms.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ahmed.projectlms.Fragment.ProgressFragment;
import com.example.ahmed.projectlms.R;

/**
 * Created by Mohab on 4/7/2017.
 */

public class ProgressActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        ProgressFragment fragment = new ProgressFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.progress_fragment_container, fragment)
                .commit();

    }
}
