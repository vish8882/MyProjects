package datastructures.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import datastructures.tree.Tree.TreeNode;
import javafx.util.Pair;

public class TreeBottomLevel {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.buildTree1();
		printBottomLevelView(tree.headNode);
	}
	
	public static void printBottomLevelView(TreeNode headNode) {
		BlockingQueue<Pair<TreeNode,Integer>> queue = new LinkedBlockingQueue<Pair<TreeNode,Integer>>();
		queue.add(new Pair<Tree.TreeNode, Integer>(headNode, 0));
		Map<Integer,List<TreeNode>> verticalMap = new HashMap<Integer,List<TreeNode>>();
		int minDistance=0;
		int maxDistance = 0;
		while(!queue.isEmpty()) {
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
		for(int i = minDistance; i <=  maxDistance; i++){
			List<TreeNode> list = verticalMap.get(i);
			System.out.println(list.get(list.size()-1).data);
		}
	}
}
