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
	/**
	 * Constructor for a single node with no children.
	 * @param payload the character to be represented by the node.
	 */
	public MsgTree(char payload) {
		this.payloadChar = payload;
		//Same as default behavior but just FYI
		this.left = null;
		this.right = null;
	}
	/**
	 * Constructs a Tree from the given string. '^' are treated as internal nodes 
	 * which will have left and right children. Other characters will be treated as 
	 * leaf nodes which will have no children.
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
	 * Prints the amount of times you go left or right, as 0 or 1 respectively, to get to each letter in the tree.
	 * @param root the root node of the tree
	 * @param code the path to get to the associated payload char
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
	/**
	 * Helper method to print out table for print codes.
	 * @param c character to be printed
	 * @param code the code associated with c
	 */
	private static void outputCode(char c, String code) {
		char newLine = '\n';
		if(c == newLine) {
			System.out.println("\\n   " + code);//TODO is this what they want us to do?
		} else {
			System.out.println(c + "    " + code);
		}
	}
	
	/**
	 * Helper method that creates a reverse order list of nodes.
	 * @param nodes the list that will house the nodes in reverse order at the end of this method
	 * @param s the string from which to create the list nodes
	 */
	private void nodeList(ArrayList<MsgTree> nodes, String s) {
		for(int i=s.length()-1;i>=0;i--) {
			MsgTree node = new MsgTree(s.charAt(i));
			nodes.add(node);
		}
	}
	/**
	 * Iteratively creates the binary tree from the bottom up and returns the root node with all of the children connected below it.
	 * @param nodesList reversed order list of nodes to be created from a tree
	 * @return the root node of the created tree
	 */
	private MsgTree createTree(ArrayList<MsgTree> nodesList) {
		Stack<MsgTree> treeStack = new Stack<>();
		for(int i=0;i<nodesList.size();i++) {
//			System.out.println(nodesList.get(i).payloadChar);
			char c = nodesList.get(i).payloadChar;
			if(nodesList.get(i).payloadChar != '^') {
				treeStack.push(nodesList.get(i));
			} else if(nodesList.get(i).payloadChar == '^') {
				MsgTree parent = nodesList.get(i);
				//now we need something for left
				parent.left = treeStack.pop();
				parent.right = treeStack.pop();
				
				
				treeStack.push(parent);
			}
			
			
		}
//		root = treeStack.pop();
		return treeStack.pop();
		
	}
	/**
	 * Traverses the tree created in the constructor.
	 * @param tree the root node of the tree you wish to traverse.
	 * @param msg 0's and 1's that determine whether to go right or left.
	 * @return ans the message determined by the tree and string given as parameters
	 */
	public String decode(MsgTree tree, String msg) {
		MsgTree root = tree;
		MsgTree current = root;
		String ans = "";
		for(int i=0;i<msg.length();i++) {
			char currentNodePayload = current.payloadChar;
			char direction = msg.charAt(i);
			if(currentNodePayload != '^') {//add char to answer and reset search
				ans+= currentNodePayload;
				current = root;
				i--;
			} else if(direction == '0') {//internal node keep going left
				current = current.left;
			} else if(direction=='1') {
				current = current.right;//internal node keep going right
			}
		
		}
		ans+=current.payloadChar;
		
		return ans;
	}
	
	
	
	
	
	
	
}
