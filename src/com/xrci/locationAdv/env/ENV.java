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
	public static final Integer MaxNodeEntries = 50;
	public static final Integer MinNodeEntries = 20;
	
	public static Properties prop = null;
	
	static
	{
		prop = (MaxNodeEntries == null || MinNodeEntries == null ) ? null :new Properties();
		
		if(prop == null)
		{
			prop.setProperty("MaxNodeEntries", MaxNodeEntries.toString());
			prop.setProperty("MinNodeEntries", MinNodeEntries.toString());
		}
		
	}
	
	public static final int N_SHOPPING_PREMISES = 1000;
	public static final int N_CUSTOMRT_POINTS = 20000;
}
