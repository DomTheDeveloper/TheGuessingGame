package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import edu.oakland.classProject.production.*;
import android.widget.TextView;
import android.app.AlertDialog;

public class MainActivity extends Activity
{
    private Main main;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	main = new Main();
    }

    public void guessedNumber(View view) {
        setContentView(R.layout.game);
        int maxNumberOfGuesses = main.startGame(1024);
       	TextView t = (TextView) findViewById(R.id.guess);
        t.setText(Integer.toString(1024/2));
    }

    public void goToMain(View view) {
	View up = (View) findViewById(R.id.up);
	up.setVisibility(View.GONE);
	View down = (View) findViewById(R.id.down);
	down.setVisibility(View.GONE);
	View yes = (View) findViewById(R.id.yes);
	yes.setVisibility(View.GONE);

        Runnable myRunnable = new Runnable()
        {
            @Override
            public void run()
            {
                setContentView(R.layout.main);
            }
        };
        Handler myHandler = new Handler();
        myHandler.postDelayed(myRunnable, 2000);
    }

    public void guess(View view) {
        String feedback = (String) view.getTag();
	int number = main.makeGuess(feedback);
	TextView guessView = (TextView) findViewById(R.id.guess);
        guessView.setText(Integer.toString(number));
	TextView iterationView = (TextView) findViewById(R.id.iteration);
	iterationView.setText("Iteration "+Integer.toString(main.getIteration()));
	if(main.isFinished()){
		goToMain(view);
	}
    }
}
