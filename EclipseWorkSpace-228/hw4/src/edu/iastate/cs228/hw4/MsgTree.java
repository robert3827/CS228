package edu.iastate.cs228.hw4;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Represents the Message Tree Nodes and their children (if they have any).
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
	
	
//	public MsgTree root;//MsgTree Object now represents the binary tree when constructed to be so.
	
	public MsgTree( char payload) {
		this.payloadChar = payload;
		//Same as default behavior but just FYI
		this.left = null;
		this.right = null;
	}
	/**
	 * Constructs a Tree from the given string. The Object 
	 * @param encodingString the format of the tree that should be constructed.
	 */
	public MsgTree(String encodingString) {//create tree
		
		ArrayList<MsgTree> nodes = new ArrayList<MsgTree>();
		nodeList(nodes, encodingString);
//		root = createTree(nodes);
		MsgTree root = createTree(nodes);
		this.payloadChar = root.payloadChar;
		this.left = root.left;
		this.right = root.right;
	}
	/**
	 * Prints the amount of times you go left or right, as 0 or 1 respectively, to get to every letter in the tree.
	 * @param root - root node of the tree
	 * @param code
	 */
	public static void printCodes(MsgTree root, String code) {
		if(root.payloadChar != '^') {
			outputCode(root.payloadChar, code);
		} else {
			if (root.left != null) {
				printCodes(root.left, code + "0");
			}
			if (root.right != null) {
				printCodes(root.right, code + "1");
			}
		}
		
	}
	private static void outputCode(char c, String code) {
		System.out.println(c + "    " + code);
	}
	
	
	public void nodeList(ArrayList<MsgTree> nodes, String s) {
		for(int i=s.length()-1;i>=0;i--) {
			MsgTree node = new MsgTree(s.charAt(i));
			nodes.add(node);
		}
	}
	/**
	 * Creates the binary tree from the bottom up and returns the root node with all of the children connected below it.
	 * @param nodesList
	 * @return
	 */
	public MsgTree createTree(ArrayList<MsgTree> nodesList) {
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
//		root = treeStack.pop();
		return treeStack.pop();
		
	}
	public String decode(MsgTree tree, String msg) {
		String ans = "";
		int i=0;
		while(tree.payloadChar == '^') {
			if(msg.charAt(i) == 0) {
				//TODO
			}
		}
		
		
		
		
		
		
		
		return ans;
	}
	
	
	
	
	
	
	
}
