package edu.oakland.classProject.helper;

/**
*This class deals with the array containing the upperbound and number of guesses. 
*Takes oldArray and generates upperBoundOptions based on passed dimensions.
*@author JavaAppTeam
*@version version2.0
*@since version1.0
*/
public class DisplayHelper {
	
    int MIN_UPPERBOUND_OPTION = 1;
    int MAX_UPPERBOUND_OPTION = 16;

	/**
	* overloaded constructor that passes an over-riding value into MIN_UPPERBOUND_OPTION and MAX_UPPERBOUND_OPTION
	*/
    public DisplayHelper(int _MIN_UPPERBOUND_OPTION, int _MAX_UPPERBOUND_OPTION){
        MIN_UPPERBOUND_OPTION = _MIN_UPPERBOUND_OPTION;
        MAX_UPPERBOUND_OPTION = _MAX_UPPERBOUND_OPTION;
    }
	
	/**
	* Empty method.
	*/
    public DisplayHelper(){
    }

	/**
	* Method to set the MIN_UPPERBOUND_OPTION
	*/
    public void setMIN_UPPERBOUND_OPTION(int _MIN_UPPERBOUND_OPTION){
        MIN_UPPERBOUND_OPTION = _MIN_UPPERBOUND_OPTION;
    }

	/**
	* Method to set the MAX_UPPERBOUND_OPTION
	*/
    public void setMAX_UPPERBOUND_OPTION(int _MAX_UPPERBOUND_OPTION){
        MAX_UPPERBOUND_OPTION = _MAX_UPPERBOUND_OPTION;
    }

	/**
	* Method will generated the upperBound options from the dimensions passed to the method.
	* Will return either int[] or int[][], based on dimensions input.
	@return upperBoundOptions_1D or upperBoundOptions_2D
	*/
    public Object generateUpperBoundOptions(int dimensions){
        int numOfSelections = MAX_UPPERBOUND_OPTION-MIN_UPPERBOUND_OPTION;

        int[]   upperBoundOptions_1D = new int[numOfSelections+1];
        int[][] upperBoundOptions_2D = new int[numOfSelections+1][2];

        for (int i = 0; i <= numOfSelections; i++){
            int maxNumOfGuesses = i + MIN_UPPERBOUND_OPTION;
            int upperBound = (int)Math.pow(2, maxNumOfGuesses) - 1;

            //1D
            upperBoundOptions_1D[i] = upperBound;

            //2D
            upperBoundOptions_2D[i][0] = maxNumOfGuesses;
            upperBoundOptions_2D[i][1] = upperBound;

        }
        if (dimensions == 1)
            return upperBoundOptions_1D;
        else /// if (dimensions == 2)
            return upperBoundOptions_2D;
    }

	/**
	* Method will take a passed in array, create a newArray and update the values based on the oldArray
	@return newArray built from oldArray
	*/
    public static Integer[] intArrayToIntegerArray(int[] oldArray){

        Integer[] newArray = new Integer[oldArray.length];
        int i = 0;
        for (int value : oldArray) {
            newArray[i++] = Integer.valueOf(value);
        }

        return newArray;
    }

}
