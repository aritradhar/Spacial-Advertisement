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


package com.xrci.locationAdv.entry;

import com.xrci.locationAdv.env.ENV;
import com.xrci.locationAdv.env.Utils;

public class Advertisement 
{
	String id;
	boolean[] preferences;
	
	public Advertisement(boolean[] preferences)
	{
		this.preferences = preferences;
		this.id = Utils.makeRandomId(ENV.ID_ADVERTISEMENT);
	}
}
