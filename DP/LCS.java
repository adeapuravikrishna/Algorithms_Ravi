public class LCS
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCSi("ahbhchgbjnjed","abcde");

	}

	
	private static void LCSi(String s1,String s2)
	{
		int s1_len=s1.length();//n
		int s2_len=s2.length();//m
		int[][] mem=new int[s2_len+1][s1_len+1];
		for(int i=0;i<=s1_len;i++)
			mem[0][i]=0;
		for(int i=0;i<=s2_len;i++)
			mem[i][0]=0;
		for(int i=1;i<=s2_len;i++)
		{
			for(int j=1;j<=s1_len;j++)
			{
				if(s1.charAt(j-1)==s2.charAt(i-1))
					mem[i][j]=1+mem[i-1][j-1];
				else
					mem[i][j]=Math.max(mem[i-1][j], mem[i][j-1]);
			}
		}
		System.out.println(mem[s2_len][s1_len]);
		for(int i=0;i<=s2_len;i++)
		{
			for(int j=0;j<=s1_len;j++)
			{
				System.out.print(mem[i][j]+" ");
			}
			System.out.println();
		}
	}



}

