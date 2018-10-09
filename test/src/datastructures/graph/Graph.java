package datastructures.graph;

import java.util.*;

public class Graph {
	Map<Node,List<Node>> map = new HashMap<Node,List<Node>>();
	boolean found=false;
	static int minPath=5;
	//int count=0;
	static class Node{
		public Node(String value){
			this.value=value;
		} 
		String value;
		boolean visited;
	}
	
	
	public void add(Node source, Node destination){
		List<Node> list;
		if(!map.containsKey(source)){
			list = new LinkedList<Node>();
			list.add(destination);
			map.put(source,list);
		}
		else{
			list= map.get(source);
			list.add(destination);
		}
		if(!map.containsKey(destination)){
			list = new LinkedList<Node>();
			list.add(source);
			map.put(destination,list);
		}
		else{
			list= map.get(destination);
			list.add(source);
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		Node node0= new Node("0");
		Node node1= new Node("1");
		Node node2= new Node("2");
		Node node3= new Node("3");
		Node node4= new Node("4");
		Node node5= new Node("5");
		Node node6= new Node("6");
		Node node7= new Node("7");
		graph.add(node2, node1);
		graph.add(node1, node0);
		graph.add(node0, node3);
		graph.add(node3, node7);
		graph.add(node3, node4);
		graph.add(node7, node4);
		graph.add(node7, node6);
		graph.add(node4, node6);
		graph.add(node4, node5);
		graph.add(node6, node5);
		
		//graph.add(node2, node5);
		//graph.findAllNodes(node3);
		System.out.println(graph.findMinimumPath(node2, node6,0));
		System.out.println("Minimum Path= "+minPath);
		/*minPath=5;
		System.out.println(graph.findMinimumPath(node3, node5,0));
		System.out.println("Minimum Path= "+minPath);*/
	
	}
	
	public boolean isFound(){
		if(found)
			return true;
		else 
			return false;
	}
	
	public int findMinimumPath(Node source, Node dest, int count){
		List<Node> list;
		if(map.containsKey(source)){
			list=map.get(source);
			if(list.contains(dest)){
				count++;
				if(count<minPath)
					minPath=count;
				return count;
			}
			else if(!isFound()){
				source.visited=true;
				Iterator<Node> itr= list.iterator();
				
				while(itr.hasNext()){
					Node node= itr.next();
					if(!node.visited){
						count++;
						findMinimumPath(node, dest, count);
						node.visited= false;
						count--;
					/*	if((count=findPath(node, dest, count))>0)
							return count;*/
					}	
			}
			}
		}
		return count;
	}
	
	
	public void findAllNodes(Node source){
		List<Node> list;
		if(map.containsKey(source)){
			list=map.get(source);
				source.visited=true;
				Iterator<Node> itr= list.iterator();
				while(itr.hasNext()){
					Node node= itr.next();
					if(!node.visited){
						System.out.println(node.value);
						findAllNodes(node);
					/*	if((count=findPath(node, dest, count))>0)
							return count;*/
					}	
			}
		}
	}
	
}
