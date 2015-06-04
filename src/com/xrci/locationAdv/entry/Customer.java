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

import com.infomatiq.jsi.Point;
import com.xrci.locationAdv.env.ENV;
import com.xrci.locationAdv.env.Utils;

public class Customer 
{
	public String id;
	Point point;
	boolean[] preferences;
	Set<boolean[]> history;
	
	public Customer(Point point)
	{
		this.point = point;
		this.id = Utils.makeRandomId(ENV.ID_CUSTOMER);
	}
	
	public Customer(Point point, boolean[] preferences, Set<boolean[]> history)
	{
		this.point = point;
		
		this.id = Utils.makeRandomId(ENV.ID_CUSTOMER);
		
		this.preferences = preferences;
		this.history = history;
	}
	
	public String toString() 
	{
		return "Customer id : " + this.id;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		Customer other = (Customer) obj;
		return this.id.equals(other.id) && this.point.toString().equals(other.point.toString());
	}
}
