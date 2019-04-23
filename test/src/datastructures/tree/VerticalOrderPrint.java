package datastructures.tree;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import datastructures.tree.Tree.TreeNode;
import javafx.util.Pair;

public class VerticalOrderPrint {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.buildTree1();
		BlockingQueue<Pair<TreeNode,Integer>> queue = new LinkedBlockingQueue<Pair<TreeNode,Integer>>();
		queue.add(new Pair<Tree.TreeNode, Integer>(tree.headNode, 0));
		Map<Integer,List<TreeNode>> verticalMap = new HashMap<Integer,List<TreeNode>>();
		int[] distance = printVertical(queue, verticalMap,0,0);
		printTopView(distance[0], distance[1], verticalMap);
	}

	public static int[] printVertical(Queue<Pair<TreeNode,Integer>> queue, Map<Integer,List<TreeNode>> verticalMap
			,int minDistance, int maxDistance) {
		while(!queue.isEmpty()){
			Pair<TreeNode,Integer> pair = queue.poll();
			TreeNode node = pair.getKey();
			minDistance = Math.min(minDistance, pair.getValue());
			maxDistance = Math.max(maxDistance, pair.getValue());
			if(verticalMap.containsKey(pair.getValue())){
				List<TreeNode> list = verticalMap.get(pair.getValue());
				list.add(node);
			} else {
				List<TreeNode> list = new ArrayList<TreeNode>();
				list.add(node);
				verticalMap.put(pair.getValue(), list);
			}
			if(node.left!=null)
				queue.add(new Pair<Tree.TreeNode, Integer>(node.left, pair.getValue()-1));
			if(node.right != null)
				queue.add(new Pair<Tree.TreeNode, Integer>(node.right, pair.getValue()+1));
		}
		for(int i = minDistance; i<=maxDistance; i++){
			List<TreeNode> list = verticalMap.get(i);
			for(TreeNode node : list)
				System.out.print(node.data+" ");
			System.out.println();
		}
		return new int[]{minDistance, maxDistance};
	}
	
	public static void printTopView(int minDistance, int maxDistance, Map<Integer,List<TreeNode>> verticalMap){
		System.out.println("******Top View******");
		for(int i=minDistance; i<=maxDistance; i++){
			System.out.println(verticalMap.get(i).get(0).data);
		}
	}
}
