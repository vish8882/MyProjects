package datastructures.graph;


import java.util.*;
import java.util.Map.Entry;

import datastructures.graph.WeightedGraph.Edges;
import datastructures.graph.WeightedGraph.Node;

public class Dijkstra {
	PriorityQueue<Vertex> queue = new PriorityQueue<>(new VertexCompare());
	Map<Node,Vertex> map = new HashMap<Node,Vertex>();
	Map<Node, Node> parentMap = new HashMap<>();
	public static void main(String[] args) {
		WeightedGraph weightedGraph = new WeightedGraph();
		weightedGraph.weightedGraphMap = new HashMap<Node, List<Edges>>();
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF= new Node("F");
		weightedGraph.addEdgeUndirected(nodeA, nodeB, 5);
		weightedGraph.addEdgeUndirected(nodeA, nodeE, 2);
		weightedGraph.addEdgeUndirected(nodeE, nodeF, 3);
		weightedGraph.addEdgeUndirected(nodeA, nodeD, 9);
		weightedGraph.addEdgeUndirected(nodeB, nodeC, 2);
		weightedGraph.addEdgeUndirected(nodeC, nodeD, 3);
		weightedGraph.addEdgeUndirected(nodeF, nodeD, 2);
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.shortestSingleSourcePath(weightedGraph, nodeA);
		Iterator<Entry<Node,Vertex>> itr = dijkstra.map.entrySet().iterator();
		while(itr.hasNext()){
			Entry<Node, Vertex> entry = itr.next();
			System.out.println(entry.getKey().value +" "+ entry.getValue().value);
		}
		System.out.println();
		Iterator<Entry<Node, Node>> itr1 = dijkstra.parentMap.entrySet().iterator();
		while(itr1.hasNext()){
			Entry<Node, Node> entry = itr1.next();
			System.out.println(entry.getKey().value +" "+ entry.getValue().value);
		}
	}
	
	public void shortestSingleSourcePath(WeightedGraph weightedGraph, Node sourceNode){
		buildMinHeapMap(weightedGraph, sourceNode);
		parentMap.put(sourceNode, sourceNode);
		while(!queue.isEmpty()){
			Vertex currentVertex = queue.poll();
			Node currentNode = currentVertex.node;
			List<Edges> edgesList = weightedGraph.weightedGraphMap.get(currentNode);
			for(Edges e : edgesList) {
				Node n = e.dest;
				Vertex v = map.get(n);
				if(!queue.contains(v))
					continue;
				if(e.weight+currentVertex.value < v.value){
					v.value = e.weight+currentVertex.value;
					queue.remove(v);
					queue.add(v);
					parentMap.put(e.dest, e.source);
				}
			}
		}
	}
	
	public void buildMinHeapMap(WeightedGraph weightedGraph, Node sourceNode){
		Iterator<Node> itr = weightedGraph.weightedGraphMap.keySet().iterator();
		while(itr.hasNext()){
			Node n = itr.next();
			Vertex v = new Vertex(n);
			if(n == sourceNode)
				v.value = 0;
			map.put(n,v);
			queue.add(v);
		}
	}
	
	class Vertex {
		Node node;
		int value;
		public Vertex(Node node) {
			this.node= node;
			this.value = Integer.MAX_VALUE;
		}
	}
	
	class VertexCompare implements Comparator<Vertex> {
		@Override
		public int compare(Vertex o1, Vertex o2) {
			return +(o1.value-o2.value);
		}
	}
}
