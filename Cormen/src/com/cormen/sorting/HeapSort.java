package com.cormen.sorting;

public class HeapSort 
{
	public static void main(String[] args)
	{
		MaxHeap maxHeap = new MaxHeap();
		int[] array = {3,2,1,6,5,4};
		maxHeap.setMaxHeap(array);
		maxHeap.sortArray();
		for(int x:array)
		{
			System.out.print(x+" ");
		}
	}
}
