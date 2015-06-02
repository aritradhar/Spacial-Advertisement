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
import com.infomatiq.jsi.SpatialIndex;
import com.infomatiq.jsi.rtree.RTree;
import com.xrci.locationAdv.env.ENV;

public class Entries 
{
	public static List<Rectangle> premises = new ArrayList<>();
	public static List<Point> customers = new ArrayList<>();
	public static Map<Point, String> customerMap = new HashMap<>(); 
	
	public static SpatialIndex R_TREE = new RTree();
	
	static
	{
		R_TREE.init(ENV.prop);
	}
}
