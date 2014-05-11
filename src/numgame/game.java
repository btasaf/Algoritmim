package numgame;

public class game {
	public static int i,j;
	public static int[] createArr(int num){
		int[] ans=new int[num];
		for(int i=0;i<ans.length;i++){
			ans[i]=(int)(Math.random()*10);
		}
		return ans;
	}
	public static int[][] CreateMatrix(int[] arr){
		int[][] matrix=new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++){
			matrix[i][i]=arr[i];
		}
		return matrix;
	}
	public static void FillTheMatrix(int[][] matrix,int[] arr){
		for(int i=matrix.length-1;i>=0;i--){
			for(int j=i+1;j<matrix.length;j++){
				matrix[i][j]=Math.max((arr[i]-matrix[i+1][j]),(arr[j]- matrix[i][j-1]));
			}
		}
	}
	public static int OneTurn(int[] arr,int[][] matrix){
		System.out.println("j="+j+"\n"+"i="+i);
		System.out.println(matrix[i+1][j]+"\n");
		if (matrix[i][j]==(arr[i]-matrix[i+1][j])){
			return arr[i++];
		}
		else {
			return arr[j--];
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr=createArr(6);
		int[] arr={1,3,6,1,3,6};
		System.out.print("|");
		for(int i=0;i<arr.length-1;i++){
			System.out.print(arr[i]+" ,");
		}
		System.out.println(arr[i]+"|");
		int[][] matrix =CreateMatrix(arr);
		FillTheMatrix(matrix,arr);
		PrintMatrix(matrix);
		int comp1 = 0,comp2=0;
		j=matrix.length-1;i=0;
		for (int k=0;k<6;k++){
			if (k%2==0){
				comp1=comp1+OneTurn(arr,matrix);
			}
			else {
				comp2=comp2+OneTurn(arr,matrix);
			}
		}
		System.out.println(comp1);
		System.out.println(comp2);
	}
	private static void PrintMatrix(int[][] m) {
		 int rows = m.length;
	        int columns = m[0].length;
	        String str = "|\t";

	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                str += m[i][j] + "\t";
	            }

	            System.out.println(str + "|");
	            str = "|\t";
	        }
		
	}
}
