package datastructures.tree;
/**
 *  Java Program to Implement Binary Heap
 */

import java.util.Arrays;

 
/** Class BinaryHeap **/
public class BinaryHeap<T extends Comparable<T>>
{

	public T[] heap;
	private final static int d= 2;
	public int heapSize;
	
	public BinaryHeap(){
		
	}
	public BinaryHeap (T[] object){
		heapSize=0;
		heap = object;
		Arrays.fill(heap, -1);
	}
	
	public void insert(T obj){
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
	
	public void deleteItem(T obj){
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
	

	public void heapifyUp(int index){
		T currentValue = heap[index];
		while(index > 0 && currentValue.compareTo(heap[parent(index)]) < 1){
			heap[index ] = heap[parent(index)];
			index = parent(index);
		}
		heap[index] = currentValue;
	}
	

	public void heapifyDown(int index){
		T currValue = heap[index];
			while(child(index,1) < heapSize){
				if(heap[child(index,1)].compareTo(currValue)<1){
					heap[index] = heap[child(index,1)];
					index = child(index,1);
				}
				else if (heap[child(index,2)].compareTo(currValue)<1){
					heap[index] = heap[child(index,2)];
					index=child(index,2);
				}
			}
			heap[index] = currValue;
	}

}