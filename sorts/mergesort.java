package algorithmica;

public class mergesort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={12,11,10,9,8,7,6,5,5};
		mergesort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");

	}
	public static void mergesort(int[] a)
	{
		int[] temp=new int[a.length];
		mergesort(a,temp,0,a.length-1);
	}
	
	private static void mergesort(int []a,int[] temp,int low,int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;
			mergesort(a,temp,low,mid);
			mergesort(a,temp,mid+1,high);
			merge(a,temp,low,mid,high);

		}
	}
	private static void merge(int[] a,int[] temp,int low, int mid, int high) {
		// TODO Auto-generated method stub
		int i=low,j=mid+1,k=low;
		while(i<=mid&&j<=high)
		{
			if(a[i]<a[j])
				temp[k++]=a[i++];
			else
				temp[k++]=a[j++];
		}
		while(i<=mid)
			temp[k++]=a[i++];
		while(j<=high)
			temp[k++]=a[j++];
		for(i=low;i<=high;i++)
			a[i]=temp[i];
		
	}
}
