package edu.oakland.classProject.production.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;

import edu.oakland.classProject.production.IDisplay;
import edu.oakland.classProject.production.Main;
import edu.oakland.classProject.helper.DisplayHelper;


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
    private Integer[] upperBoundSelection  = DisplayHelper.intArrayToIntegerArray(upperBoundSelection_int);

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

    /**
     * Disables radio buttons and dropdown menu,
     * displays textview saying how many guesses the system gets, and
     * displays the button to start the game
     * @param view Takes the button that is pressed of type View*/
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

    /**
     * Displays the Game Screen, calls  btnFeedback_OnClick method
     * @param view Takes the button that is pressed of type View
     * */
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

    /**
     * Gets whether Basic or Advanced is selected
     * @return Returns a variable of type char that resembles the user's game type selected
     * */
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

    /**
     * Gets the upper bound that's selected
     * @return The upper bound selected of type int
     *  */
    public int getUpperBoundSelection(){
        return sprAdvanced.getSelectedItemPosition() + MIN_UPPERBOUND_OPTION;
    }

    /**
     *  Displays how many guesses the system has to guess the user's number
     *  @param upperBoundComputed The upper bound selected
     *  @param maxNumOfGuesses The number of guesses the system has, given the upper bound
     *  */
    public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses) {
        String strFormat = getResources().getString(R.string.max_num_of_guesses);
        String strMessage = String.format(strFormat, maxNumOfGuesses);

        tvMaxNumOfGuesses.setText(strMessage);
    }
    public void displayGuessInfo(int currentGuess, int currentGuessIteration){

        String strCurrentGuessFormat = getResources().getString(R.string.current_guess);
        String strCurrentGuessMessage = String.format(strCurrentGuessFormat, currentGuess);

        String strGuessIterationFormat = getResources().getString(R.string.guess_iteration);
        String strGuessIterationMessage = String.format(strGuessIterationFormat, currentGuessIteration);

        tvGuess.setText(strCurrentGuessMessage);
        tvGuessIteration.setText(strGuessIterationMessage);

    }
    public String getGuessFeedback(){
        return currentFeedbackButton.getTag().toString();
    }
    public void getEndGameConfirmation(int guess, int guessIteration){
        // tvGameOver.setVisibility(View.VISIBLE);
        String strCurrentGuessFormat = getResources().getString(R.string.final_guess);
        String strCurrentGuessMessage = String.format(strCurrentGuessFormat, guess);

        String strGuessIterationFormat = getResources().getString(R.string.guess_iteration);
        String strGuessIterationMessage = String.format(strGuessIterationFormat, guessIteration);

        tvGuess.setText(strCurrentGuessMessage);
        tvGuessIteration.setText(strGuessIterationMessage);

        btnHigher.setVisibility(View.GONE);
        btnLower.setVisibility(View.GONE);
        btnEquals.setVisibility(View.GONE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        }, 2500);


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