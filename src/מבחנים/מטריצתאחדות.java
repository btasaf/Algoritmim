package מבחנים;

import LIS.MyLibrary;

public class מטריצתאחדות {
	public static void submat1(int[][] mat){
		int l=mat.length;
		int[][] m=new int[l][l];
		int size=0,x=0,y=0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j]=mat[i][j];
			}
		}
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m.length; j++) {
				int a=m[i-1][j];
				int b=m[i-1][j-1];
				int c=m[i][j-1];
				if(mat[i][j]!=0)
					m[i][j]=Math.min(Math.min(a, b), c)+1;
				if(m[i][j]>size){
					x=i;
					y=j;
					size=m[i][j];
				}
			}
			System.out.println("size: "+size+"\n(x,y):("+x+","+y+")");
		}
		MyLibrary.printIntMatrix(mat);
		System.out.println();
		MyLibrary.printIntMatrix(m);
	}
	public static void main(String[] args) {
		int[][] mat={{1,1,0},{1,1,0},{0,1,1}};
		submat1(mat);

	}

}
