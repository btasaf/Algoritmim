package LIS;

import submatrix.MyLibrary;

public class MyLis {
	public static int binarySearchBetween(int[] arr,int end,int val){
		if(val<arr[0])return 0;
		if(val>arr[end])return end+1;
		int high=end,low=0;
		while(high>=low){
			int mid=(low+high)/2;
			if(low==high)return low;
			if(val==arr[mid])return mid;
			else if(val>arr[mid])low=mid+1;
			else high=mid;
		}
		

		return -1;
	}
	public static int lislength(int[] arr){
		int[] d=new int[arr.length];
		int index,end=0;
		d[0]=arr[0];
		for(int i=1;i<arr.length;i++){
			index=binarySearchBetween(d, end, arr[i]);
			if(index>end)d[++end]=arr[i];
			else d[index]=arr[i];
				
		}
		return end+1;
	}
	public static int[] lis(int[] arr){
		int[] d=new int[arr.length];
		int[][] mat=new int[arr.length][arr.length];
		int end=0,index=0;
		d[0]=arr[0];
		mat[0][0]=arr[0];
		for(int i=1;i<arr.length;i++){
			index=binarySearchBetween(d, end, arr[i]);
			System.out.println(index);
			mat[index][index]=arr[i];
			for(int j=0;j<index;j++){
				mat[index][j]=mat[index-1][j];
				d[j]=mat[j][j];
			}
			d[index]=arr[i];
			if(index>end)end++;
		}
	//	MyLibrary.printIntMatrix(mat);
		int[] back=new int[end+1];
		for(int i=0;i<back.length;i++){
			back[i]=mat[index][i];
		}
		MyLibrary.printIntegerArray(back);
		
		return arr;
	}
	public static void main(String[] argq){
	int[] ccc={ 1 , 100 , 2 , 3 , 0 , 101 , 107 };
	System.out.println(lislength(ccc));
	lis(ccc);
	}
}
