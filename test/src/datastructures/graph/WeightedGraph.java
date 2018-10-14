package datastructures.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class WeightedGraph {
	static int minCount=0;
	Map<Node,List<Node>> graphMap;
	Map<Node,List<Edges>> weightedGraphMap;
	static class Node{
		public Node(String value){
			this.value = value;
		}
		String value;
		boolean isVisited;
	}
	static class Edges{
		int weight;
		Node source;
		Node dest;
		public Edges(Node source, Node dest, int weight){
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) {
		WeightedGraph weightedGraph = new WeightedGraph();
		weightedGraph.weightedGraphMap = new HashMap<Node, List<Edges>>();
		Node node1 = new Node("1");
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		weightedGraph.addEdge(node3, node2);
		weightedGraph.addEdge(node2, node1);
		weightedGraph.addEdge(node1, node4);
		weightedGraph.addEdge(node4, node5);
		weightedGraph.addEdge(node3, node4);
		weightedGraph.addEdge(node5, node6);
		Queue<Node> queue = new LinkedBlockingQueue<Node>();
		queue.add(node3);
		weightedGraph.breadthFirstSearch(queue);
	}
	
	public void addEdge(Node source, Node dest) {
		List<Edges> list = weightedGraphMap.get(source);
		if (list == null) {
			list = new LinkedList<Edges>();
		}
		list.add(new Edges(source, dest, 5));
		this.weightedGraphMap.put(source, list);
	}
	
	public void breadthFirstSearch(Queue<Node> queue) {
		Node node = queue.poll();
		if (node == null)
			return;
		if (!node.isVisited) {
			System.out.println(node.value);
			node.isVisited = true;
			if (weightedGraphMap.get(node) != null)
				for (Edges e : weightedGraphMap.get(node)) {
					queue.offer(e.dest);
				}
		}
		breadthFirstSearch(queue);
	}
	
}
