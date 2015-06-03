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

import java.util.HashSet;
import java.util.Set;

import com.infomatiq.jsi.Rectangle;
import com.xrci.locationAdv.env.ENV;
import com.xrci.locationAdv.env.Utils;

public class Premise 
{
	String id;
	Rectangle rect;
	public Set<Advertisement> advertisements;
	
	public Premise(Rectangle rect)
	{
		this.rect = rect;
		
		/*
		byte[] b = new byte[32];
		Random rand = new Random();
		rand.nextBytes(b);
		*/
		this.id = Utils.makeRandomId(ENV.ID_PREMISE);
		advertisements = new HashSet<>();
	}
	
	public Premise(Rectangle rect, Set<Advertisement> advertisements)
	{
		this.rect = rect;
		this.id = Utils.makeRandomId(ENV.ID_PREMISE);
		this.advertisements = advertisements;
	}
	
	@Override
	public String toString() 
	{
		return "id : " + this.id + " location : " + this.rect;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		Premise other = (Premise) obj;
		return this.id.equals(other.id) && this.rect.toString().equals(other.rect.toString());
	}
}
