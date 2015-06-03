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

import gnu.trove.TIntProcedure;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.infomatiq.jsi.Point;
import com.infomatiq.jsi.Rectangle;
import com.xrci.locationAdv.env.ENV;
import com.xrci.locationAdv.env.Utils;

public class Main 
{
	public void init()
	{
		int r = (int) Math.sqrt(ENV.N_SHOPPING_PREMISES);
		
		//add random premises
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < r; j++)
			{
				Rectangle rect = new Rectangle(i, j, i + 0.5f, j + 0.5f);
				
				Premise premise = new Premise(rect);
				Entries.premises.add(premise);
				Entries.R_TREE.add(rect, i * r + j);
				
				Entries.premiseMap.put(rect, premise);
			}
		}
		
		//add random customers
		Random rand = new Random();
		for(int i = 0; i < ENV.N_CUSTOMRT_POINTS; i++)
		{
			
			Point point = new Point(rand.nextFloat() * r, rand.nextFloat() * r); 
			
			Customer customer = new Customer(point);
			customer.preferences = Utils.makeRandomBooleanArray(ENV.N_PREFERENCES);
			
			Set<boolean[]> history = new HashSet<>();
			for(int j = 0; j < ENV.N_HISTORY; j++)
			{
				history.add(Utils.makeRandomBooleanArray(ENV.N_PREFERENCES));
			}
			customer.history = history;
			
			Entries.customers.add(customer);
			Entries.customerMap.put(point, customer);	
			
		}
		
		System.out.println(Entries.R_TREE.toString());
		
	}
	
	public void query()
	{
		for(Customer customer : Entries.customers)
		{
			Point point = customer.point;
			Entries.R_TREE.nearestN(point, new TIntProcedure() 
			{	
				@Override
				public boolean execute(int id) 
				{
					//System.out.println(point.toString() + " : "+ id);
					return false;
				}
			}, 3, 1.5f);
		}
	}
	public static void main(String[] args) 
	{
		Main main = new Main();
		main.init();
		main.query();
	}
}
