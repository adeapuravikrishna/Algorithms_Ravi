
public class towers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		towers(10);
		System.out.println("Total number of moves are "+count);

	}

	private static void towers(int n) {
		// TODO Auto-generated method stub
		char a,b,c;
		aux_towers(n,"A","B","C");
		
	}
	static int count=0;
	private static void aux_towers(int n, String from, String via, String to) {
		// TODO Auto-generated method stub
		if(n==1)
		{
			System.out.println("disc moved from "+from+" to "+to);
			count++;
		}
		else
		{
			aux_towers(n-1, from, to, via);
			System.out.println("disc moved from "+from+" to "+to);
			count++;
			aux_towers(n-1, via, from, to);
		}
		
	}

}
