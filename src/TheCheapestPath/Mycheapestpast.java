package TheCheapestPath;

public class Mycheapestpast {

	static int n;
	static node[][] mat;

	public Mycheapestpast(int n){
		this.n=n;
		mat=new node[n][n];
	}

	public int priceofcheapestpatht(){
		mat[0][0].price=0;
		mat[0][0].r=1;
		for(int i=1;i<n;i++){
			mat[i][0].price=mat[i-1][0].price+mat[i-1][0].y;
			mat[0][i].price=mat[0][i-1].price+mat[0][i-1].x;
			mat[i][0].r=1;
			mat[0][i].r=1;
		}
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				int yy=mat[i-1][j].price+mat[i-1][j].y;
				int xx=mat[i][j-1].price+mat[i][j-1].x;
				mat[i][j].price=Math.min(yy,xx );
				if(xx==yy){
					mat[i][j].r=mat[i-1][j].r+mat[i][j-1].r;
				}
				else
				{
					if(xx>yy)mat[i][j].r=mat[i-1][j].r;
					else mat[i][j].r=mat[i][j-1].r;
				}
			}
		}
		return mat[n-1][n-1].price;
	}
	public void printmat(){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j].price+" ");
			}
			System.out.println();
		}
	}
	public void printmatpath(){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				printnodepath(i, j);
				System.out.println();
			}
			System.out.println();
		}
	}
	public void intmatofnodes(){
		mat[0][0]=new node(1,3);

		mat[0][1]=new node(8,4);
		mat[0][2]=new node(3,8);
		mat[0][3]=new node(0,4);

		mat[1][0]=new node(2,5);
		mat[1][1]=new node(5,11);
		mat[1][2]=new node(3,1);
		mat[1][3]=new node(0,2);

		mat[2][0]=new node(4,10);
		mat[2][1]=new node(3,1);
		mat[2][2]=new node(1,4);
		mat[2][3]=new node(0,8);

		mat[3][0]=new node(2,0);
		mat[3][1]=new node(3,0);
		mat[3][2]=new node(5,0);
		mat[3][3]=new node(0,0);
	}

	public static void makeindex(){

		makeindex(n-1,n-1);
	}
	public static node makeindex(int i,int j){
		mat[i][j].pname=new String[mat[i][j].r];
		mat[i][j].pname[0]="";
		mat[i][j].isinpath=true;
		if(i==0||j==0){
			if(i==0&&j==0) mat[i][j].pname[0]="";
			else if(i==0)mat[i][j].pname[0]=(makeindex(i,j-1)).pname[0]+"1";
			else if(j==0)mat[i][j].pname[0]=(makeindex(i-1,j)).pname[0]+"0";
		}
		else{
			if(mat[i][j].pname.length==1){
				if(mat[i][j].price-mat[i-1][j].y==mat[i-1][j].price)
					mat[i][j].pname[0]=(makeindex(i-1,j)).pname[0]+"0";
				else
					mat[i][j].pname[0]=(makeindex(i,j-1)).pname[0]+"1";
			}
			else{
				if(mat[i][j].price-mat[i-1][j].y==mat[i-1][j].price&&mat[i][j].price-mat[i][j-1].x==mat[i][j-1].price){
					for(int k=0;k<mat[i-1][j].r;k++){
						mat[i][j].pname[k]=(makeindex(i-1,j)).pname[k]+"0";
					}
					for(int s=0, k=mat[i-1][j].r;k<mat[i][j].r;s++,k++){
						mat[i][j].pname[k]=(makeindex(i,j-1)).pname[s]+"1";
					}
				}
				else if(mat[i][j].price-mat[i][j-1].x==mat[i][j-1].price){
					for(int k=0;k<mat[i][j-1].r;k++){
						mat[i][j].pname[k]=(makeindex(i,j-1)).pname[k]+"1";
					}
				}
				else if(mat[i][j].price-mat[i-1][j].y==mat[i-1][j].price){
					for(int k=0;k<mat[i-1][j].r;k++){
						mat[i][j].pname[k]=(makeindex(i-1,j)).pname[k]+"0";
					}
				}

			}
		}

		return mat[i][j];
	}
	public static void main(String[] argq){
		Mycheapestpast try1=new Mycheapestpast(4);
		try1.intmatofnodes();

		System.out.println("the cheapest price is: "+try1.priceofcheapestpatht());
		System.out.println("number of wayes is: "+try1.mat[try1.n-1][try1.n-1].r);
		try1.printmat();
		try1.makeindex();
		try1.printmatpath();


	}
	public static void printnodepath(int i,int j){
		if(mat[i][j].isinpath){
			System.out.println("the index ("+i+","+j+") path is:");
			for(int k=0;k<mat[i][j].r;k++){
				System.out.print(mat[i][j].pname[k]);
				System.out.print(",");
			}
			System.out.println();
		}
		else System.out.println("the index ("+i+","+j+") is not in the path\n");

	}

	public class node{
		int x,y,price,r;
		boolean isinpath;
		String[] pname;
		public node(int x,int y){
			this.x=x;
			this.y=y;
			price=0;
			r=0;
			isinpath=false;
		}
	}
}
