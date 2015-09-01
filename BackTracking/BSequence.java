import javax.annotation.Generated;


public class BSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for(int i=0;i<=1;i++)
		{
			for(int j=0;j<=1;j++)
			{
				for(int k=0;k<=1;k++)
				{
					System.out.print(i+""+j+""+k);
					System.out.println();
				}
			}

		}*/
		generateBS(4);

	}
	public static void generateBS(int n)
	{
		int[] in=new int[n];
		aux_BS(0,n,in);
	}
	public static void display(int[] in)
	{
		for(int i=0;i<in.length;i++)
			System.out.print(in[i]);
		System.out.println();
	}
	private static void aux_BS(int d, int n, int[] in) {
		// TODO Auto-generated method stub
		if(d==n)
		{
			display(in);
			return;
		}
		for(int i=0;i<=1;i++)
		{
			in[d]=i;
			aux_BS(d+1, n, in);
		}

	}

}
