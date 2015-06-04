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


package com.xrci.locationAdv.suffixTree;

import com.xrci.locationAdv.entry.Customer;
import com.xrci.locationAdv.env.Utils;

public class LeafNode extends Node
{
	static boolean isLeaf = true; 
	Customer customer;
	
	public LeafNode(char index, Node parent)
	{
		this.address = parent.address + (new String(new char[]{index}));
		this.children = null;
		int ind = Utils.getNibble(index);
		parent.children[ind] = this;
	}
	
	public LeafNode(char index, Node parent, Customer customer)
	{
		this.address = parent.address + (new String(new char[]{index}));
		this.children = null;
		this.customer = customer;
		int ind = Utils.getNibble(index);
		parent.children[ind] = this;
	}
}
