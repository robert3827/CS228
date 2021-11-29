package edu.iastate.cs228.hw4;

import java.io.PrintStream;

public class BinaryTreeModel {
	private Object value;
    private BinaryTreeModel left;
    private BinaryTreeModel right;
	private BinaryTreeModel tree;

    public BinaryTreeModel(Object value) {
        this.value = value;
    }
    public Object getValue() {
    	return value;
    }
    public BinaryTreeModel getLeft() {
    	return left;
    }
    public BinaryTreeModel getRight() {
    	return right;
    }
    
    
    public void traversePreOrder(StringBuilder sb, BinaryTreeModel node) {
        if (node != null) {
            sb.append(node.getValue());
            sb.append("\n");
            traversePreOrder(sb, node.getLeft());
            traversePreOrder(sb, node.getRight());
        }
    }
    
    public void print(PrintStream os) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, this.tree);
        os.print(sb.toString());
    }
    
}
