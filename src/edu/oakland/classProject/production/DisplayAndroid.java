/*
package edu.oakland.classProject.production;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.MainActivity;
import com.example.myfirstapp.R;


public class DisplayAndroid extends Activity implements IDisplay{


	public char getPlaySelection(){
		btnGuess.setVisibility(View.VISIBLE);

		//Disable other radio button and Spinner
		rbBasic.setEnabled(false);
		rbAdvanced.setEnabled(false);
		advSpinner.setEnabled(false);

		//Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();

		int rbId = rbsPlayOptions.getCheckedRadioButtonId();
		RadioButton rb = (RadioButton) findViewById(rbId);
		String result = rb.getText().toString();
		if (result.equals("Basic")) {
			return 'S';
		} else {
			return 'A';
		}
	}
	public int getUpperBoundSelection(){
		int upperBoundSelection = 0;

		//upperBoundSelection = ddlUpperBound.selectedValue; /// 512, 1024, ...

		return upperBoundSelection;
	}
	public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses){
		//lblMaxNumOfGuesses.Text = String.format("The system will guess your number in %d guesses.", maxNumOfGuesses); /// 10, 11, ...

		return;
	}
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
}
*/