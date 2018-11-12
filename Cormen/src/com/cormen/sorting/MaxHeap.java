package com.cormen.sorting;

public class MaxHeap 
{
	private int currentHeapSize;
	
	private int[] heap;
	
	public MaxHeap()
	{
		super();
	}
	
	public MaxHeap(int heapSize)
	{
		this.heap = new int[heapSize];
		this.currentHeapSize = 0;
	}
	
	public MaxHeap(int array[])
	{
		this.heap = array;
		this.currentHeapSize = array.length;
	}
	
	public void setMaxHeap(int array[])
	{
		this.heap = array;
		this.currentHeapSize = array.length;
	}
	
	public void setMaxHeap(int heapSize)
	{
		this.heap = new int[heapSize];
		this.currentHeapSize = 0;
	}
	
	private int getLeft(int index)
	{
		return ((2*index)+1);
	}
	
	private int getRight(int index)
	{
		return ((2*index)+2);
	}
	
	private int getParent(int index)
	{
		return index%2 == 0?((index/2)-1):index/2;
	}
	
	private void MaxifyHeap(int index)
	{
		int larger = this.heap[index];
		int largerPos = index;
		if(getLeft(index)<currentHeapSize && this.heap[getLeft(index)]>larger)
		{
			larger = this.heap[getLeft(index)];
			largerPos = getLeft(index);
		}
		if(getRight(index)<currentHeapSize && this.heap[getRight(index)]>larger)
		{
			larger = this.heap[getRight(index)];
			largerPos = getRight(index);
		}
		if(largerPos != index)
		{
			this.heap[largerPos] = this.heap[index];
			this.heap[index] = larger;
			MaxifyHeap(largerPos);
		}
	}
	
	public void buildMaxHeap()
	{
		for(int i=((this.heap.length/2)-1);i>=0;i--)
		{
			MaxifyHeap(i);
		}
	}
	
	public void sortArray()
	{
		buildMaxHeap();
		for(int i=this.heap.length-1;i>0;i--)
		{
			int temp = this.heap[i];
			this.heap[i] = this.heap[0];
			this.heap[0] = temp;
			this.currentHeapSize--;
			MaxifyHeap(0);
		}
		setMaxHeap(1);
	}
}
