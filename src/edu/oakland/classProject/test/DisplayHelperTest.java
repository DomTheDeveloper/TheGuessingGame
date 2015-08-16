package edu.oakland.classProject.test;

import edu.oakland.classProject.helper.DisplayHelper;

import junit.framework.*;
import java.util.*;
/**
* This class holds all of the JUnit test cases for testing the DisplayHelper class.
* @version: v1.0 20150815
*/
public class DisplayHelperTest extends TestCase{

    private final int MIN_UPPERBOUND_OPTION = 3;
    private final int MAX_UPPERBOUND_OPTION = 6;
	
	private final int[] testUpperBoundSelection_d1 =
		{1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
	private final int[] testUpperBoundSelection_d1_overloaded = 
		{7, 15, 31, 63};
	private final int[][] testUpperBoundSelection_d2 =
		{{1, 1}, {2, 3}, {3, 7}, {4, 15}, {5, 31}, {6, 63}, {7, 127}, {8, 255}, {9, 511}, {10, 1023},
		{11, 2047}, {12, 4095}, {13, 8191}, {14, 16383}, {15, 32767}, {16, 65535}};
	private final int[][] testUpperBoundSelection_d2_overloaded =
		{{3,7}, {4,15}, {5,31}, {6,63}};
		
	private final Integer[] testUpperBoundSelection_Integer = 
		{7, 15, 31, 63};
	private final int[] testUpperBoundSelection_int = 
		{7, 15, 31, 63};
	
	/**
	* Tests if generateUpperBoundOptions helper returns the correct upper bound options by default
	*/	
	public void testGenerateUpperBoundOptions_d1(){
		DisplayHelper displayHelper = new DisplayHelper();
		assertTrue(Arrays.equals(testUpperBoundSelection_d1,(int[])(displayHelper.generateUpperBoundOptions(1))));		
	}
	/**
	* Tests if generateUpperBoundOptions returns the correct upper bound options with a set max upper bound
	*/
	public void testGenerateUpperBoundOptions_d1_overloaded(){
		DisplayHelper displayHelper = new DisplayHelper(MIN_UPPERBOUND_OPTION, MAX_UPPERBOUND_OPTION);
		assertTrue(Arrays.equals(testUpperBoundSelection_d1_overloaded,(int[])(displayHelper.generateUpperBoundOptions(1))));		
	}
	/**
	* Tests if generateUpperBoundOptions returns the correct upper bound options paired with option numbers
	*/
	public void testGenerateUpperBoundOptions_d2(){
		DisplayHelper displayHelper = new DisplayHelper();
		assertTrue(Arrays.deepEquals(testUpperBoundSelection_d2,(int[][])(displayHelper.generateUpperBoundOptions(2))));		
	}
	/**
	* Tests if generateUpperBoundOptions returns the currect upper bound options paired with option numbers with a set max upper bound
	*/
	public void testGenerateUpperBoundOptions_d2_overloaded(){
		DisplayHelper displayHelper = new DisplayHelper(MIN_UPPERBOUND_OPTION, MAX_UPPERBOUND_OPTION);
		assertTrue(Arrays.deepEquals(testUpperBoundSelection_d2_overloaded,(int[][])(displayHelper.generateUpperBoundOptions(2))));		
	}
	/**
	* Tests if intArrayToIntergerArray converts as expected
	*/
	public void testIntArrayToIntegerArray(){
		assertTrue(Arrays.equals(testUpperBoundSelection_Integer,DisplayHelper.intArrayToIntegerArray(testUpperBoundSelection_int)));
	}

}
