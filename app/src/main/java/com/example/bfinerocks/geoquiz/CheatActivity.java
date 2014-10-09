
package com.example.bfinerocks.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class CheatActivity extends ActionBarActivity {

    private Button mShowAnswer;
    private TextView mAnswerText;

    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.bfinerocks.geoquiz.answer_is_true";
    public static final String CHEATED = "com.example.bfinerocks.geoquiz.cheated";
    public static final String KEEP_KEY = "cheaters";
    private boolean mCheated;
    private boolean mAnswerIsTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerText = (TextView) findViewById(R.id.answerTextView);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mCheated = false;
        setAnswerShowResult(mCheated);

        mShowAnswer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswerIsTrue)
                {
                    mAnswerText.setText(R.string.true_button);
                }
                else{
                    mAnswerText.setText(R.string.false_button);
                }
                mCheated = true;
                setAnswerShowResult(mCheated);
            }
        });



    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEEP_KEY, mCheated);

    }

    private void setAnswerShowResult(boolean mCheated)
    {
        Intent sendBack = new Intent();
        sendBack.putExtra(CHEATED, mCheated);
        setResult(RESULT_OK, sendBack);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
