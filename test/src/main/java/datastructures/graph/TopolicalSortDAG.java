package datastructures.graph;

import java.util.*;

import datastructures.graph.DirectedGraph.Node;


public class TopolicalSortDAG {

	public static void main(String[] args) {
		DirectedGraph directedGraph = new DirectedGraph();
		Node node0= new Node("0");
		Node node1= new Node("1");
		Node node2= new Node("2");
		Node node3= new Node("3");
		Node node4= new Node("4");
		Node node5= new Node("5");
		Node node6= new Node("6");
		Node node7= new Node("7");
		Node node8= new Node("8");
		directedGraph.add(node0, node2);
		directedGraph.add(node1, node2);
		directedGraph.add(node2, node4);
		directedGraph.add(node1, node3);
		directedGraph.add(node4, node6);
		directedGraph.add(node4, node5);
		directedGraph.add(node3, node6);
		directedGraph.add(node6, node7);
		directedGraph.add(node7, node8);
		List<Node> nodeList = directedGraph.getNodeList();
		topologicalSort(nodeList, directedGraph);
	}
	
	public static void topologicalSort(List<Node> nodeList, DirectedGraph directedGraph){
		Set<Node> visitedNode = new HashSet<Node>();
		Stack<Node> sortedNode = new Stack<Node>();
		for(Node n : nodeList){
			if(visitedNode.contains(n))
				continue;
			else{
				visitedNode.add(n);
				breadthFirstSearch(n, visitedNode, sortedNode, directedGraph);
			}
		}
		while(!sortedNode.isEmpty())
			System.out.println(sortedNode.pop().value);
	}

	public static void breadthFirstSearch(Node n, Set<Node> visitedNode, Stack<Node> sortedNode,
			DirectedGraph directedGraph) {
		List<Node> graphNode = directedGraph.graphMap.get(n);
		if(graphNode == null){
			sortedNode.push(n);
			return;
		}
		for(Node node : graphNode ){
			if(visitedNode.contains(node))
				continue;
			else{
				visitedNode.add(node);
				breadthFirstSearch(node, visitedNode, sortedNode, directedGraph);
			}
		}
		sortedNode.push(n);
	}

}
