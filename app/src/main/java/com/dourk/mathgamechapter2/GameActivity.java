package com.dourk.mathgamechapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    int correctAnswer;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView textObjectScore;
    TextView textObjectLevel;

    int currentScore = 0;
    int currentLevel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        /* Get some working objects based on the button and
        textview classes and link them to the UI elements
        we created */

        textObjectPartA = (TextView) findViewById(R.id.textPartA);
        textObjectPartB = (TextView) findViewById(R.id.textPartB);
        textObjectScore = (TextView) findViewById(R.id.textScore);
        textObjectLevel = (TextView) findViewById(R.id.textLevel);

        buttonObjectChoice1 = (Button) findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button) findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button) findViewById(R.id.buttonChoice3);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

        setQuestion();

    } // end onCreate()

    @Override
    public void onClick(View view) {
        // declare new in to be used in all the cases
        int answerGiven = 0;

        switch (view.getId()) {
            case R.id.buttonChoice1:
                // init a new int with the value contained in buttonObjectChoice1
                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());
                break;

            case R.id.buttonChoice2:
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());
                break;

            case R.id.buttonChoice3:
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());
                break;
        }
        updateScoreAndLevel(answerGiven);
        setQuestion();
    } // end onClick()

    void setQuestion(){
        // generate parts of the question
        int numberRange = currentLevel * 3;
        Random randInt = new Random();

        int partA = randInt.nextInt(numberRange);
        partA++;

        int partB = randInt.nextInt(numberRange);
        partB++;

        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 2;
        int wrongAnswer2 = correctAnswer + 2;

        Log.i("info", "partA = " + partA);
        Log.i("info", "partB = " + partB);
        Log.i("info", "crekt = " + correctAnswer);

        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);

        // set the multi choice buttons
        int buttonLayout = randInt.nextInt(3);
        switch (buttonLayout){
            case 0:
                buttonObjectChoice1.setText("" + correctAnswer);
                buttonObjectChoice2.setText("" + wrongAnswer1);
                buttonObjectChoice3.setText("" + wrongAnswer2);
                break;
            case 1:
                buttonObjectChoice2.setText("" + correctAnswer);
                buttonObjectChoice3.setText("" + wrongAnswer1);
                buttonObjectChoice1.setText("" + wrongAnswer2);
                break;
            case 2:
                buttonObjectChoice3.setText("" + correctAnswer);
                buttonObjectChoice1.setText("" + wrongAnswer1);
                buttonObjectChoice2.setText("" + wrongAnswer2);
                break;
        }
    } // end setQuestion()

    void updateScoreAndLevel(int answerGiven) {
        if (correctTrueOrFalse(answerGiven)) {
            for(int i = 1; i <= currentLevel; i++){
                currentScore = currentScore + i;
            }
            currentLevel++;
        } else {
            currentScore = 0;
            currentLevel = 1;
        }

        // update the textViews
        textObjectScore.setText("Score: " + currentScore);
        textObjectLevel.setText("Level: " + currentLevel);
    }

    boolean correctTrueOrFalse(int answerGiven) {
        boolean isCorrect;
        if (answerGiven == correctAnswer){
            Toast.makeText(getApplicationContext(), "You rock!", Toast.LENGTH_SHORT).show();
            isCorrect = true;
        } else {
            Toast.makeText(getApplicationContext(), "Suck it, loser!", Toast.LENGTH_SHORT).show();
            isCorrect = false;
        }
        return isCorrect;
    }


} // end GameActivity
