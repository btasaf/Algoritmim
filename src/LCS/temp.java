package LCS;
import java.util.*;

import submatrix.MyLibrary;
public class temp {
	public static String lcsgreedy(String x,String y){
		String ens="";
		int beg=0,index;
		for (int i = 0; i < x.length(); i++) {
			index=y.indexOf(""+x.charAt(i), beg);
			if(index!=-1){
				beg=index+1;
				ens+=x.charAt(i);
			}
		}
		return ens;
	}
	public static String lcsfull(String x,String y){
		String[] list=allsubstrings(x);
		String ens="";
		int size=0;
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]); 
			if(is_sub_in(y,list[i])&&list[i].length()>size){
				size=list[i].length();
				ens=list[i];
			}
		}
		return ens;
	}
	public static boolean is_sub_in(String a,String isin){
		boolean back=true;
		int index=0;
		for (int i = 0; back&&i < isin.length(); i++) {
			index=a.indexOf(isin.charAt(i), index);
			if(index==-1)back=false;
		}
		return back;
	}
	public static String[] allsubstrings(String x){
		String[] list=new String[(int) Math.pow(2, x.length())];
		for (int i = 0; i < list.length; i++) list[i]="";

		int[] bin=new int[x.length()];
		for (int i = 0; i < bin.length; i++) bin[i]=0;

		for (int i = 0; i < list.length; i++) {
			plus1(bin);
			for (int j = bin.length-1; j >= 0; j--) {
				if(bin[j]==1)
					list[i]=x.charAt(j)+list[i];
			}
		}

		return list;
	}
	public static void plus1(int[] x){
		int i= x.length-1;
		while(i>=0&&x[i]==1){
			x[i--]=0;
		}
		if(i>=0)x[i]=1;
	}
	public static String lcsmat(String x,String y){
		int[][] mat=fillmat(x, y);
		String back="";
		int iy=y.length(),ix=x.length();
		while(iy>0&&ix>0){
			if(x.charAt(ix-1)==y.charAt(iy-1)){
				back=x.charAt(ix-1)+back;
				ix--;
				iy--;
			}
			else if(mat[ix][iy]==mat[ix][iy-1])
				iy--;
			else
				ix--;
		}
		return back;
	}
	
	public static int[][] fillmat(String y,String x){
		int leny=y.length()+1,lenx=x.length()+1;
		int[][] mat=new int[leny][lenx];
	//	for (int i = 0; i < lenx; i++)mat[0][i]=0;
	//	for (int i = 0; i < leny; i++)mat[i][0]=0;
		for (int i = 1; i < leny; i++) {
			for (int j = 1; j < lenx; j++) {
				if(y.charAt(i-1)==x.charAt(j-1))
					mat[i][j]=mat[i-1][j-1]+1;
				else
					mat[i][j]=Math.max(mat[i][j-1], mat[i-1][j]);
			}
		}
		MyLibrary.printIntMatrix(mat);
		return mat;
	}

	public static void main(String[] args) {
		String a="asaf",b="adg";
		System.out.println(lcsmat(a, b));
	}

}
