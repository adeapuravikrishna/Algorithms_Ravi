import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class TestClass {

	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		while(T!=0)
		{
			String ch=in.next();
			char[] input=ch.toCharArray();
			char[] output=new char[input.length];
			int[] count=new int[26];
			int[] count1=new int[26];
			int l=0;
			for(int i=0;i<input.length;i++)
			{
				count[input[i]-97]++;
				count1[input[i]-97]++;
			}
			Arrays.sort(count1);
			for(int i=0;i<count1.length;i++)
			{
				if(count1[i]!=0)
				{
					for(int j=0;j<count.length;j++)
					{
						if(count1[i]==count[j])
						{
							for(int k=0;k<count1[i];k++)
							{
								output[l++]=(char) (j+97);
								
							}
							count[j]=0;
							break;
						}
					}
				}
			}
			System.out.println(output);
			T--;
		}
	}

}
