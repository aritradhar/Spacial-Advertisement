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

import java.security.SecureRandom;
import java.util.Random;

import com.infomatiq.jsi.Point;
import com.infomatiq.jsi.Rectangle;
import com.xrci.locationAdv.env.ENV;
import com.xrci.locationAdv.env.Utils;

public class Main 
{
	public void init()
	{
		int r = (int) Math.sqrt(ENV.N_SHOPPING_PREMISES);
		
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < r; j++)
			{
				Rectangle rect = new Rectangle(i, j, i + 0.5f, j + 0.5f);
				Entries.premises.add(rect);
				Entries.R_TREE.add(rect, i * r + j);
			}
		}
		
		Random rand = new Random();
		SecureRandom sRand = new SecureRandom();
		for(int i = 0; i < ENV.N_CUSTOMRT_POINTS; i++)
		{
			
			Point point = new Point(rand.nextFloat() * r, rand.nextFloat() * r);
			Entries.customers.add(point);
			byte[] b = new byte[16];
			sRand.nextBytes(b);
			Entries.customerMap.put(point, Utils.bytesToHex(b));
			
		}
		
		System.out.println(Entries.R_TREE.toString());
		
	}
	
	public static void main(String[] args) 
	{
		new Main().init();
	}
}
