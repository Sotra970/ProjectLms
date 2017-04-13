package com.example.ahmed.projectlms.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ahmed.projectlms.Adapter.Title_Pager_Adapter;
import com.example.ahmed.projectlms.Fragment.MessageFragment;
import com.example.ahmed.projectlms.R;
import com.example.ahmed.projectlms.app.AppController;


public class MessActivity extends AppCompatActivity {
    ViewPager viewPager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess);
        View main_container = findViewById(R.id.viewPager_mess);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            FabTransform.setup(this, main_container);}
        toolbar_action_setup();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
         viewPager = (ViewPager) findViewById(R.id.viewPager_mess);
        View power = findViewById(R.id.logout);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppController.getInstance().getPrefManager().clear();
            }
        });
        viewPager.post(new Runnable() {
            @Override
            public void run() {
                viewPager.setTranslationY(1200);
                viewPager.animate()
                        .translationY(0f)
                        .setDuration(600)
                        .setInterpolator(new FastOutSlowInInterpolator());
            }
        });


        Title_Pager_Adapter viewPagerAdapter = new Title_Pager_Adapter(getSupportFragmentManager());

         MessageFragment inbox  = new MessageFragment();
        inbox.setType("inbox");

         MessageFragment outbox  = new MessageFragment();
        outbox.setType("outbox");

        viewPagerAdapter.addFragment(inbox,getString(R.string.inbox));
        viewPagerAdapter.addFragment(outbox,getString(R.string.outbox));

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }



    void toolbar_action_setup(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        View power = findViewById(R.id.logout);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppController.getInstance().getPrefManager().clear();
            }
        });

        final View notificationbtn = findViewById(R.id.main_toolbar_search);
        final View menu_action = findViewById(R.id.logout);
        TextView page_title = (TextView) findViewById(R.id.main_toolbar_title);
        page_title.setText(R.string.home);
        notificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notificationbtn == view) {
                    Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
                    startActivity(intent);
                }
            }
        });
        menu_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(menu_action == view) {
                    startActivity(new Intent(getApplicationContext(), MessActivity.class));


                }
            }
        });

    }



}
