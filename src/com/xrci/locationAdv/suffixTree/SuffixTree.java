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

import com.infomatiq.jsi.Point;
import com.xrci.locationAdv.entry.Customer;

public class SuffixTree 
{
	Node ROOT;
	
	public SuffixTree()
	{
		this.ROOT = new Node();
	}
	
	public void insert(Customer customer)
	{
		String customer_id = customer.id;
		
		Node temp_parent = this.ROOT;
		for(int i = 0; i < customer_id.length(); i++)
		{
			if(i == customer_id.length() - 1)
			{
				new LeafNode(customer_id.charAt(i), temp_parent, customer);
			}
			Node Node = new Node(customer_id.charAt(i), temp_parent);
			temp_parent = Node;
		}
	}
	
	public static void main(String[] args) 
	{
		SuffixTree st = new SuffixTree();
		st.insert(new Customer(new Point(1.5f, 1.0f)));
	}
}
