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
	Premise premise;
	String descriptor;
	boolean[] preferences;
	
	public Advertisement(boolean[] preferences, Premise premise)
	{
		this.preferences = preferences;
		this.id = Utils.makeRandomId(ENV.ID_ADVERTISEMENT);
		this.premise = premise;
		
		premise.advertisements.add(this);
		Entries.advertisements.add(this);
	}
	
	@Override
	public String toString() 
	{
		return "id : " + this.id + " Premise " + this.premise;
	}
}
