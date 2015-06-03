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
	public static final boolean OverWriteTreeProp = true;
	
	public static final Integer MaxNodeEntries = 50;
	public static final Integer MinNodeEntries = 20;
	
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
	
	//N_SHOPPING_PREMISES must be a square
	public static final int N_SHOPPING_PREMISES = 900;
	public static final int N_CUSTOMRT_POINTS = 20000;
	public static final int N_PREFERENCES = 10;
	public static final int N_HISTORY = 50;
}
