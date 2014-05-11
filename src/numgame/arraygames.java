package numgame;

import LIS.MyLibrary;

public class arraygames {
	public static int mostprofet(int[][][] mat){
		int index=0;
		int mostprof=0;
		for (int i = 0; i < mat.length; i++) {
			if(mat[i][0][mat.length-1]>mostprof){
				index=i;
				mostprof=mat[i][0][mat.length-1];
			}
		}
		return index;
	}
	public static int[][][] makeop(int[] a){
		int s=a.length;
		int[][][] back=new int[s-1][s-1][s-1];
		for (int i = 0; i < s-1; i++) {
			int[] temp=Createarr(a,i);
			back[i]=CreateMatrix(temp);
			FillTheMatrix(back[i], temp);
		}
		printmat(back);
		System.out.println(mostprofet(back));
		return back;
	}
	public static int[] Createarr(int[] arr,int start){
		int[] back=new int[arr.length-1];
		int i=start+1;
		int ib=0;
		while(i<arr.length){
			back[ib++]=arr[i++];
		}
		i=0;
		while(i<start){
			back[ib++]=arr[i++];
		}
		return back;
	}
	public static void FillTheMatrix(int[][] matrix,int[] arr){
		for(int i=matrix.length-1;i>=0;i--){
			for(int j=i+1;j<matrix.length;j++){
				matrix[i][j]=Math.max((arr[i]-matrix[i+1][j]),(arr[j]- matrix[i][j-1]));
			}
		}
	}
	public static int[][] CreateMatrix(int[] arr){
		int[][] matrix=new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++){
			matrix[i][i]=arr[i];
		}
		return matrix;
	}
	public static void printmat(int[][][] m){
		for (int i = 0; i < m.length; i++) {
			MyLibrary.printIntMatrix(m[i]);
			System.out.println("\n\n");
		}
	}
	public static void main(String[] args) {
		int[] test={98,45,76,23,14};
		makeop(test);
	}

}
