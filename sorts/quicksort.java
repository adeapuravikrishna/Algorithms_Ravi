package algorithmica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class quicksort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] a=new int[10000];
		//int[] a={6,5,4,3,2,1,1,1,1,1};
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\rohith\\algoritmica\\algorithmica\\src\\testcases\\QuickSort.txt"));
		for(int i=0;i<10000;i++)
			a[i]=Integer.parseInt(br.readLine());
		quicksort(a, 0, a.length-1);
		//for(int i=0;i<a.length;i++)
			//System.out.print(a[i]+" ");
		System.out.println(count);
	
	}
	public static int count;
	public static void quicksort(int[] a,int low,int high)
	{
	
		if(low<high)
		{
			count=count+(high-low);
			int j=partition(a, low, high);
			quicksort(a,low,j-1);
			quicksort(a,j+1,high);
		}
		
	}
	private static int partition(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		//swap(a,low,high);
		choose_median(a,low,high);
		int pivot=a[low];
		int i=low+1,j;
		for(j=low+1;j<=high;j++)
		{
			if(a[j]<pivot)
			{
				swap(a,i,j);
				i++;
			}
		}
		swap(a,i-1,low);
		return i-1;
	}
	private static void choose_median(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		int[] b=new int[3];
		int pivotindex=-1;
		int mid=((high-low)/2)+low;
		b[0]=a[low];
		b[1]=a[high];
		b[2]=a[mid];
		Arrays.sort(b);
		if(b[1]==a[low])
			pivotindex=low;
		else if(b[1]==a[mid])
			pivotindex=mid;
		else
			pivotindex=high;
		
		swap(a,low,pivotindex);
			
			
		
		
	}
	private static void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp=a[j];
		a[j]=a[i];
		a[i]=temp;
	}
	public static int partition_end(int[] a,int low,int high)
	{
		int pivot=a[high];
		int i=low;
		int j=low;
		for(j=low;j<high;j++)
		{
			if(a[j]<pivot)
			{
				swap(a,i,j);
				i++;
			}
		}
		swap(a,i,high);
		return i;
		
	}

}
