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
import android.widget.Toast;

import edu.oakland.classProject.production.IDisplayStart;
import edu.oakland.classProject.production.Main;


public class DisplayStart extends Activity implements IDisplayStart {


    // INSTANCE VARIABLE - Create instance of Main class, and that instance will be loaded for the entire game
    Main main;

    private Spinner sprAdvanced;
    private RadioGroup rbsPlayOptions;
    private RadioButton rbBasic;
    private RadioButton rbAdvanced;
    private TextView tvBasic;
    private TextView tvAdvanced;
    private TextView tvMaxNumOfGuesses;
    private Button btnGuess;
    private Button btnNumChosen;
    private Integer[] upperBoundSelection = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaystart);

        main = new Main();
        main.setDisplayStart(DisplayStart.this);

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
        //advSpinner.getSelectedItem();

		// Li
		addVisibilityChangeOnBasicRadioButtonSelection();
        addVisibilityChangeOnAdvancedRadioButtonSelection();
        addChosenNumberButtonListener();
	}


    public void addChosenNumberButtonListener() {
        btnNumChosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.startGame();

                //Disable other radio button and Spinner
                rbBasic.setEnabled(false);
                rbAdvanced.setEnabled(false);
                sprAdvanced.setEnabled(false);
                btnNumChosen.setEnabled(false);
                btnGuess.setVisibility(View.VISIBLE);
                tvMaxNumOfGuesses.setVisibility(View.VISIBLE);
            }
        });
    }
    //    Intent intent1 = new Intent(this, secondActivity.class);
    //    startIntent(intent1);

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
        int upperBoundSelection;

        upperBoundSelection = sprAdvanced.getSelectedItemPosition() + 1;

        return upperBoundSelection;
    }
    public void getUserConfirmation(int upperBoundComputed, int maxNumOfGuesses){
        String strFormat = getResources().getString(R.string.max_num_of_guesses);
        String strMessage = String.format(strFormat, maxNumOfGuesses);

        tvMaxNumOfGuesses.setText(strMessage);

        return;
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
                if (isChecked) {
                    tvAdvanced.setVisibility(View.VISIBLE);
                    sprAdvanced.setVisibility(View.VISIBLE);
                } else {
                    tvAdvanced.setVisibility(View.GONE);
                    sprAdvanced.setVisibility(View.GONE);
                }
            }
        });
    }


}