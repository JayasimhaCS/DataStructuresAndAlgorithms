package com.cormen.divideandcon;

/**
 * This program prints a largest sub array with the largest sum
 * example, consider the given below array of numbers
 * 13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7
 * answer
 * low pos 7 high pos 10 sum 43(with 0 index) 
 */
public class MaximumSubArray 
{
	public static void main(String[] args)
	{
		int[] a = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		int[] x = getMaxSubArray(a, 0, a.length-1);
		System.out.println("low pos "+x[0]+" high pos "+x[1]+" sum "+x[2]);
	}
	public static int[] getMaxSubArray(int a[],int low, int high)
	{
		if(low == high)
		{
			return new int[] {low,high,a[low]};
		}
		else
		{
			int mid = (low+high)/2;
			int[] leftArray = getMaxSubArray(a, low, mid);
			int[] rightArray = getMaxSubArray(a, mid+1, high);
			int[] maxArray = getMidSubArray(a, low, high, mid);
			if(leftArray[2]>=rightArray[2] && leftArray[2] >= maxArray[2])
				return leftArray;
			else if(rightArray[2]>=leftArray[2] && rightArray[2] >= maxArray[2])
				return rightArray;
			else
				return maxArray;
		}
	}
	public static int[] getMidSubArray(int a[],int low, int high, int mid)
	{
		int[] returnTuple = new int[3];
		int sumLeft = Integer.MIN_VALUE;
		int sumL=0;
		int leftPos = 0;
		for(int i=mid;i>=low;i--)
		{
			sumL+=a[i];
			if(sumL>=sumLeft)
			{
				sumLeft = sumL;
				leftPos = i;
			}
		}
		int sumRight = Integer.MIN_VALUE;
		int sumR=0;
		int rightPos = 0;
		for(int i=mid+1;i<=high;i++)
		{
			sumR+=a[i];
			if(sumR>=sumRight)
			{
				sumRight = sumR;
				rightPos = i;
			}
		}
		returnTuple[0]=leftPos;
		returnTuple[1]=rightPos;
		returnTuple[2]=sumLeft+sumRight;
		return returnTuple;
	}
}
