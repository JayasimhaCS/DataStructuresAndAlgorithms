package com.cormen.divideandcon;

/**
 * Merge sort is a divide and conqure method of sorting, which follows a recursive tree
 * approach.
 * hence => T(n) = 2T(n/2)+cn where c is some constant c>0
 *	on solving this we have our time as O(nlgn) 
 *
 */
public class MergeSort 
{
	public static void main(String[] args)
	{
		int arr[] = {1,2,3,7,6,5};
		mergeSort(arr,0,arr.length-1);
		for(int element:arr)
		{
			System.out.print(element);
		}
	}

	private static void mergeSort(int[] arr, int start, int end) 
	{
		if(start<end)
		{
			int mid = (start+end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			mergeArray(arr,start,mid,end);
		}
	}

	private static void mergeArray(int[] arr, int start, int mid, int end) 
	{
		int[] temp1 = new int[arr.length];
		int[] temp2 = new int[arr.length];
		for(int i=start;i<=mid;i++)
		{
			temp1[i-start] = arr[i];
		}
		for(int i=mid+1;i<=end;i++)
		{
			temp2[i-mid-1] = arr[i];
		}
		temp1[mid+1-start] = Integer.MAX_VALUE;
		temp2[end+1-mid-1] = Integer.MAX_VALUE;
		int m=0,k=0;
		for(int i=start;i<=end;i++)
		{
			if(temp1[m]<temp2[k])
			{
				arr[i]=temp1[m];
				m++;
			}
			else
			{
				arr[i]=temp2[k];
				k++;
			}
		}
	}
}
