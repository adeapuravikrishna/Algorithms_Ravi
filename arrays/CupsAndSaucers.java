
public class CupsAndSaucers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T[] = { 15, 20, 20, 22, 30, 89,95 };
		int S[] = { 10, 19, 26, 30, 35, 90, 95 ,95};
		System.out.println(getMaxNumberOfPairs(T, S));


	}
	public static int getMaxNumberOfPairs(int[] T,int[] S)
	{
		int count=0,i=0,j=0;
		while(i<T.length&&j<S.length)
		{
			if(T[i]<=S[j])
			{
				System.out.println("["+T[i]+" "+S[j]+"]");
				i++;
				j++;
				count++;
			}
			else
			{
				j++;
			}
		}


		return count;
	}

}
