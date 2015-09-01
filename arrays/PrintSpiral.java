
public class PrintSpiral {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] a={{'a','b','c','d'},
				{'1','2','3','4'},
				{'p','q','r','s'}
		};
		print_spiral(a,3,4);
	}
	public static void print_spiral(char[][] a,int row,int col)
	{
		int rowStart=0,rowEnd=row-1,colStart=0,colEnd=col-1,i;
		while(rowStart<=rowEnd&&colStart<=colEnd)
		{
			for(i=colStart;i<colEnd;i++)
				System.out.print(a[rowStart][i]);
			for(i=rowStart;i<rowEnd;i++)
				System.out.print(a[i][colEnd]);
			for(i=colEnd;i>colStart;i--)
				System.out.print(a[rowEnd][i]);
			for(i=rowEnd;i>rowStart;i--)
				System.out.print(a[i][colStart]);
			rowStart++;
			colStart++;
			rowEnd--;
			colEnd--;
		}
		

	}
}
