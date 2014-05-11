package מבחנים;

import LIS.MyLibrary;

public class מחרוזתארוכהביותר {

	public static void lcs(String x,String y){
		int xlen=x.length(),ylen=y.length();
		int[][] mat=new int[xlen+1][ylen+1];
		int i=1,j=1;
		for ( i = 1; i < mat.length; i++) {
			for ( j = 1; j < mat[0].length; j++) {
				if(x.charAt(i-1)==y.charAt(j-1)){
					mat[i][j]=mat[i-1][j-1]+1;
				}
				else{
					mat[i][j]=Math.max(mat[i][j-1],mat[i-1][j]);
				}
			}
		}
		i--;
		j--;
		System.out.println("length of the longest sub="+mat[i][j]);
		String back="";
		boolean flag=true;
		while(flag){
			if(x.charAt(i-1)==y.charAt(j-1)){
				back=x.charAt(i---1)+back;
				j--;
			}
			else if(mat[i][j]==mat[i][j-1])j--;
			else i--;
			if(mat[i][j]==0)flag=false;
		}
		System.out.println("the sub="+back);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="asaq";
		String b="asas";
		lcs(a,b);
	}

}
