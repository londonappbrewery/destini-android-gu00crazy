package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
     private  Button mTopButton;
     private Button mBottomButton;
     private TextView mStoryTextView;
     private int mIndexN1 = 0;
     private int mIndex = 0;
     private int mFinish = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        mStoryTextView = findViewById(R.id.storyTextView);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             if(mFinish==1){
                 finish();
             }


             else if(mIndex==1){
                 mStoryTextView.setText(R.string.T6_End);
                 mTopButton.setText(R.string.T1_CLOSE);
                 mBottomButton.setVisibility(View.INVISIBLE);
                 finishStory();

             }else{
                 mStoryTextView.setText(R.string.T3_Story);
                 mBottomButton.setText(R.string.T3_Ans2);
                 mTopButton.setText(R.string.T3_Ans1);
             }

             upgradeQuestion();

            }
        });





        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mFinish==1){
                    finish();
                }

             else if(mIndex== 1) {

                 mStoryTextView.setText(R.string.T5_End);
                    mTopButton.setVisibility(View.INVISIBLE);
                    mBottomButton.setText(R.string.T1_CLOSE);
                 finishStory();

             }else if(mIndexN1 ==1) {

             mStoryTextView.setText(R.string.T4_End);
                    mTopButton.setVisibility(View.INVISIBLE);
                    mBottomButton.setText(R.string.T1_CLOSE);
                    finishStory();


             }else if(mIndexN1==0){

              mStoryTextView.setText(R.string.T2_Story);
              mTopButton.setText(R.string.T2_Ans1);
              mBottomButton.setText(R.string.T2_Ans2);

             }


             upgradeQuestionN1();
            }
        });


    }

    public void upgradeQuestion(){

        mIndex++;
    }

    public void upgradeQuestionN1(){
        mIndexN1++;
    }

    public void finishStory(){
        mFinish++;
    }
}
