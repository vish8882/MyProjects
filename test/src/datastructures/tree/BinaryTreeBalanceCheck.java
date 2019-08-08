/**
 * program to check whether the tree is height balanced or not
 */
package datastructures.tree;

import datastructures.tree.Tree.TreeNode;

public class BinaryTreeBalanceCheck {
	
	static class Pair {
		int height;
		boolean isBalanced;
		
		Pair(int height, boolean isBalanced){
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.buildTree1();
		System.out.println(checkBalance(tree.headNode).isBalanced);
	}
	
	public static Pair checkBalance(TreeNode node) {
		if(node == null) {
			return new Pair(0, true);
		}
		
		Pair pLeft = checkBalance(node.left);
		Pair pRight = checkBalance(node.right);
		if(!pLeft.isBalanced || !pRight.isBalanced)
			return new Pair(0, false);
		if(Math.abs(pLeft.height - pRight.height) > 1)
			return new Pair(Math.max(pLeft.height, pRight.height)+1, false);
		else
			return new Pair(Math.max(pLeft.height, pRight.height)+1, true);	
	}

}
