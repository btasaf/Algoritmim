package מבחנים;

import LIS.MyLibrary;
import TheCheapestPath.Mycheapestpast.node;

public class דףמחרוזות {

	public static boolean ff(node[][] mat,int p,int q){
		int x=1,y=1;
		int nlx=Math.abs(p-mat.length),nly=Math.abs(q-mat[0].length);
		node[][] m=new node[nlx][nly];
		m[0][0]=new node(mat[p][q].x,mat[p][q].y);
		m[0][0].p=0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j]=new node(mat[p+i][q+j].x,mat[p+i][q+j].y);
					if(i==0&&j!=0)
					m[i][j].p=m[i][j-1].p+m[i][j-1].x;
					if(i!=0&&j==0)
						m[i][j].p=m[i-1][j].p+m[i-1][j].y;
			}
		}
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				m[i][j].p=Math.min(m[i-1][j].p+m[i-1][j].y, m[i][j-1].x+m[i][j-1].p);
				
			}
		}
		System.out.println();
		printmat(m);
		if(m[m.length-1][m[0].length-1].p+m[0][0].p==mat[mat.length-1][mat[0].length-1].p)return true;
		else
			return false;
	/*	mat[0][0].p=0;
		while(x<mat.length)mat[x][0].p=mat[x-1][0].p+mat[-1 +x++][0].y;
		while(y<mat[0].length)mat[0][y].p=mat[0][y-1].p+mat[0][-1 +y++].x;
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				mat[i][j].p=Math.min(mat[i-1][j].p+mat[i-1][j].y, mat[i][j-1].x+mat[i][j-1].p);
			}
		}
		rec(mat,mat.length-1,mat[0].length-1);
		printmat(mat);
	
					return (mat[p][q].isinpath);
*/
	}
	public static void printmat(node[][] mat){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j].p+" ");
			}
			System.out.println();
		}
	}
	public static int rec(node[][] mat,int x,int y){
		System.out.println("(x,y)= ("+x+","+y+")");
		if(x==0&&y==0){
			mat[x][y].isinpath=true;
			return mat[x][y].p;
		}
		if(x==0||y==0){
			if(x==0){
				mat[x][y].isinpath=true;
				return rec(mat,x,y-1);
			}
			else{
				mat[x][y].isinpath=true;
				return rec(mat,x-1,y);
			}
		}
		if(mat[x-1][y].p+mat[x][y].x==mat[x][y-1].p+mat[x][y-1].y){
			mat[x][y].isinpath=true;
			return Math.min(rec(mat,x-1,y), rec(mat,x,y-1));
		}
		if(mat[x-1][y].p+mat[x-1][y].x>mat[x][y-1].p+mat[x][y-1].y){
			mat[x][y].isinpath=true;
			return rec(mat,x,y-1);
		}
		else{
			mat[x][y].isinpath=true;
			return rec(mat,x-1,y);
		}
	}

	static class node{
		int x;
		int y;
		int p;
		boolean isinpath;
		public node(int a,int b){
			x=a;
			y=b;
			p=0;
			isinpath=false;
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
		System.out.println(ff(mat,0,3));

	}
}
