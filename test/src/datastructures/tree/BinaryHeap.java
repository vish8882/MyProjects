package datastructures.tree;
/**
 *  Java Program to Implement Binary Heap
 */
 
import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;

import com.sun.glass.ui.View.Capability;
 
/** Class BinaryHeap **/
class BinaryHeap
{

	public Object[] heap;
	private final static int d= 2;
	public int heapSize;
	
	public BinaryHeap(){
		
	}
	public BinaryHeap (int capacity){
		heapSize=0;
		heap = new Object[capacity];
		Arrays.fill(heap, -1);
	}
	
	public void insert(Object obj){
		if(heapSize > heap.length)
			System.out.println("Heap is full");
		heap[heapSize]=obj;
		heapSize=heapSize+1;
		heapifyUp(heapSize-1);
	}
	
	public Object removeMinimum(){
		Object key = heap[0];
		delete(0);
		return key;
	}
	
	public boolean isFull(){
		return heapSize == heap.length;
	}
	
	public boolean isEmpty(){
		return heapSize==0;
	}
	
	public void makeEmpty(){
		heapSize=0;
	}
	
	public void deleteItem(Object obj){
		for(int i =0 ;i<heapSize-1;i++){
			if(heap[i].equals(obj)){
				delete(i);
				break;
			}
		}
	}
	
	public void printHeap(){
		for(int i =0 ;i<heapSize;i++){
			System.out.print(heap[i]+" ");
		}
	}
	
	public int child (int index, int k){
		return d * index + k;
	}
	
	public void delete(int index){
		heap[index] = heap[heapSize - 1];
		heapSize--;
		heapifyDown(index);
	}
	
	public int parent(int index){
		return (index-1)/d;
	}
	
	/**
	 * Return true if Object1 is less than Object2
	 * @param obj1 
	 * @param obj2
	 * @return
	 */
	public boolean isLessThan(Object obj1, Object obj2){
		if(obj1 instanceof Integer)
			if(((Integer)obj1).compareTo((Integer)obj2) < 1)
				return true;
		if(obj1 instanceof String)
			if(((String)obj1).compareTo((String)obj2) < 1)
				return true;
		return false;
	}
	
	public void heapifyUp(int index){
		Object currentValue = heap[index];
		while(index > 0 && isLessThan(currentValue, heap[parent(index)])){
			heap[index ] = heap[parent(index)];
			index = parent(index);
		}
		heap[index] = currentValue;
	}
	
	public void heapifyDown(int index){
		Object currValue = heap[index];
			while(child(index,1) < heapSize){
				if(isLessThan(heap[child(index,1)], currValue)){
					heap[index] = heap[child(index,1)];
					index = child(index,1);
				}
				else if (isLessThan(heap[child(index,2)], currValue)){
					heap[index] = heap[child(index,2)];
					index=child(index,2);
				}
			}
			heap[index] = currValue;
	}

}