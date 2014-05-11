package submatrix;

public class temp {

	public static int[][] submat1(int[][] mat){
		int[][] mat2=new int[mat.length][mat.length];
		for (int i = 0; i < mat2.length; i++) {
			mat2[i][0]=mat[i][0];
			mat2[0][i]=mat[0][i];
		}
		int big=0,bigi=0,bigj=0,i,j;
		for ( i = 1; i < mat2.length; i++) {
			for ( j = 1; j < mat2.length; j++) {
				if(mat[i][j]!=0){
					mat2[i][j]=min3(mat[i][j-1],mat[i-1][j],mat[i-1][j-1])+1;
					if(mat2[i][j]>big){
						big=mat2[i][j];
						bigi=i-big+1;
						bigj=j-big+1;
					}
				}
				else{
					mat2[i][j]=0;
				}

			}
		}
		MyLibrary.printIntMatrix(mat2);
			int[][] back=new int[big][big];
			for (int k = 0; k < back.length; k++) {
				for (int k2 = 0; k2 < back.length; k2++) {
					back[k][k2]=mat[bigi+k][bigj+k2];
					
				}
			}
			System.out.println();
			return back;
		}
		public static int min3(int i, int j, int k) {
			return Math.min(k, Math.min(i, j));
		}
		public static void main(String[] args) {
			int[][] c=MyLibrary.randomMatrixOf01(7, 7);
			MyLibrary.printIntMatrix(c);
			System.out.println();
			MyLibrary.printIntMatrix(submat1(c));
		}

	}
