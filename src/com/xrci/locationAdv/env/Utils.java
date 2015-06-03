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


package com.xrci.locationAdv.env;

import java.security.SecureRandom;
import java.util.Random;

public class Utils 
{
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String bytesToHex(byte[] bytes) 
	{
		char[] hexChars = new char[bytes.length * 2];

		for ( int j = 0; j < bytes.length; j++ ) 
		{
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	public static String makeRandomId(int len)
	{
		byte[] bytes = new byte[len];
		Random rand = new Random();
		rand.nextBytes(bytes);
		
		char[] hexChars = new char[bytes.length * 2];

		for ( int j = 0; j < bytes.length; j++ ) 
		{
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
	
	public static boolean[] makeRandomBooleanArray(int count)
	{
		boolean[] arr = new boolean[count];
		Random rand = new Random();
		
		for(int i = 0; i < count; i++)
		{
			int r = rand.nextInt() % 2;
			if(r == 0)
				arr[i] = true;
			else
				arr[i] = false;
		}
		
		return arr;
	}


	public static void main(String[] args) 
	{
		byte[] b = new byte[4];
		new SecureRandom().nextBytes(b);

		System.out.println(bytesToHex(b));
	}
}
