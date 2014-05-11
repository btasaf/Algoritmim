package LCS;

import java.util.Arrays;

import submatrix.MyLibrary;


	public final class LongestICommonSeq {
		
		public static int findElement(int beg, String str, char elem){
			int index = -1;
			boolean flag = true;
			for (int i=beg; i<str.length()&&flag; i++){
				if (str.charAt(i)==elem){
					index = i;
					flag = false;
				}
			}
			return index;
		}
		public static String greedy(String X, String Y){//חמדני  o(n*m)
			String res = "";
			int ind = 0, index = 0, beg = 0;
			while (ind < X.length()){
				index = findElement(beg, Y, X.charAt(ind));
				if (index != -1){
					res = res + X.charAt(ind);
					beg = index+1;
				}
				ind = ind + 1;
			}
			return res;
		}
		/**
		 * The greedy2 algorithm 
		 * @param X - the first string
		 * @param Y - the second string
		 * @return string which contains the max 
		 *         longest common sequence
		 *  The greedy2 algorithm uses help array of letters
		 */
		public static String greedy2(String X, String Y){//חמדני  o(n+m)
			String res = "";
			int ind = 0, index = 0, beg = 0;
			int letters[] = new int[26];
			for (int i=0; i<X.length(); i++){
				int place = (int)(X.charAt(i)-'a');
				letters[place]++;
			}
			while (ind < X.length()){
				char x = X.charAt(ind);
				int place = (int)(x-'a');
				if (letters[place] > 0){
					index = findElement(beg, Y, x);
					if (index != -1){
						res = res + X.charAt(ind);
						beg = index+1;
						letters[place]--;
					}
					ind = ind + 1;
				}
			}
			return res;
		}
		
		////////////// FULL SEARCH // חיפוש שלם o(2^(n+m))
		public static void plus1(int[] arr){
			int i=arr.length-1;
			while( i>=0 && arr[i]==1){
				arr[i--] = 0;
			}
			if (i>=0) arr[i] = 1;
		}
		public static void checkPlus1(){
			int n = 4, count = (int)Math.pow(2, n);
			int arr[] = new int[n];
			for (int i=0; i<count; i++){
				plus1(arr);
				System.out.println(Arrays.toString(arr)); 
			}
		}	
		public static String[] allCombinations(String X){
			int count = (int)Math.pow(2, X.length());
			String [] list = new String[count];
			int bin[] = new int[X.length()];
			for (int i=0; i<count; i++){
				plus1(bin);
				String t = "";
				for (int j=0; j<X.length(); j++){
					if (bin[j] == 1) t = t + X.charAt(j); 
				}
				list[i] = t;
			}
			return list;
		}
		public static boolean findSubstr(String small, String big){
			int len = small.length(), index = 0;
			boolean ans = true;
			for (int i=0; ans && i<small.length(); i++){
				index = findElement(index, big, small.charAt(i));
				if (index == -1) ans = false;
			}
			return ans;
		}

		public static String fullSearch(String X, String Y){
			String ans = "", sSmall = X, sLong = Y;
			if (X.length() > Y.length()){
				sSmall = Y;
				sLong = X;
			}
			String [] t = allCombinations(sSmall);
			for (int i=0; i<t.length; i++) {
				if (findSubstr(t[i], sLong)){
					if (t[i].length() > ans.length()) ans = t[i];
				}
			}
			return ans;
		}
		

	 static class LongestCommonSequence2 {
	// build matrix of numbers
		public static int[][] buldMatrix(char[] X, char [] Y) {
			int row = X.length+1,  col = Y.length+1;
			int mat[][] = new int[row][col]; 
			int i=0, j=0;
	// first column
			for (i=0; i<row; i++) mat[i][0]=0;
	// first row
			for (j=0; j<col; j++) mat[0][j]=0;
	// Matrix Interior 
			for (i=1; i<row; i++) {
				for (j=1; j<col; j++) {
					if (X[i-1]==Y[j-1]){
						mat[i][j] = mat[i-1][j-1] + 1;
					}
					else{
						mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
					}
				}
			}
			return mat;
		}
	// the function returns max common sequence length
		public static int maxSeqLength(char[] X, char [] Y){
			int row = X.length+1,  col = Y.length+1;
			int mat[][] = buldMatrix(X, Y); 
			return mat[row-1][col-1];
		}
	// the function returns max common sequence
		public static char[] maxSequence(char[] X, char [] Y){
			int mat[][] = buldMatrix(X, Y); 
			MyLibrary.printIntMatrix(mat);
			int row = mat.length;
			int col = mat[0].length;
			int seqLength = mat[row-1][col-1];
			char result[] = new char[seqLength];
			int i=row-1, j=col-1, count=seqLength-1;
//			while (i>0 && j>0){
			while (count>=0){
				if (X[i-1]==Y[j-1]){
					result[count--]=X[i-1];
					i = i - 1;
					j = j - 1;
				}
				else if (mat[i][j]==mat[i][j-1]) j--;
				else  i--;
			}
			return result;
		}
	 }
	}


