package LIS;

import submatrix.MyLibrary;

public class temp {
	public static int[] lis(int[] arr){
		int[][] mat=new int[arr.length][arr.length];
		mat[0][0]=arr[0];
		int[] d=new int[arr.length];
		d[0]=arr[0];
		int index=0,end=0;
		for (int i = 1; i < mat.length; i++) {

			index=bsb(d,end,arr[i]);
			mat[index][index]=arr[i];

			for (int j = 0; j < index; j++) {

				mat[index][j]=mat[index-1][j];
				d[j]=mat[j][j];
			}
			d[index]=arr[i];
			if(index>end)end++;
		}
		int[] back=new int[end+1];
		for(int i=0;i<back.length;i++){
			back[i]=mat[index][i];
		}
		return back;
	}
	public static int bsb(int[] arr,int end,int val){
		if(arr[0]>val)return 0;
		if(arr[end]<val)return end+1;
		int high=end;
		int low=0;
		int mid;
		while(low<=high){
			mid=(low+high)/2;
			if(high==low)return low;
			if(arr[mid]==val)return mid;
			if(val>arr[mid])low=mid+1;
			else high=mid;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] ccc={ 1 , 100 , 2 , 3 , 0 , 101 , 107 };
		MyLibrary.printIntegerArray(lis(ccc));
	}

}
