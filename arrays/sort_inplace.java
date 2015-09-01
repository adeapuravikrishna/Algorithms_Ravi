
public class sort_inplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,3,4,5};
		int[] b={0,0,0,0,2,0,0,0,0,0};
		sorti(a,b,4);
	}

	private static void sorti(int[] a, int[] b,int k) {
		// TODO Auto-generated method stub
		int i=a.length-1;
		int j=b.length-1;
		while(i>=0&&k>=0&&j>=0)
		{
			if(a[i]>=b[k])
			{
				b[j]=a[i];
				j--;
				i--;
			}
			else
			{
				b[j]=b[k];
				j--;
				k--;
			}
		}
		while(i>=0)
		{
			b[i]=a[i];
			i--;
		}
		
		for(i=0;i<b.length;i++)
			System.out.print(b[i]+" ");
		
	}

}
