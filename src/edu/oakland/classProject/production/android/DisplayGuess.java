package edu.oakland.classProject.production.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import edu.oakland.classProject.production.IDisplayGuess;

public class DisplayGuess extends Activity implements IDisplayGuess {


    public void displayGuessInfo(int currentGuess, int currentGuessIteration){
        //lblCurrentGuess.Text = Integer.toString(currentGuess);
        //lblCurrentGuessIteration = Integer.toString(currentGuessIteration);
    }
    public char getGuessFeedback(){
        char guessFeedback = 'a';

        //guessFeedback = btnFeedback_clicked.text; // +, -, or =

        return guessFeedback;
    }
    public void getEndGameConfirmation(int guess, int guessIteration){
        //lblGameEnded.Visible = true;

        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayguess);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guess_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
