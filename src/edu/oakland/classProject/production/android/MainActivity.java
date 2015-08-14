package edu.oakland.classProject.production.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

import edu.oakland.classProject.production.IDisplay;
import edu.oakland.classProject.production.Main;
import edu.oakland.classProject.production.DisplayHelper;



public class MainActivity extends Activity implements IDisplay {

    // INSTANCE VARIABLE - Create instance of Main class, and that instance will be loaded for the entire game
    Main main;

    private TextView tvGameOver;
    private TextView tvGuessIteration;
    private TextView tvGuess;

    private Button btnHigher;
    private Button btnEquals;
    private Button btnLower;


    private Spinner sprAdvanced;
    private RadioGroup rbsPlayOptions;
    private RadioButton rbBasic;
    private RadioButton rbAdvanced;
    private TextView tvBasic;
    private TextView tvAdvanced;
    private TextView tvMaxNumOfGuesses;
    private Button btnGuess;
    private Button btnNumChosen;

    int MIN_UPPERBOUND_OPTION = 3;
    int MAX_UPPERBOUND_OPTION = 16;
    DisplayHelper displayHelper = new DisplayHelper(MIN_UPPERBOUND_OPTION, MAX_UPPERBOUND_OPTION);
    private int[] upperBoundSelection_int = (int[])displayHelper.generateUpperBoundOptions(1);
    private Integer[] upperBoundSelection  = displayHelper.intArrayToIntegerArray(upperBoundSelection_int);


    private Button currentFeedbackButton;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaystart);

        main = new Main(MainActivity.this);

        rbsPlayOptions = (RadioGroup) findViewById(R.id.rbsPlayOptions);
        rbBasic = (RadioButton) findViewById(R.id.rbBasic);
        rbAdvanced = (RadioButton) findViewById(R.id.rbAdvanced);
        tvBasic = (TextView) findViewById(R.id.tvBasic);
        tvAdvanced = (TextView) findViewById(R.id.tvAdvanced);
		sprAdvanced = (Spinner) findViewById(R.id.sprAdvanced);
        btnGuess = (Button) findViewById(R.id.btnGuess);
        tvMaxNumOfGuesses = (TextView) findViewById(R.id.tvMaxNumOfGuesses);
        btnNumChosen = (Button) findViewById(R.id.btnNumChosen);

		ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, upperBoundSelection);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprAdvanced.setAdapter(dataAdapter);

	}


    public void btnNumberChosen_OnClick(View view){
        main.startGame();

        //Disable other radio button and Spinner
        rbBasic.setEnabled(false);
        rbAdvanced.setEnabled(false);
        sprAdvanced.setEnabled(false);
        btnNumChosen.setEnabled(false);
        btnGuess.setVisibility(View.VISIBLE);
        tvMaxNumOfGuesses.setVisibility(View.VISIBLE);
    }


    public void btnGuess_OnClick(View view){
        setContentView(R.layout.displayguess);

        tvGuessIteration = (TextView) findViewById(R.id.tvGuessIteration);
        tvGuess = (TextView) findViewById(R.id.tvGuess);
        tvGameOver = (TextView) findViewById(R.id.tvGameOver);

        btnHigher = (Button) findViewById(R.id.btnHigher);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnLower = (Button) findViewById(R.id.btnLower);

        btnFeedback_OnClick(view);
    }

    /**Gets whether Basic or Advanced is selected*/
    public char getPlaySelection() {
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
        int upperBoundSelection = sprAdvanced.getSelectedItemPosition() + MIN_UPPERBOUND_OPTION;
        return upperBoundSelection;
    }
    public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses) {
        String strFormat = getResources().getString(R.string.max_num_of_guesses);
        String strMessage = String.format(strFormat, maxNumOfGuesses);

        tvMaxNumOfGuesses.setText(strMessage);

        return;
    }
    public void displayGuessInfo(int currentGuess, int currentGuessIteration){

        String strCurrentGuessFormat = getResources().getString(R.string.current_guess);
        String strCurrentGuessMessage = String.format(strCurrentGuessFormat, currentGuess);

        String strGuessIterationFormat = getResources().getString(R.string.guess_iteration);
        String strGuessIterationMessage = String.format(strGuessIterationFormat, currentGuessIteration);

        tvGuess.setText(strCurrentGuessMessage);
        tvGuessIteration.setText(strGuessIterationMessage);

    }
    public char getGuessFeedback(){
        char guessFeedback = currentFeedbackButton.getTag().toString().charAt(0);
        return guessFeedback;
    }
    public void getEndGameConfirmation(int guess, int guessIteration){
        tvGameOver.setVisibility(View.VISIBLE);
        btnHigher.setVisibility(View.INVISIBLE);
        btnLower.setVisibility(View.INVISIBLE);
        btnEquals.setVisibility(View.INVISIBLE);

        displayGuessInfo(guess, guessIteration);

        return;
    }

    public void rbOption_OnClick(View view){
        if (rbBasic.isChecked()){
            tvBasic.setVisibility(View.VISIBLE);
            tvAdvanced.setVisibility(View.GONE);
            sprAdvanced.setVisibility(View.GONE);
        }
        else{ //if (rbAdvanced.isChecked())
            tvBasic.setVisibility(View.GONE);
            tvAdvanced.setVisibility(View.VISIBLE);
            sprAdvanced.setVisibility(View.VISIBLE);
        }
        btnNumChosen.setEnabled(true);
    }

    public void btnFeedback_OnClick(View view){
        currentFeedbackButton = (Button)view;

        // if this is not the initial guess
        if (currentFeedbackButton.getId() != R.id.btnGuess)
            main.giveFeedback();

        if (!main.makeGuess())
            main.endGame();
    }

}