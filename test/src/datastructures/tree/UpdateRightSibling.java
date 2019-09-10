import test.Tree.TreeNode;

public class UpdateRightSibling {
	
	static class Pair {
		TreeNode parent;
		TreeNode node;
		public Pair(TreeNode parent, TreeNode node) {
			this.parent = parent;
			this.node = node;
		}
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.buildTree1();
		tree.headNode.rightSibling=null;
		updateSibling(tree.headNode, tree.headNode, null, tree.headNode);
		printRighSibling(tree.headNode);
	}
	
	public static void printRighSibling(TreeNode node) {
		TreeNode leftMost = node;
		while(leftMost !=null) {
			TreeNode left = leftMost;
			while(left !=null) {
				System.out.print(left.data+" ");
				left = left.rightSibling;
			}
			leftMost = findLeft(leftMost, null, null).node;
		}
	}
	
	public static void updateSibling(TreeNode parent, TreeNode left, TreeNode right, TreeNode leftMost) {
		
		while(left !=null || parent != null) {
			Pair pair = findLeft(parent, null, right);
			leftMost = pair.node;
			parent = pair.parent;
			left = leftMost;
			while(left !=null) {
				if(parent!=null) {
					Pair pairRight = findRight(parent, left, null);
					right = pairRight.node;
					parent = pairRight.parent;
				}
				else
					break;
				left.rightSibling = right;
				left = left.rightSibling;
			}
			parent = leftMost;
		}
	}
	
	public static Pair findLeft(TreeNode parent, TreeNode left, TreeNode right) {
		while (left == null && parent != null) {
			if (parent.left == null && parent.right == null) {
				parent = parent.rightSibling;
				continue;
			}
			if (parent.left != null) {
				left = parent.left;
			} else {
				left = parent.right;
				parent = parent.rightSibling;
			}
		}
		return new Pair(parent, left);
	}
	
	public static Pair findRight(TreeNode parent, TreeNode left, TreeNode right) {
		while (right == null && parent != null) {
			if (parent.left == left || parent.right == left) {
				if (parent.left != null) {
					if (parent.left == left) {
						if (parent.right != null) {
							right = parent.right;
							break;
						} else {
							parent = parent.rightSibling;
							continue;
						}
					}
				}
				if (parent.right != null) {
					if (parent.right == left) {
						parent = parent.rightSibling;
						continue;
					} else {
						right = parent.right;
						break;
					}
				}
			} else {
				if(parent.left != null) {
					right = parent.left;
					break;
				}
				else if (parent.right != null) {
					right = parent.right;
					break;
				}
				else
					parent = parent.rightSibling;
			}
		}
		return new Pair(parent, right);
	}
}
