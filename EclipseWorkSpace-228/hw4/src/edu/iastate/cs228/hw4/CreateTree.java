package edu.iastate.cs228.hw4;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;





/**
 * Recursively Searches through each of the 
 * @author Robert
 *
 */
public class CreateTree {
	/**
	 * Root Node of the Message Tree
	 */
	MsgTree root;
	String scheme1;
	String scheme2;
	ArrayList<MsgTree> nodes;

	
	public CreateTree(String scheme1) {
		root = new MsgTree();
		this.scheme1 = scheme1;
		nodes = new ArrayList<MsgTree>();
		nodeList(scheme1);
		createTree(nodes);
		} 
	public CreateTree(String scheme1, String scheme2) {
			root = new MsgTree();
			this.scheme1= scheme1; 
			this.scheme2= scheme2; 			
		}
	/**
	 * Creates a reverse order list of nodes from the chars in the string.
	 * @param nodesList an array list to house the nodes parsed from the string.
	 * @param s the string you wish to turn into a list of nodes.
	 */
	public void nodeList(String s) {
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
		
		
	}
	
	
	
	
	
	public String Decode() {
		String ans = "";
		
		
		
		
		
		
		return ans;
	}
	
}
