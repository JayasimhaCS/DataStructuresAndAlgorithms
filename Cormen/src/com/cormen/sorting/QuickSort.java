package com.cormen.sorting;

public class QuickSort 
{
	public static void main(String[] args)
	{
		int[] array = {3,2,1,6,5,4};
		quickSort(array,0,array.length-1);
		for(int number:array)
		{
			System.out.print(number+" ");
		}
	}

	private static void quickSort(int[] array, int start, int end) 
	{
		if(start<end)
		{
			int partition = getPartition(array,start,end);
			quickSort(array, start, partition-1);
			quickSort(array, partition+1, end);
		}
	}

	private static int getPartition(int[] array, int start, int end) 
	{
		int i = start-1;
		for(int j=start;j<end;j++)
		{
			if(array[j]<array[end])
			{
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		int temp = array[end];
		array[end] = array[i+1];
		array[i+1] = temp;
		return i+1;
	}
}
