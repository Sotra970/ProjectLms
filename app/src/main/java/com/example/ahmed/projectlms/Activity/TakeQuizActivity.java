package com.example.ahmed.projectlms.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.FrameLayout;

import com.example.ahmed.projectlms.Fragment.TakeQuizMcqFragment;
import com.example.ahmed.projectlms.Fragment.TakeQuizTrueFalseFragment;
import com.example.ahmed.projectlms.R;

/**
 * Created by Mohab on 4/6/2017.
 */

public class TakeQuizActivity extends AppCompatActivity
{
    CardView cardViewNextQuestion;
    private int quizType;
    FrameLayout frameTakeQuizMcq, frameTakeQuizTrueFalse;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);

        cardViewNextQuestion = (CardView) findViewById(R.id.cardview_next_question);
        frameTakeQuizMcq = (FrameLayout) findViewById(R.id.frame_take_quiz_mcq);
        frameTakeQuizTrueFalse = (FrameLayout) findViewById(R.id.frame_take_quiz_true_false);
        quizType = 0;

        if(quizType == 1)
        {
            Fragment fragment = new TakeQuizMcqFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.take_quiz_fragment_container, fragment, fragment.getClass().getSimpleName())
                    .commit();
        }
        else
        {

            Fragment fragment = new TakeQuizTrueFalseFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.take_quiz_fragment_container, fragment, fragment.getClass().getSimpleName())
                    .commit();
        }


    }
}
