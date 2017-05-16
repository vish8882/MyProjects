package datastructures.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Tree {

	TreeNode headNode;
	public static class TreeNode{
		public int data;
		public TreeNode left;
		public TreeNode right;
		public TreeNode (int data, TreeNode left, TreeNode right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	
	public void displayPreOrder(TreeNode root){
		if(root!=null){
			System.out.print(root.data+" ");
			displayPreOrder(root.left);
			displayPreOrder(root.right);
		}
		
	}
	
	public void displayIterativePostOrder(){
		Stack<TreeNode> s = new Stack();
		List list = new ArrayList();
		TreeNode node = headNode;
		boolean empty=false;
		while(!empty){
			if(node!=null)
			{
				s.push(node);
				node =node.left;
			}
			else{
				if(s.isEmpty())
					break;
				node=s.peek();
				if(list.contains(node)){
					System.out.print(s.pop().data+" ");
					node=null;
					continue;
					}
				if(node.right!=null){
					list.add(node);
				node=node.right;
				}
				else{
				node=s.pop();
				System.out.print(node.data+" ");
				node=node.right;
				}
			}
		}
	}
	
	public void searchBinaryTree() throws Exception{}
	
	public boolean isBinaryTree() throws Exception{
		TreeNode node=headNode;
		TreeNode prevNode=null;
		boolean isEmpty=false;
		Stack<TreeNode> q = new Stack();
		if(headNode==null)
			return true;
		else
		{
			while(!isEmpty){
				if(node!=null)
				{
					q.push(node);
					node=node.left;
					
				}
				else{
					if(q.isEmpty())
						isEmpty=true;
					else{
						node=q.pop();
						if(prevNode!=null&&node.data<prevNode.data)
							return false;
						prevNode=node;
						node =node.right;
					}
				}
				
				
			}
			return true;
		}
	}
	public void displayIterativeInOrder(){
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode node = headNode;
		boolean empty=false;
		while(!empty){
			if(node!=null){
				s.push(node);
				node=node.left;
			}
			else{
				if(s.isEmpty())
					empty=true;
				else{
				node=s.pop();
				System.out.print(node.data+" ");
				node=node.right;
				}
			}
		}
	}
	
	public void levelOrderTraverdal() throws Exception{
		TreeNode node = headNode;
		BlockingQueue<TreeNode> q = new LinkedBlockingQueue();
		q.put(node);
		while(!q.isEmpty()){
			node=q.take();
			System.out.print(node.data+" ");
			if(node.left!=null)
				q.put(node.left);
			if(node.right!=null)
				q.put(node.right);
		}
	}
	
	public void levelOrderReverse() throws Exception{
		TreeNode node = headNode;
		Stack<TreeNode> s= new Stack();
		BlockingQueue<TreeNode> q = new LinkedBlockingQueue();
		q.put(node);
		while(!q.isEmpty()){
			node=q.take();
			s.push(node);
			if(node.right!=null)
				q.put(node.right);
			if(node.left!=null)
				q.put(node.left);
		}
		while(!s.isEmpty()){
			System.out.print(s.pop().data+" ");
		}
	}
	
	
	public void findDepth(){
		Stack<TreeNode> s= new Stack<TreeNode>();
		List<TreeNode> list= new ArrayList<TreeNode>();
		boolean empty=false;
		int count=0;
		int depth=0;
		TreeNode node=headNode;
		while(!empty){
			if(node!=null){
				s.push(node);
				node=node.left;
				count++;
			}
			else{
				if(s.isEmpty()){
					empty=true;
				} else{
					node=s.peek();
					if(list.contains(node)){
						s.pop();
						if(depth<count)
							depth=count;
							count--;
						node=null;
						continue;
					}
					if(node.right!=null){
						list.add(node);
						node=node.right;
					}
					else{
					node = s.pop();
					if(depth<count)
					depth=count;
					count--;
					node=node.right;
					}
				}
			}
		}
		System.out.print(depth);
	}
	
	public void findMinimumDepth(){
		Stack<TreeNode> s= new Stack<TreeNode>();
		List<TreeNode> list= new ArrayList<TreeNode>();
		boolean empty=false;
		boolean first=true;
		int count=0;
		int depth=0;
		TreeNode node=headNode;
		while(!empty){
			if(node!=null){
				s.push(node);
				node=node.left;
				count++;
			}
			
			else{
				if(s.isEmpty()){
					empty=true;
				} else{
					node=s.peek();
					if(list.contains(node)){
						s.pop();
						count--;
						node=null;
						continue;
					}
					if(node.right!=null){
						list.add(node);
						node=node.right;
					}
					else{
					node = s.pop();
					if(first){
						depth=count;
						first=false;
					}
					else{
						if(depth>count)
							depth=count;
					}
					count--;
					node=node.right;
					}
				}
			}
		}
		System.out.print(depth);
	}
	
	public void addNonBinary(int n) throws Exception{
		BlockingQueue<TreeNode> q = new LinkedBlockingQueue();
		TreeNode node= null;
		if(headNode==null)
		{
			headNode=new TreeNode(n, null, null);
		}
		else{
			q.put(headNode);
			while(!q.isEmpty()){
				node=q.take();
				if(node.left!=null)
					q.put(node.left);
				else
				{
					node.left=new TreeNode(n, null, null);
					break;
				}
				if(node.right!=null)
					q.put(node.right);
				else
				{
					node.right= new TreeNode(n, null, null);
					break;
				}
				}
			}
	}
	
	
	public void displayIterativePreOrder(){
		Stack<TreeNode> s= new Stack<TreeNode>();
		s.push(headNode);
		while(!s.isEmpty()){
			TreeNode node= s.pop();
			System.out.print(node.data+" ");
			if(node.right!=null)
				s.push(node.right);
			if(node.left!=null)
				s.push(node.left);
		}
	}
	
	public boolean search(int n){
		TreeNode node = headNode;
		if(headNode==null)
			return false;
		while(node!=null){
			if(node.data==n)
				return true;
			if(node.data<n){
				node = node.right;
			}
			if(node.data>n)
				node=node.left;
		}
		return false;
	}
	
	public void add(int n){
		TreeNode node = headNode;
		TreeNode lastNode = null;
		if(headNode==null){
			headNode=new TreeNode(n, null, null);
		}else{
			while(node!=null){
				if(node.data<n){
					lastNode=node;
					node = node.right;
				}
				else{
					lastNode=node;
					node=node.left;
				}
			}
			if(lastNode.data<n)
				lastNode.right=new TreeNode(n, null, null);
			else
				lastNode.left=new TreeNode(n, null, null);
		}
	}
	
	public void maxLevelSum()throws Exception{
		Queue<TreeNode> q= new LinkedList<TreeNode>();
		q.offer(headNode);
		q.offer(null);
		int sum=0, finalSum=0;
		TreeNode node = null;
		while(!q.isEmpty()){
			node=q.poll();
			if(node!=null){
				sum=sum+node.data;
				if(node.left!=null)
					q.offer(node.left);
				if(node.right!=null)
					q.offer(node.right);
			}
			else{
				if(sum>finalSum)
					finalSum=sum;
				sum=0;
				if(!q.isEmpty())
					q.offer(null);
			}
			
		}
		System.out.print(finalSum);
	}
	
	public int diameter(TreeNode node){
		
		if(node==null)
			return 0;
		int len1= height(node.left)+ height(node.right)+1;
		int len2= Math.max(diameter(node.left), diameter(node.right));
		return Math.max(len1, len2);
	}
	
	public static int height (TreeNode node){
		if(node==null)
			return 0;
		int left=height(node.left);
		int right = height(node.right);
		return Math.max(left+1, right+1);
	}
	
	public void printAllPath(){
		TreeNode node= headNode;
		int[] path= new int[256];
		printPath(node, path,0);
	}
	public void printPath(TreeNode node, int[] path, int pathLength){
		if(node==null)
			return;
		path[pathLength]=node.data;
		pathLength++;
		if(node.left==null&&node.right==null){
			for(int i=0;i<pathLength;i++)
				System.out.print(path[i]+" ");
			System.out.println();
		}
		else{
			printPath(node.left, path,pathLength);
			printPath(node.right, path,pathLength);
		}

	}
	
	public boolean hasSum(TreeNode node,int sum){
		if(node==null)
			return false;
		if(sum==0){
			return true;
			
		}
		else
		
			return hasSum(node.left,sum-node.data) || hasSum(node.right,sum-node.data);
	}
	
	public void mirror(TreeNode node){
		if(node==null)
			return;
		TreeNode tmp = node.left;
		node.left=node.right;
		node.right=tmp;
		mirror(node.left);
		mirror(node.right);
	}
	
	public void createTree(ArrayList inorder, ArrayList preorder){
		
	}
	
}
