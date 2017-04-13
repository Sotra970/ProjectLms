package com.example.ahmed.projectlms.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.ahmed.projectlms.Fragment.AssignmentFragment;
import com.example.ahmed.projectlms.R;

/**
 * Created by Mohab on 4/7/2017.
 */

public class AssignmentActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        Fragment fragment = new AssignmentFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.assignment_fragment_container, fragment, fragment.getClass().getSimpleName())
                .commit();
    }
}
