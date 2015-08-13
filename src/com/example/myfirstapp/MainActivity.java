package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
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

import edu.oakland.classProject.production.IDisplay;
import edu.oakland.classProject.production.Main;


public class MainActivity extends Activity implements IDisplay {

    Main main;

    private Spinner advSpinner;
    private RadioGroup rbsPlayOptions;
    private RadioButton rbBasic;
    private RadioButton rbAdvanced;
    private TextView tvBasic;
    private TextView tvAdvanced;
    private Button btnGuess;
    private Button btnNumChosen;
    private Integer[] upperBoundSelection = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};

    // INSTANCE VARIABLE - Create instance of Main class, and that instance will be loaded for the entire game

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        main = new Main(MainActivity.this);

        rbsPlayOptions = (RadioGroup) findViewById(R.id.rbsPlayOptions);
        rbBasic = (RadioButton) findViewById(R.id.rbBasic);
        rbAdvanced = (RadioButton) findViewById(R.id.rbAdvanced);
        tvBasic = (TextView) findViewById(R.id.tvBasic);
        tvAdvanced = (TextView) findViewById(R.id.tvAdvanced);
		advSpinner = (Spinner) findViewById(R.id.advSpinner);
        btnGuess = (Button) findViewById(R.id.btnGuess);
        btnNumChosen = (Button) findViewById(R.id.btnNumChosen);

		ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, upperBoundSelection);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		advSpinner.setAdapter(dataAdapter);
        //advSpinner.getSelectedItem();

		// Li
		addVisibilityChangeOnBasicRadioButtonSelection();
        addVisibilityChangeOnAdvancedRadioButtonSelection();

        addListenerOnSpinnerItemSelection();
		addListenerOnButton();

        addChosenNumberButtonListener();


	}

	// Add spinner data

	public void addListenerOnSpinnerItemSelection(){
				advSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}

//    Intent intent1 = new Intent(this, secondActivity.class);
//    startIntent(intent1);

    public void addChosenNumberButtonListener() {
        btnNumChosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.startGame();
            }
        });
    }

	//get the selected dropdown list value
	public void addListenerOnButton() {

		//advSpinner = (Spinner) findViewById(R.id.advSpinner);

        //Button guessButton;
        btnGuess = (Button) findViewById(R.id.btnGuess);

        btnGuess.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,
                        "On Button Click : " +
                                "\n" + String.valueOf(advSpinner.getSelectedItem()),
                        Toast.LENGTH_LONG).show();
            }

        });

	}



    /**Shows the instructions for Basic gameplay, when the "Basic" radio button is selected */
    public void addVisibilityChangeOnBasicRadioButtonSelection() {
        rbBasic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvBasic.setVisibility(View.VISIBLE);
                } else {
                    tvBasic.setVisibility(View.GONE);
                }
            }
        });
    }

    /**Shows the instructions for Advanced gameplay plus the spinner (dropdown menu)
     *  when the "Advanced" radio button is selected */
    public void addVisibilityChangeOnAdvancedRadioButtonSelection() {
        rbAdvanced.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tvAdvanced.setVisibility(View.VISIBLE);
                    advSpinner.setVisibility(View.VISIBLE);
                } else {
                    tvAdvanced.setVisibility(View.GONE);
                    advSpinner.setVisibility(View.GONE);
                }
            }
        });
    }
    /**Gets whether Basic or Advanced is selected*/
    public char getPlaySelection() {

        //Disable other radio button and Spinner
        rbBasic.setEnabled(false);
        rbAdvanced.setEnabled(false);
        advSpinner.setEnabled(false);

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
        String userConfirmation = String.format("The system will guess your number in %d guesses.", maxNumOfGuesses);

        //lblMaxNumOfGuesses.Text = userConfirmation; /// 10, 11, ...

        Toast.makeText(getApplicationContext(),userConfirmation, Toast.LENGTH_SHORT).show();

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