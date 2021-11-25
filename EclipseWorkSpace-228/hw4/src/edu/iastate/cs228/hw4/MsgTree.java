package edu.iastate.cs228.hw4;

/**
 * Represents the Message Tree Nodes.
 * @author Robert Holeman
 *
 */
public class MsgTree {
	/**
	 * The value at a given node. 
	 */
	public char payloadChar;
	/**
	 * The left child of the given node.
	 */
	public MsgTree left;
	/**
	 * The right child of the given node.
	 */
	public MsgTree right;
	
	public MsgTree() {
		
	}
	public MsgTree(char payload) {
		this.payloadChar = payload;
	}
	
}
