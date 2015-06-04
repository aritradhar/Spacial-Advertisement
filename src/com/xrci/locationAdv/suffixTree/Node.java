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

import com.xrci.locationAdv.env.Utils;

public class Node 
{
	String address;
	Node[] children;
	
	public Node(char index, Node parent)
	{
		this.address = parent.address + (new String(new char[]{index}));
		this.children = new Node[16];
		int ind = Utils.getNibble(index);
		parent.children[ind] = this;
	}
	
	public Node()
	{
		this.address = new String();
		this.children = new Node[16];
	}
	
	public Node getChild(int i)
	{
		return this.children[i];
	}
	
	public Node getChNode(char c)
	{
		return this.children[Utils.getNibble(c)];
	}
}
