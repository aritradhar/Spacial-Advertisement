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

import java.util.Set;

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
		return "Advertisement id : " + this.id + " Premise " + this.premise;
	}
	
	public float profileMatch(Customer customer )
	{
		boolean[] preference = customer.preferences;
		Set<boolean[]> history= customer.history;
		
		int tot = 0;
		for(int i = 0; i < ENV.N_PREFERENCES; i++)
		{
			if(this.preferences[i] == preference[i])
				tot++;
		}
		
		for(boolean[] b : history)
		{
			for(int i = 0; i < ENV.N_PREFERENCES; i++)
			{
				if(this.preferences[i] == b[i])
					tot++;
			}
		}
		
		return (float)(tot)/(ENV.N_PREFERENCES * ENV.N_HISTORY + 1);
	}
}
