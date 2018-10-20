package datastructures.graph;

import java.util.*;

import datastructures.graph.WeightedGraph.Edges;
import datastructures.graph.WeightedGraph.Node;

public class Kruskal {
	static List<Edges> edgeList;
	static List<Edges> mstList= new ArrayList<Edges>();
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
		weightedGraph.addEdgeUndirected(node0, node1, 4);
		weightedGraph.addEdgeUndirected(node0, node7, 8);
		weightedGraph.addEdgeUndirected(node1, node7, 11);
		weightedGraph.addEdgeUndirected(node1, node2, 8);
		weightedGraph.addEdgeUndirected(node7, node8, 7);
		weightedGraph.addEdgeUndirected(node7, node6, 1);
		weightedGraph.addEdgeUndirected(node2, node3, 7);
		weightedGraph.addEdgeUndirected(node2, node5, 4);
		weightedGraph.addEdgeUndirected(node2, node8, 2);
		weightedGraph.addEdgeUndirected(node8, node6, 6);
		weightedGraph.addEdgeUndirected(node6, node5, 2);
		weightedGraph.addEdgeUndirected(node5, node3, 14);
		weightedGraph.addEdgeUndirected(node5, node4, 10);
		weightedGraph.addEdgeUndirected(node3, node4, 9);
		edgeList = weightedGraph.getEdgeList();
		sortEdgesByWeight();
		Set<Node> nodes = weightedGraph.weightedGraphMap.keySet();
		createMST(nodes);
		for(Edges e : mstList)
			System.out.println(e.source.value +"---"+e.weight+"--->"+e.dest.value);
	}
	
	public static void sortEdgesByWeight(){
		Collections.sort(edgeList, new EdgeComparator());
	}
	
	public static void createMST(Set<Node> nodes) {
		DisjointSet disjointSet = new DisjointSet();
		for (Node n : nodes)
			disjointSet.makeSet(Integer.parseInt(n.value));
		for (Edges e : edgeList) {
			Node source = e.source;
			Node dest = e.dest;
			if (disjointSet.findSet(disjointSet.map.get(Integer.parseInt(source.value))) == disjointSet
					.findSet(disjointSet.map.get(Integer.parseInt(dest.value))))
				continue;
			else {
				disjointSet.union(Integer.parseInt(source.value), Integer.parseInt(dest.value));
				mstList.add(e);
			}
		}
	}
	
	public static class EdgeComparator implements Comparator<Edges>{

		@Override
		public int compare(Edges o1, Edges o2) {
			return o1.weight-o2.weight;
		}
		
	}
}
