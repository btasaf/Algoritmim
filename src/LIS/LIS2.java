package LIS;

import submatrix.MyLibrary;

public class LIS2 {
	int teta;
	int[] arr;
	int numoflis,lenoflis;
	int big,bigindex;

	
	int end;
	int in;
	public LIS2(int[] a,int t){
		teta=t;
		arr=a;
		numoflis=0;
		lenoflis=0;

		int[][] res=new int[teta][arr.length];
		int[] d=new int[arr.length];

		int[][] mat=new int[arr.length][arr.length];
		end=0;
		mat[0][0]=arr[0];
		d[0]=arr[0];
		big=0;bigindex=0;
		in=1;
		makelis(arr,mat,res,d);
	}
	public void makelis(int[] arr,int[][] mat,int[][] res,int[] d) {
		if(big==teta)return;
		int c=1;
		for(int i=in;i<arr.length;i++){
			if(arr[i]<arr[i-1]&&(i==1||arr[i]>arr[i-2])){
				int[] one=new int[arr.length-1];
				int[] two=new int[arr.length-1];
				int q=0;
				while(q<(i-1)){
					one[q]=arr[q];
					two[q]=arr[q++];
				}
				one[q]=arr[i-1];
				two[q++]=arr[i];
				while(q<one.length){
					one[q]=arr[q+1];
					two[q]=arr[q+++1];
				}
				MyLibrary.printIntegerArray(one);
				MyLibrary.printIntegerArray(two);
				in++;
				System.out.println("i run "+c+++" times!");
				makelis(two,mat,res,d);
				makelis(one,mat,res,d);
				
			}
			else{
				int index=binarySearchBetween(d, end, arr[i]);
				mat[index][index]=arr[i];
				for(int j=0;j<index;j++){
					mat[index][j]=mat[index-1][j];
					d[j]=mat[j][j];
				}
				d[index]=arr[i];

				System.out.println("i run "+c+++" times!");
				if(index>end){
					end++;
					bigindex=end;
					big=0;
				}
				//	System.out.println("big: "+big+"\nend: "+end+"\nindex: "+index+"\nbigindex: "+bigindex);

				addtores(arr,index,mat,res);
				//MyLibrary.printIntMatrix(mat);
				//System.out.println();
				MyLibrary.printIntMatrix(res);
				System.out.println();
				numoflis=big;
				lenoflis=bigindex+1;
			}
		}
	}
	private void addtores(int[] arr,int index,int[][] mat,int[][] res){
		if((bigindex==index||index==end)&&big!=teta){
			for(int j=0;j<=bigindex&&big<res.length;j++){
				res[big][j]=mat[index][j];
			}
			big++;
		}
	}
	public void printLengthLIS(){
		System.out.println(lenoflis);
	}
	public void printNumOfLIS(){
		System.out.println(numoflis);
	}
	private static int binarySearchBetween(int[] arr,int end,int val){
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
	public static void main(String[] args) {
		int []a1 = {2,4,90,-3,-2,-1,-10,-9,-8};
		int[] a2={1,3,2,4,13,4,15};
		int []a4 = {2,-3,4,90,-2,-1,-10,-9,-8};
		int[] a3={20,21,22,15,16,17,18,10,11,12,13};
		int[] a5={1,2,3,4,5,7,6,8,9,10};
		LIS2 a=new LIS2(a3,5);
		a.printLengthLIS();
		a.printNumOfLIS();
		//a.printAllLIS();
	}

}
