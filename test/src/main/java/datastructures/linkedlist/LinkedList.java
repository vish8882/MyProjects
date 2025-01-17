package datastructures.linkedlist;

public class LinkedList<V> {
	
	int size;
	Node lastNode;
	Node head;
	public static class Node {
		int data;
		Node next;
		Node previous;
		
		Node (int data, Node next, Node previous){
			this.data=data;
			this.next=next;
			this.previous=previous;
		}

	}
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		l1.add(7);
		l1.add(8);
		/*l.displayAll();	
		
		l.delete(7);*/
		l.displayAll();
		l.reverseInPair();
		l.displayAll();
		l.reverse(null, null,l.head);
		l.displayAll();
		//l.reverse();
		//l1.displayAll();
		/*LinkedList l3=mergeList(l.head, l1.head);
		l3.displayAll();*/
		
	}
	
	
	public void reverseInPair(){
		Node currNode= head;
		Node prev=null;
		while(currNode!=null&&currNode.next!=null){
			if(currNode==head)
				head=currNode.next;
			Node tmp = currNode.next;
			if(prev!=null)
			prev.next=tmp;
			currNode.next=tmp.next;
			tmp.next=currNode;
			prev=currNode;
			currNode=currNode.next;
			
		}
	}
	
	public static LinkedList mergeList(Node head1, Node head2){
		LinkedList l=null;
		if(l==null)
			l=new LinkedList<Integer>();
		while(head1!=null||head2!=null){
		if(head1==null)
		{
			 l.lastNode.next=head2;
			 return l;
		}
		if(head2==null)
		{
			 l.lastNode.next=head1;
			 return l;
		}
		if(head1.data<=head2.data){
			l.add(head1.data);
			head1=head1.next;
			//mergeList(l,head1, head2);
		}else
			if(head1.data>head2.data){
				l.add(head2.data);
				head2=head2.next;
				//mergeList(l,head1, head2);
			}
		}
		return l;
	}
	
	public void reverse(){
		Node tmp=null;
		Node prev=null;
		Node curr=head;
		while(curr!=null){
			tmp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=tmp;
		}
		head=prev;
	}
	public void reverse(Node tmp, Node prev,Node curr){
			if(curr!=null){
			tmp=curr.next;
			curr.next=prev;
			reverse(tmp, curr, tmp);
			}
			else
				head=prev;
	}
	public void addO(int n){
		if(head==null){
			head= new Node(n, null, lastNode);
			lastNode=head;
		}
		else{
			Node tmp=lastNode;
			Node newNode= new Node(n, null, lastNode);
			lastNode=newNode;
			tmp.next=newNode;
		}
		size++;
	}

	public void add (int n){
		Node tmp=lastNode;
		Node newNode = new Node(n, null, lastNode);
		lastNode=newNode;
		if(tmp==null)
			head=newNode;
		else
			tmp.next=newNode;
		
	size++;	
	}
	public void displayAll(){
		Node node=head;
		int i=0;
		while(node!=null){
			System.out.print(node.data);
			node=node.next;
			if(node!=null)
				System.out.print("-->");
			i++;
		}
		System.out.println();
	}
	
	public void delete(int n){
		Node node=head;
		int i=0;
		while(i<size){
			if(node.data==n){
				node.previous.next=node.next;
				node.next.previous=node.previous;
				size--;
				break;
			}
			node=node.next;
			i++;
		}
	
	}
	
}
