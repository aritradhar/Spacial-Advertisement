//*************************************************************************************
//*********************************************************************************** *
//author Aritra Dhar 																* *
//Research Engineer																  	* *
//Xerox Research Center India													    * *
//Bangalore, India																    * *
//--------------------------------------------------------------------------------- * * 
///////////////////////////////////////////////// 									* *
//The program will do the following:::: // 											* *
///////////////////////////////////////////////// 									* *
//version 1.0 																		* *
//*********************************************************************************** *
//*************************************************************************************


package com.xrci.locationAdv.env;

import java.util.Properties;

public class ENV 
{
	private static final boolean OverWriteTreeProp = true;
	
	private static final Integer MaxNodeEntries = 50;
	private static final Integer MinNodeEntries = 20;
	
	public static Properties prop = null;
	
	static
	{
		prop = (!OverWriteTreeProp) ? null :new Properties();
		
		if(prop != null)
		{
			System.err.println("Overwriting properties");
			prop.setProperty("MaxNodeEntries", MaxNodeEntries.toString());
			prop.setProperty("MinNodeEntries", MinNodeEntries.toString());
		}
		
	}
	
	public static final float RECTANGLE_SEPARATION = 0.5f;
	
	//N_SHOPPING_PREMISES must be a square
	public static final int N_SHOPPING_PREMISES = 900;
	public static final int N_CUSTOMRT_POINTS = 80000;
	
	public static final int N_PREFERENCES = 10;
	public static final int N_HISTORY = 10;
	
	public static final int N_MAX_ADVERTISEMNENTS_PER_PREMISE = 100;
	
	public static final int ID_CUSTOMER = 16;
	public static final int ID_PREMISE= 16;
	public static final int ID_ADVERTISEMENT = 8;
	
	public static final float QUERY_DISTANCE = 1.5f;
	public static final int QUERY_RECTANGEL = 3;
}
