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

import java.io.FileWriter;
import java.io.IOException;
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
		
		Random rand = new Random();
		//add random premises
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < r; j++)
			{
				Rectangle rect = new Rectangle(i, j, i + ENV.RECTANGLE_SEPARATION, j + ENV.RECTANGLE_SEPARATION);
				
				Premise premise = new Premise(rect);
				//add advertisements in the premises
				int n_ad = rand.nextInt(ENV.N_MAX_ADVERTISEMNENTS_PER_PREMISE);
				
				for(int k = 0; k < n_ad; k++)
				{
					new Advertisement(Utils.makeRandomBooleanArray(ENV.N_PREFERENCES), premise);
				}
				
				Entries.premises.add(premise);
				
				int id = i * r + j;
				Entries.R_TREE.add(rect, id);	
				Entries.rectangleIdMap.put(id, rect);
				
				Entries.premiseMap.put(rect, premise);
			}
		}
		System.out.println("Total Advertisements : " + Entries.advertisements.size());
		
		//add random customers
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
	
	public void query() throws IOException
	{
		
		FileWriter fw = new FileWriter("log.txt");
		
		//query with a random customer
		Customer customer = (Customer) Entries.customers.toArray()[new Random().nextInt(ENV.N_CUSTOMRT_POINTS)];
		//for(Customer customer : Entries.customers)
		{
			Point point = customer.point;
			Entries.R_TREE.nearestN(point, new TIntProcedure() 
			{	
				@Override
				public boolean execute(int id) 
				{
					try 
					{
						Premise p = Entries.premiseMap.get(Entries.rectangleIdMap.get(id));
						
						System.out.println(customer + " location : "+ point + 
								" Rtree id : "+ id + " : " + p);
						
						fw.append(customer + " location : "+ point + 
								" Rtree id : "+ id + " : " + p + "\n");
						
						for(Advertisement ad : p.advertisements)
						{
							System.out.println(ad + "Match : " + ad.profileMatch(customer));
						}
						
					}
					
					catch (IOException e) 
					{
						e.printStackTrace();
					}				
					return false;
				}
				
			}, ENV.QUERY_RECTANGEL, ENV.QUERY_DISTANCE);
		}
		
		fw.close();
	}
	public static void main(String[] args) throws IOException 
	{
		Main main = new Main();
		main.init();
		
		long start = System.currentTimeMillis();
		main.query();
		long end = System.currentTimeMillis();
		
		System.out.println("Total execution time : " + (end - start) + " ms");
	}
}
