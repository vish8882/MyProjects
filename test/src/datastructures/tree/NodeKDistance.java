package datastructures.tree;

import datastructures.tree.Tree.TreeNode;

public class NodeKDistance {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.buildTree1();
		recurseTree(tree.headNode, 0, 3, tree.headNode.left);
		
	}

	public static int recurseTree(TreeNode node, int curr, int k, TreeNode targetNode) {
		if(node == null) {
			return 0;
		}
		if(node == targetNode) {
			printKNode(node, curr, k);
			return 1;
		}
		int next1=recurseTree(node.left, curr, k, targetNode);
		if(next1 > 0){
			if(next1 ==k){
				System.out.println(node.data);
				return next1+1;
			}
			printKNode(node.right, next1+1, k);
			return next1+1;
		}
		int  next = recurseTree(node.right, curr, k, targetNode);
		if(next > 0){
			if(next1 ==k){
				System.out.println(node.data);
				return next1+1;
			}
			printKNode(node.left, next+1, k);
			return next+1;
		}
		return 0;
	}
	
	public static int printKNode(TreeNode node, int curr,int k) {
		if(node == null || curr > k)
			return curr;
		if( curr== k){
			System.out.println(node.data);
			return 0;
		}
		printKNode(node.left,curr+1, k);
		printKNode(node.right, curr+1, k);
		return 0;
	}
}
