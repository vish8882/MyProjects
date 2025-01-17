package datastructures.graph;

import java.util.*;

public class DisjointSet {
	Map<Integer,Node> map = new HashMap<Integer,Node>();
	static class Node {
		int value;
		Node parent;
		int level;
	}
	
	public void makeSet(int value) {
		Node node = new Node();
		node.value = value;
		node.level = 0;
		node.parent=node;
		map.put(node.value, node);
	}
	public void union(int value1, int value2) {
		Node parent1 = findSet(map.get(value1));
		Node parent2 = findSet(map.get(value2));
		if (parent1 == parent2)
			return;
		if (parent1.level >= parent2.level) {
			parent2.parent = parent1;
			parent1.level = parent1.level == parent2.level ? parent1.level + 1
					: parent1.level;
		} else
			parent1.parent = parent2;
	}
	
	public Node findSet(Node a) {
		Node parent = a.parent;
		if(a==parent)
			return parent;
		a.parent = findSet(parent);
		return a.parent;
	}
	
	public static void main(String[] args) {
		
	}
}
