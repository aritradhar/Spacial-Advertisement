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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infomatiq.jsi.Point;
import com.infomatiq.jsi.Rectangle;

public class Entries 
{
	public static List<Rectangle> premises = new ArrayList<>();
	public static List<Point> customers = new ArrayList<>();
	public static Map<Point, Byte[]> customerMap = new HashMap<>(); 
}
