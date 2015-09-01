import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Count_Inversions {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\MBSL\\Desktop\\IntegerArray.txt"));
		int[] a=new int[100000];
		for(int i=0;i<a.length;i++)
			a[i]=Integer.parseInt(br.readLine());
		System.out.println(count_inversions(a));
		
	}
	public static long count_inversions(int[] a)
	{
		int[] temp=new int[a.length];
		long count_inv=sortandcount(a,temp,0,a.length-1);
		return count_inv;
	}
	private static long sortandcount(int[] a, int[] temp, int low, int high) {
		// TODO Auto-generated method stubs
		long count_inv=0;
		if(low<high)
		{
			int mid=(high+low)/2;
			count_inv=sortandcount(a, temp, low, mid);
			count_inv+=sortandcount(a, temp, mid+1, high);
			count_inv+=count_split_inversions(a,temp,low,mid,high);
		}
		return count_inv;
		
	}
	
	private static long count_split_inversions(int[] a, int[] temp, int low, int mid,
			int high) {
		// TODO Auto-generated method stub
		long count_inv=0;
		int i=low,j=mid+1,k=low;
		while(i<=mid&&j<=high)
		{
			if(a[i]<=a[j])
				temp[k++]=a[i++];
			else
			{
				temp[k++]=a[j++];
				count_inv+=(mid-i+1);
				
			}
		}
		while(i<=mid)
			temp[k++]=a[i++];
		while(j<=high)
			temp[k++]=a[j++];
		for(i=low;i<=high;i++)
			a[i]=temp[i];
		
		
		return count_inv;
	}

}
