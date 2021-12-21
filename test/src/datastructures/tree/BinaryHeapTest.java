package datastructures.tree;

import java.util.Scanner;

/** Class BinaryHeapTest **/
public class BinaryHeapTest
{
    public static void main(String[] args)
    {
    	BinaryHeap bh = new BinaryHeap();
    	bh.insert(3);
    	bh.insert(1);
    	bh.insert(6);
    	bh.insert(5);
    	bh.insert(9);
    	bh.insert(8);
    	bh.printHeap();
    	bh.deleteItem(3);
    	System.out.println();
    	bh.printHeap();
    }
}