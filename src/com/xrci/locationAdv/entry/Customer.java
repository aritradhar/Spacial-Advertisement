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

import java.util.Random;

import com.infomatiq.jsi.Point;
import com.xrci.locationAdv.env.Utils;

public class Customer 
{
	String id;
	Point point;
	
	public Customer(Point point)
	{
		this.point = point;
		
		byte[] b = new byte[32];
		Random rand = new Random();
		rand.nextBytes(b);
		this.id = Utils.bytesToHex(b);
	}
	
	public String toString() 
	{
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		Customer other = (Customer) obj;
		return this.id.equals(other.id) && this.point.toString().equals(other.point.toString());
	}
}
