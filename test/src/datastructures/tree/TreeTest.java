package datastructures.tree;

public class TreeTest {
	
	public static void main(String[] args) throws Exception{
		Tree tree = new Tree();
		tree.addNonBinary(10);
		tree.addNonBinary(17);
		tree.addNonBinary(14);
		tree.addNonBinary(6);
		tree.addNonBinary(15);
		tree.addNonBinary(12);
		tree.addNonBinary(13);
		tree.add(7); 
		tree.add(4);
		tree.addNonBinary(10);
		tree.add(3);
		tree.add(5);
		tree.add(2);
		tree.add(8);
		tree.displayPreOrder(tree.headNode);
		//tree.add(11);
		/*tree.displayIterativePreOrder();
		System.out.println();
		tree.displayIterativeInOrder();
		System.out.println();
		tree.displayIterativePostOrder();
		System.out.println();
		tree.levelOrderTraverdal();
		System.out.println();
		//System.out.print(tree.isBinaryTree());
		System.out.print(tree.isBinaryTree());
		System.out.println();
		tree.levelOrderReverse();
		System.out.println();
		tree.findDepth();
		System.out.println();
		tree.findMinimumDepth();
		System.out.println();
		System.out.print(tree.diameter(tree.headNode));
		System.out.println();
		tree.maxLevelSum();
		System.out.println();*/
		//tree.printAllPath();
		System.out.println(tree.hasSum(tree.headNode, 37));
		//tree.mirror(tree.headNode);
		tree.displayIterativeInOrder();
		System.out.println();
		tree.displayIterativePreOrder();
	}

}
