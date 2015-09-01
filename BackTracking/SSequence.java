
public class SSequence {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateStringSequence("ABC");
	}

	private static void generateStringSequence(String string) {
		// TODO Auto-generated method stub
		char[] out=new char[string.length()];
		aux_generate_ss(0,string.toCharArray(),out);

	}
	public static void display(char[] out)
	{
		for(int i=0;i<out.length;i++)
			System.out.print(out[i]);
		System.out.println();
	}
	private static void aux_generate_ss(int d, char[] in,char[] out) {
		// TODO Auto-generated method stub
		if(d==in.length)
		{
			display(out);
			return;
		}
		for(int i=0;i<in.length;i++)
		{
			out[d]=in[i];
			aux_generate_ss(d+1, in, out);
		}

	}

}
