package edu.iastate.cs228.hw4;

import java.util.ArrayList;
import java.util.Stack;

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
	
	
	public MsgTree root;
	
	public MsgTree() {
		
	}
	public MsgTree( char payload) {
		this.payloadChar = payload;
	}
	public MsgTree(String encodingString) {//create tree
		
		ArrayList<MsgTree> nodes = new ArrayList<MsgTree>();
		nodeList(nodes, encodingString);
		createTree(nodes);
	}
	public static void printCodes(MsgTree root, String code) {
		
	}
	
	
	
	public void nodeList(ArrayList<MsgTree> nodes, String s) {
		for(int i=s.length()-1;i>=0;i--) {
			MsgTree node = new MsgTree(s.charAt(i));
			nodes.add(node);
		}
	}
	
	public void createTree(ArrayList<MsgTree> nodesList) {
		Stack<MsgTree> letterStack = new Stack<>();
		Stack<MsgTree> treeStack = new Stack<>();
		for(int i=0;i<nodesList.size();i++) {
			System.out.println(nodesList.get(i).payloadChar);
			if(nodesList.get(i).payloadChar != '^') {
				letterStack.push(nodesList.get(i));
			} else if(nodesList.get(i).payloadChar == '^') {
				MsgTree parent = nodesList.get(i);
				if(!letterStack.isEmpty()) {//Grab 2 elements
					parent.left = letterStack.pop();
					if(!letterStack.isEmpty()) {
						parent.right = letterStack.pop();
					} else if(!treeStack.isEmpty()) {
						parent.right = treeStack.pop();
					}
				} else if(!treeStack.isEmpty()){//no letters before 
					parent.left = treeStack.pop();
					if(!treeStack.isEmpty()) {
						parent.right = treeStack.pop();
					}
				}
				
				
				treeStack.push(parent);
			}
			
			
		}
		root = treeStack.pop();
		
		
	}
	
	
	
	
	
	
}
