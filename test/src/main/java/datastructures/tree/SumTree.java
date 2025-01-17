package datastructures.tree;

import datastructures.tree.Tree.TreeNode;

public class SumTree {

	public static int findSuminTree(TreeNode headNode) {
		if(headNode == null)
			return 0;
		if(headNode.left == null && headNode.right == null)
			return headNode.data;
		
		return (findSuminTree(headNode.left) + findSuminTree(headNode.right) + headNode.data);
	}
	
	public static int buildSumTree(TreeNode headNode) {
		if(headNode == null)
			return 0;
		if(headNode.left == null && headNode.right == null){
			int data  = headNode.data;
			headNode.data=0;
			return data;
		}
		headNode.data = buildSumTree(headNode.left) + buildSumTree(headNode.right) + headNode.data;
		return headNode.data;
	}
}
