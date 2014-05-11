package מבחנים;

import java.util.Stack;

import LIS.MyLibrary;
import TheCheapestPath.temp.node;

public class maxmaxindu {

	public static void maxmax(node[][] mat){
		mat[0][0].p=0;
		for (int i = 1; i < mat.length; i++)mat[i][0].p=mat[i-1][0].p+mat[i-1][0].y; 
		for (int j = 1; j < mat[0].length; j++)mat[0][j].p=mat[0][j-1].p+mat[0][j-1].x;
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if(mat[i][j-1].p+mat[i][j-1].x==mat[i-1][j].p+mat[i-1][j].y){
					mat[i][j].p=mat[i][j-1].p+mat[i][j-1].x;
					mat[i][j].r=mat[i][j-1].r+mat[i-1][j].r;
				}
				else if(mat[i][j-1].p+mat[i][j-1].x>mat[i-1][j].p+mat[i-1][j].y){
					mat[i][j].p=mat[i-1][j].p+mat[i-1][j].y;
					mat[i][j].r=mat[i-1][j].r;
				}
				else{
					mat[i][j].p=mat[i][j-1].p+mat[i][j-1].x;
					mat[i][j].r=mat[i][j-1].r;
				}
			}
		}
		System.out.println("number of wayes is: "+mat[mat.length-1][mat[0].length-1].r);
		int[] ch=optimal(mat, mat.length-1, mat[0].length-1, mat[mat.length-1][mat[0].length-1].r, 0, 0);
		MyLibrary.printIntegerArray(ch);

	}
	public static int[] optimal(node[][] mat,int i,int j,int size,int t,int rorl){
		if(i==0&&j==0){
			int[] back=new int[1];
			back[0]=t;
			System.out.println(t);
			return back;
		}
		else if(i==0||j==0){
			if(j==0){
				if(rorl==2){
					return optimal(mat, i-1, j, size,t++,1);
				}
				else{
					return optimal(mat, i-1, j, size,t,1);
				}
			}
			else{
				if(rorl==1){
					return optimal(mat, i, j-1, size,t++,2);
				}
				else{
					return optimal(mat, i, j-1, size,t,2);
				}

			}
		}
		int[] list=new int[size];
		int p=mat[i][j].p;
		int px=mat[i][j-1].p+mat[i][j-1].x;
		int py=mat[i-1][j].p+mat[i-1][j].y;
		
		if(p==px&&p==py){
			int[] a=new int[mat[i][j-1].r];
			int[] b=new int[mat[i-1][j].r];
			if(rorl==1){
				
				a=optimal(mat, i, j-1,mat[i][j-1].r,t++,2 );
				b=optimal(mat, i-1, j,mat[i-1][j].r,t,1 );
			}
			else{
				a=optimal(mat, i, j-1,mat[i][j-1].r,t,2 );
				b=optimal(mat, i-1, j,mat[i-1][j].r,t++,1 );	
			}
			int ai=0,bi=0,k=0;
			while(ai<a.length-1)list[k++]=a[ai++];
			while(bi<b.length-1)list[k++]=b[bi++];
			return list;
		}
		else if(p==px){
			if(rorl==1){
			return optimal(mat, i, j-1, size,t,1);
			}
			else{
				return optimal(mat, i, j-1, size,t++,1);
			}
		}
		else{
			if(rorl==1){
			return optimal(mat, i-1, j, size,t++,2);
			}
			else{
				return optimal(mat, i-1, j, size,t,2);
			}
		}

	}
	static class node{
		int y,x;
		int p,r;
		public node(int x,int y){
			this.x=x;
			this.y=y;
			p=0;
			r=1;
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
		
		maxmax(mat);
	//	printmat(mat);

	}

}
