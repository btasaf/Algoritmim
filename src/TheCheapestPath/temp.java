package TheCheapestPath;

import TheCheapestPath.Mycheapestpast.node;

public class temp {

	public static class node{
		int y,x,r,p;
		public node(int a,int b){
			x=a;
			y=b;
			r=1;
		}
		public int y(){
			return y+p;
		}
		public int x(){
			return x+p;
		}
	
	}
	public static int priceofcheapestpatht(node[][] mat){
		mat[0][0].p=0;
		for (int i = 1; i < mat.length; i++) {
			mat[i][0].p=mat[i-1][0].y();
		}
		for (int i = 1; i < mat[0].length; i++) {
			mat[0][i].p=mat[0][i-1].x();
		}
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				int xx=mat[i-1][j].y();
				int yy=mat[i][j-1].x();

				mat[i][j].p=Math.min(xx,yy);
				if(xx==yy)
					mat[i][j].r=mat[i-1][j].r+mat[i][j-1].r;
				else if(xx>yy)
					mat[i][j].r=mat[i][j-1].r;
				else
					mat[i][j].r=mat[i-1][j].r;
			}
		}
		return mat[mat.length-1][mat[0].length-1].p;
	}
	public static void printmat(node[][] mat){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j].p+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		node[][] mat=new node[4][4];
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
		
		System.out.println(priceofcheapestpatht(mat));
		printmat(mat);
	}

}
