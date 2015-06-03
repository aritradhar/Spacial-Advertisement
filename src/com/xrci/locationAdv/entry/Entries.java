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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.infomatiq.jsi.Point;
import com.infomatiq.jsi.Rectangle;
import com.infomatiq.jsi.SpatialIndex;
import com.infomatiq.jsi.rtree.RTree;
import com.xrci.locationAdv.env.ENV;

public class Entries 
{
	public static Set<Premise> premises = new HashSet<>();
	public static Set<Customer> customers = new HashSet<>();
	public static Set<Advertisement> advertisements = new HashSet<>();
	
	public static Map<Point, Customer> customerMap = new HashMap<>(); 
	public static Map<Rectangle, Premise> premiseMap = new HashMap<>();
	public static Map<Premise, Advertisement> advertisementmap = new HashMap<>();
	
	public static SpatialIndex R_TREE = new RTree();
	
	static
	{
		R_TREE.init(ENV.prop);
	}
}

