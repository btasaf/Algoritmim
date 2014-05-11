package מבחנים;

import java.util.ArrayList;

import LIS.MyLibrary;

public class מחרוזתמשותפתארוכהביותר {
	public static String lcs(String a,String b){
		int al=a.length()+1,bl=b.length()+1;
		int[][] m=new int[al][bl];
		for (int i = 1; i < al; i++) {
			for (int j = 1; j < bl; j++) {
				if(a.charAt(i-1)==b.charAt(j-1))
					m[i][j]=m[i-1][j-1]+1;
				else
					m[i][j]=Math.max(m[i][j-1], m[i-1][j]);
			}
		}
		MyLibrary.printIntMatrix(m);
		int i=al-1,j=bl-1;
		String back="";
		while(m[i][j]!=0){
			if(a.charAt(i-1)==b.charAt(j-1)){
				back=a.charAt(i---1)+back;
				j--;
			}
			else if(m[i][j-1]>m[i-1][j])j--;
			else i--;
		}
		System.out.println(back);
		return back;
	}
	
	public static void main(String[] args) {
		String a="asafgg";
		String b="adgsfg";
		lcs(a,b);
		
		
	}

}
