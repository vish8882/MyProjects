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

	public int[] heap;
	private final static int d= 2;
	public int heapSize;
	
	public BinaryHeap(){
		
	}
	public BinaryHeap (int capacity){
		heapSize=0;
		heap = new int[capacity];
		Arrays.fill(heap, -1);
	}
	
	public void insert(int value){
		if(heapSize > heap.length)
			System.out.println("Heap is full");
		heap[heapSize]=value;
		heapSize=heapSize+1;
		heapifyUp(heapSize-1);
	}
	
	public int removeMinimum(){
		int key = heap[0];
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
	
	public void deleteItem(int value){
		for(int i =0 ;i<heapSize-1;i++){
			if(heap[i]==value){
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
	
	public void heapifyUp(int index){
		int currentValue = heap[index];
		while(index > 0 && currentValue < heap[parent(index)]){
			heap[index ] = heap[parent(index)];
			index = parent(index);
		}
		heap[index] = currentValue;
	}
	
	public void heapifyDown(int index){
		int currValue = heap[index];
			while(child(index,1) < heapSize){
				if(heap[child(index,1)] < currValue){
					heap[index] = heap[child(index,1)];
					index = child(index,1);
				}
				else if (heap[child(index,2)] < currValue){
					heap[index] = heap[child(index,2)];
					index=child(index,2);
				}
			}
			heap[index] = currValue;
	}

}