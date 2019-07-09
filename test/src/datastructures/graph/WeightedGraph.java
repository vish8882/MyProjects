package datastructures.graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class WeightedGraph {
	static int minCount=0;
	Map<Node,List<Node>> graphMap;
	Map<Node,List<Edges>> weightedGraphMap;
	private List<Edges> edgeList;
	private static List<Node> verticesList;
	
	public WeightedGraph(){
		this.edgeList = new ArrayList<Edges>();
		this.verticesList = new ArrayList<Node>();
	}
	
	public List<Node> getVerticesList (){
		return verticesList;
	}
	
	static class Node implements Comparable<Node>{
		public Node(String value){
			this.value = value;
			verticesList.add(this);
		}
		String value;
		boolean isVisited;
		@Override
		public int compareTo(Node o) {
			return this.value.compareTo(o.value);
		}
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
	
	public List<Edges> getEdgeList() {
		return edgeList;
	}

	public static void main(String[] args) {
		WeightedGraph weightedGraph = new WeightedGraph();
		weightedGraph.weightedGraphMap = new HashMap<Node, List<Edges>>();
		Node node0 = new Node("0");
		Node node1 = new Node("1");
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		Node node8 = new Node("8");
		Node node9 = new Node("9");
		weightedGraph.addEdge(node0, node1,4);
		weightedGraph.addEdge(node0, node7,8);
		weightedGraph.addEdge(node1, node7,11);
		weightedGraph.addEdge(node1, node2,8);
		weightedGraph.addEdge(node7, node8,7);
		weightedGraph.addEdge(node7, node6,1);
		weightedGraph.addEdge(node2, node3,7);
		weightedGraph.addEdge(node2, node5,4);
		weightedGraph.addEdge(node2, node8,2);
		weightedGraph.addEdge(node8, node6,6);
		weightedGraph.addEdge(node6, node5,2);
		weightedGraph.addEdge(node5, node3,14);
		weightedGraph.addEdge(node5, node4,10);
		weightedGraph.addEdge(node3, node9,4);
		Queue<Node> queue = new LinkedBlockingQueue<Node>();
		queue.add(node3);
		weightedGraph.breadthFirstSearch(queue);
	}
	
	public void addEdge(Node source, Node dest, int weight) {
		List<Edges> list = weightedGraphMap.get(source);
		if (list == null) {
			list = new ArrayList<Edges>();
		}
		list.add(new Edges(source, dest, weight));
		this.weightedGraphMap.put(source, list);
	}
	
	public void addEdgeUndirected(Node source, Node dest, int weight) {
		List<Edges> listSource = weightedGraphMap.get(source);
		List<Edges> listDest = weightedGraphMap.get(dest);
		if (listSource == null) {
			listSource = new ArrayList<Edges>();
		}
		if (listDest == null) {
			listDest = new ArrayList<Edges>();
		}
		Edges sourceEdge = new Edges(source, dest, weight);
		this.edgeList.add(sourceEdge);
		listSource.add(sourceEdge);
		listDest.add(new Edges(dest, source, weight));
		this.weightedGraphMap.put(source, listSource);
		this.weightedGraphMap.put(dest, listDest);
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
