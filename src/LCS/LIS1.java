package LCS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import submatrix.MyLibrary;

public class LIS1 {
	int teta;
	int[] arr;
	int[] index;
	int numoflis,lenoflis;
	int big,bigindex;
	public LIS1(int[] a,int t){
		teta=t;
		arr=a;
		index=new int[arr.length];
		lenoflis=lislength(arr);

	}
	public void printAllLIS(){
		ArrayList<Vector<Integer>> ens=allCombinations(arr);
		int sizeoflis=0;
		int t=teta;
		while(!ens.isEmpty()&&t>0){
			Vector<Integer> temp=ens.remove(ens.size()-1);
			if(issort(temp)&&!ens.isEmpty()){
				sizeoflis++;
				printvec(temp);
				t--;
			}
		}
		numoflis=sizeoflis;
	}
	public void printvec(Vector<Integer> v){
		while(!v.isEmpty()){
			System.out.print(v.remove(0)+" ");
		}
		System.out.println();
	}
	public boolean issort(Vector<Integer> v){
		boolean back=true;
		for (int i = 1; i <v.size(); i++) {
			if(v.get(i)<v.get(i-1))back=false;
		}
		return back;
	}
	public int lislength(int[] arr){
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
	public  int binarySearchBetween(int[] arr,int end,int val){
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
	public  int plus1(int[] arr,int count){
		int i=arr.length-1;
		boolean back=true;
		while( i>=0 && arr[i]==1){
			arr[i--] = 0;
			back=false;
		}
		if (i>=0){
			arr[i] = 1;
			count--;
		}

		return count;
	}
	private boolean isinlength(int[] a){
		int size=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==1)size++;
		}

		if(size==lenoflis)return true;
		else return false;
	}
	public  ArrayList<Vector<Integer>> allCombinations(int[] X){
		int count = (int)Math.pow(2, X.length);
		ArrayList<Vector<Integer>> list=new ArrayList<Vector<Integer>>();
		int bin[] = new int[X.length];
		while (count>=0){
			count=plus1(bin,count);
			while(!isinlength(bin)){
				count=plus1(bin,count);
			}
			Vector<Integer> temp = new Vector<>();
			for (int j=0; j<X.length; j++){
				if (bin[j] == 1) temp.add(X[j]); 
			}
			
		
			list.add(temp);
		}
		return list;
	}
	public void printLengthLIS(){
		System.out.println(lenoflis);
	}
	public void printNumOfLIS(){
		System.out.println(numoflis);
	}


	
	public static void main(String[] args) {
		int []a1 = {2,4,90,-3,-2,-1,-10,-9,-8};
		int[] a2={4,3,1,6,2,8,5,3};
		int []a4 = {2,-3,4,90,-2,-1,-10,-9,-8};
		int[] a3={20,21,22,15,16,17,18,10,11,12,13};
		int[] a5={67, 20, 63, 15, 27, 14, 76, 11, 14, 8, 12, 44, 36, 72, 34, 55, 99, 24, 61, 44};
		LIS1 a=new LIS1(a5,100);
		a.printAllLIS();
		a.printLengthLIS();
		a.printNumOfLIS();
		

	}

}
