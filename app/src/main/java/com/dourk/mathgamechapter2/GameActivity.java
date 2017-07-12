package com.dourk.mathgamechapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    int correctAnswer;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Init all the vars
        int partA = 9;
        int partB = 9;
        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;

        /* Get some working objects based on the button and
        textview classes and link them to the UI elements
        we created */

        TextView textObjectPartA = (TextView) findViewById(R.id.textPartA);
        TextView textObjectPartB = (TextView) findViewById(R.id.textPartB);
        buttonObjectChoice1 = (Button) findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button) findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button) findViewById(R.id.buttonChoice3);

        // Now we use the setText method of the class on our objects
        // to show our variable values on the UI elements.
        // Just like when we output to the console in the exercise -
        // Expressions i Java, only now we use setText method
        // to put the values in our vaieables onto the actual UI.

        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);

        // which button is abitrary now...

        buttonObjectChoice1.setText("" + wrongAnswer1);
        buttonObjectChoice2.setText("" + correctAnswer);
        buttonObjectChoice3.setText("" + wrongAnswer2);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // declare new in to be used in all the cases
        int answerGiven = 0;

        switch (view.getId()) {
            case R.id.buttonChoice1:
                // init a new int witht ht evalue contained in buttonObjectChoice1
                // remember we put it there ourselves previously
                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());

                //is it right?
                if(answerGiven==correctAnswer) { // yay we done good!
                    Toast.makeText(getApplicationContext(), "Hell's Yeah!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry loser", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.buttonChoice2:
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());

                if(answerGiven==correctAnswer) { // yay we done good!
                    Toast.makeText(getApplicationContext(), "Hell's Yeah!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry loser", Toast.LENGTH_LONG).show();
                }
                //button2 stuff here
                break;

            case R.id.buttonChoice3:
                // init a new int witht ht evalue contained in buttonObjectChoice1
                // remember we put it there ourselves previously
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());

                //is it right?
                if(answerGiven==correctAnswer) { // yay we done good!
                    Toast.makeText(getApplicationContext(), "Hell's Yeah!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry loser", Toast.LENGTH_LONG).show();
                }
                //button 3 at last
                break;

        }
    }
}
