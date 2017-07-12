package com.dourk.mathgamechapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Init all the vars
        int partA = 9;
        int partB = 9;
        int correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;

        /* Get some working objects based on the button and
        textview classes and link them to the UI elements
        we created */

        TextView textObjectPartA = (TextView) findViewById(R.id.textPartA);
        TextView textObjectPartB = (TextView) findViewById(R.id.textPartB);
        Button buttonObjectChoice1 = (Button) findViewById(R.id.buttonChoice1);
        Button buttonObjectChoice2 = (Button) findViewById(R.id.buttonChoice2);
        Button buttonObjectChoice3 = (Button) findViewById(R.id.buttonChoice3);

        // Now we use the setText method of the class on our objects
        // to show our variable values on the UI elements.
        // Just like when we output to the console in the exercise -
        // Expressions i Java, only now we use setText method
        // to put the values in our vaieables onto the actual UI.

        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);

        // which button is abitrary now...

        buttonObjectChoice1.setText("" + correctAnswer);
        buttonObjectChoice2.setText("" + wrongAnswer1);
        buttonObjectChoice3.setText("" + wrongAnswer2);

    }
}
