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


package com.xrci.locationAdv.dataStructure;

import com.xrci.taxonomyTree.tree.Node;

public class SpacialNode<T> extends Node<T> 
{
	private static final long serialVersionUID = 1L;

	public String advertisementId;
	
	public SpacialNode(Node<T> node) {
		super(node);
	}

}
