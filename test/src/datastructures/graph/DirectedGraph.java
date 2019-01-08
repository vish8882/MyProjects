package datastructures.graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

import datastructures.tree.BinaryHeap;
import datastructures.tree.BinaryHeapTest;

public class DirectedGraph {
	static int minCount=0;
	Map<Node,List<Node>> graphMap;
	private List<Node> nodeList;
	
	public DirectedGraph(){
		this.graphMap = new HashMap<Node,List<Node>>();
	}
	
	public static class Node implements Comparable<Node>{
		public Node(String value){
			this.value = value;
		}
		String value;
		boolean isVisited;
		@Override
		public int compareTo(Node o) {
			return this.value.compareTo(o.value);
		}
		
	}
	static class Edges{
		String weight;
		Node source;
		Node dest;
		public Edges(Node source, Node dest, String weight){
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) {
		DirectedGraph directedGraph = new DirectedGraph();
		Node node1= new Node("1");
		Node node2= new Node("2");
		Node node3= new Node("3");
		Node node4= new Node("4");
		Node node5= new Node("5");
		Node node6= new Node("6");
		directedGraph.add(node3, node2);
		directedGraph.add(node2, node1);
		directedGraph.add(node1, node4);
		directedGraph.add(node4, node5);
		directedGraph.add(node3, node4);
		directedGraph.add(node5, node6);
		directedGraph.add(node1, node3);
		Queue<Node> queue = new LinkedBlockingQueue<Node>();
		queue.add(node3);
		queue.add(new Node(""));
		directedGraph.breadthFirstSearch(queue);
		Stack<Node> stack =  new Stack<Node>();
		stack.push(node3);
		//directedGraph.depthFirstSearch(stack);
		//directedGraph.minimumPathBFS(queue, node6, minCount);
		//System.out.println(directedGraph.detectCycles(node3));
		//System.out.println(minCount);
	}
	
	public List<Node> getNodeList(){
		return nodeList;
	}
	public boolean add(Node source, Node dest){
		if(nodeList==null)
			nodeList= new ArrayList<Node>();
		nodeList.add(source);
		List<Node> list = this.graphMap.get(source);
		if(list == null){
			list = new LinkedList<Node>();
		} 
		list.add(dest);
		this.graphMap.put(source, list);
		return true;
	}
	
	public void breadthFirstSearch(Queue<Node> queue){
		Node node = queue.poll();
		if(node==null)
			return;
		if(!node.isVisited){
			node.isVisited=true;
			System.out.println(node.value);
			List<Node> list = this.graphMap.get(node);
			if (list != null) {
				for (Node n : list)
					queue.add(n);
			}
		}
		breadthFirstSearch(queue);
		
	}
	
	public void minimumPathBFS(Queue<Node> queue, Node dest, int count) {
		Node node = queue.poll();
		if (node.value.equals("")) {
			minCount++;
			node = queue.poll();
			queue.add(new Node(""));
		}
		if (node.equals(dest)) {
			return;
		}
		if (!node.isVisited) {
			node.isVisited = true;
			List<Node> list = this.graphMap.get(node);
			if (list != null) {
				for (Node n : list)
					queue.add(n);
			}
		}
		minimumPathBFS(queue, dest, count);
	}
	
	public void depthFirstSearch(Stack<Node> stack) {
		Node node = null;
		if (!stack.isEmpty())
			node = stack.pop();
		if (node == null)
			return;
		if (!node.isVisited) {
			node.isVisited = true;
			System.out.println(node.value);
			List<Node> list = this.graphMap.get(node);
			if (list != null) {
				for (Node n : list)
					stack.push(n);
			}
		} else {
			System.out.println(node.value + " was visited earlier");
		}
		depthFirstSearch(stack);
	}
	
	public boolean detectCycles(Node node){
		if (node == null)
			return false;
		if (!node.isVisited) {
			node.isVisited = true;
			List<Node> list = this.graphMap.get(node);
			if (list != null) {
				for (Node n : list){
					if(detectCycles(n))
						return true;
					node.isVisited=false;
				}
			}
			else
				node.isVisited=false;
		} else {
			return true;
		}
		return false;
	}
}
