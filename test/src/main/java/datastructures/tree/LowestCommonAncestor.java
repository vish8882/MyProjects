package datastructures.tree;
/*
 * find lowest common ancestor between two given nodes
 */
import datastructures.tree.Tree.TreeNode;

public class LowestCommonAncestor {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.buildTree1();
		findAncestors(tree.headNode, tree.headNode.left.left, tree.headNode.left.left.right);
	}
	
	public static boolean findAncestors(TreeNode node, TreeNode node1, TreeNode node2) {
		if(node == null)
			return false;
		if(node == node1){
			if(findAncestors(node.left, node1, node2) || findAncestors(node.right, node1, node2)){
				System.out.println("Ansector is: "+ node.data);
				return false;
			}
			return true;
		}
		if(node == node2){
			if(findAncestors(node.left, node1, node2) || findAncestors(node.right, node1, node2)){
				System.out.println("Ansector is: "+ node.data);
				return false;
			}
			return true;
		}
		boolean left = findAncestors(node.left, node1, node2);
		boolean right =findAncestors(node.right, node1, node2);
		if( left && right)
			System.out.println("Ansector is: "+ node.data);
		else if(left||right)
			return true;
		return false;
	}
}
