package submatrix;

public class Mysubmatrixof1 {
	public static void submatrixof1(int[][] mat){
		int maxdim=0,maxi=0,maxj=0;
		int [][]a=new int[mat.length][mat[0].length];
		boolean foundmax=false;
		for (int i = 0; i < mat.length; i++) {
			if(!foundmax&&mat[i][0]==1){
				a[i][0]=mat[i][0];
				maxj=0;
				maxi=i;
				maxdim=1;
				foundmax=true;
			}
			a[i][0]=mat[i][0];
		}
		for (int j = 0; j < mat[0].length; j++) {
			if(!foundmax&&mat[0][j]==1){
				a[0][j]=mat[0][j];
				maxi=0;
				maxj=j;
				maxdim=1;
				foundmax=true;
			}
			a[0][j]=mat[0][j];
		}
		
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat.length; j++) {
				if(mat[i][j]==1){
					a[i][j]=min3(mat[i-1][j-1],mat[i][j-1],mat[i-1][j])+1;
					if(a[i][j]>maxdim){
						maxi=i;
						maxj=j;
						maxdim=a[i][j];
					}
				}
				else
					a[i][j]=mat[i][j];
			}
		}
		MyLibrary.printIntMatrix(mat);
		System.out.println();
		MyLibrary.printIntMatrix(a);
		System.out.println("maxdim is: "+maxdim+" in index (x,y): ("+(maxi+1)+","+(maxj+1)+")");
		
	}

	private static int min3(int a, int b, int c) {
		int min =a;
		if(a>b)min=b;
		if(b>c)min=c;
		return min;
	}
	
	
	public static void main(String[] argq){
		int[][] abc=MyLibrary.randomMatrixOf01(6, 6);
		submatrixof1(abc);
	}
}
