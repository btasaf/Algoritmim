package fibonacci;


public class temp {
	public static long fibo(int n){
		long[][] ens={{0,1},{1,1}};
		long[][] mat={{0,1},{1,1}};
		while(n>0){
			if(n%2==1){
				ens=Dualmat(ens,mat);
				n=n-1;
			}
			mat=Dualmat(mat,mat);
			n=n/2;
		}
		return ens[0][0];
	}
	public static long fiborec(int n){
		long[][] back={{0,1},{1,1}};
		long[][] t=fiborec(back,n);
		return t[0][0];
	}
	public static long[][] fiborec(long[][] mat,int n){
		long[][] back={{0,1},{1,1}};
		if(n==0)return back;
		if(n%2==0)return fiborec(Dualmat(mat,mat),n/2);
		 return Dualmat(mat,fiborec(Dualmat(mat,mat),(n-1)/2));
	}
	public static long[][] Dualmat(long[][] a,long[][]b){
		int len=a.length;
		long[][] back=new long[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				back[i][j]=0;
				for (int k = 0; k < len; k++) {
					back[i][j]=back[i][j]+a[i][k]*b[k][j];
				}
			}
		}
		return back;
	}
	public static void main(String[] args) {
		System.out.println(fibo(91));
	}

}
