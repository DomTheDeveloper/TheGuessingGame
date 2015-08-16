package edu.oakland.classProject.production;

public class DisplayHelper {

    int MIN_UPPERBOUND_OPTION = 1;
    int MAX_UPPERBOUND_OPTION = 16;

    public DisplayHelper(int _MIN_UPPERBOUND_OPTION, int _MAX_UPPERBOUND_OPTION){
        MIN_UPPERBOUND_OPTION = _MIN_UPPERBOUND_OPTION;
        MAX_UPPERBOUND_OPTION = _MAX_UPPERBOUND_OPTION;
    }

    public DisplayHelper(){
    }

    public void setMIN_UPPERBOUND_OPTION(int _MIN_UPPERBOUND_OPTION){
        MIN_UPPERBOUND_OPTION = _MIN_UPPERBOUND_OPTION;
    }

    public void setMAX_UPPERBOUND_OPTION(int _MAX_UPPERBOUND_OPTION){
        MAX_UPPERBOUND_OPTION = _MAX_UPPERBOUND_OPTION;
    }

    /* will return either int[] or int[][], based on dimensions input */
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

    public static Integer[] intArrayToIntegerArray(int[] oldArray){

        Integer[] newArray = new Integer[oldArray.length];
        int i = 0;
        for (int value : oldArray) {
            newArray[i++] = Integer.valueOf(value);
        }

        return newArray;
    }

}
