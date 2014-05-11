package מבחנים;

import java.util.Stack;

import LIS.MyLibrary;

public class מלבניםשחורים {
//לא סיימתי!
	public static void blackmat(int[][] mat){
		nod[][] m=new nod[mat.length+1][mat[0].length+1];
		Stack<node> st = new Stack<node>();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j]=new nod();
			}
		}
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				//System.out.println("("+i+","+j+")");
				if(mat[i-1][j-1]!=0){
					m[i][j].up=m[i-1][j].up+1;
					m[i][j].left=m[i][j-1].left+1;

					if(i==m.length-1||j==m[0].length-1){
						if(i==m.length-1&&j==m[0].length-1){
							st.push(new node(Math.abs(m[i][j].up-i),Math.abs(m[i][j].left-j)));
						}
						else if(i==m.length-1){
							if(mat[i-1][j]==0){
								st.push(new node(Math.abs(m[i][j].up-i),Math.abs(m[i][j].left-j)));
							}
						}
						else{
							if(mat[i][j-1]==0){
								st.push(new node(Math.abs(m[i][j].up-i),Math.abs(m[i][j].left-j)));
							}
						}
					}
					else if(mat[i][j]==1&&mat[i][j-1]==0&&mat[i-1][j]==0){
						st.push(new node(Math.abs(m[i][j].up-i),Math.abs(m[i][j].left-j)));
					}
				}
				else{
					m[i][j].up=0;
					m[i][j].left=0;
				}

			}
		}
		int count=0;
		while(!st.isEmpty()){
			count++;
			node t=st.pop();
			System.out.println("#"+count+" is in (x,y):("+t.x+","+t.y+")");
		}
		System.out.println("count= "+count);
	}
	static class  node{
		int x=0,y=0;
		node(int xx,int yy){
			x=xx;
			y=yy;
		}
	}
	static class nod{
		int up=0;
		int left=0;
		public nod(){
			up=0;
			left=0;
		}
		public nod(int u,int l){
			up=u;
			left=l;
		}
	}
	public static void main(String[] args) {
		int[][] c={{1,1,0,0,0,0},{1,1,0,1,1,0},{1,1,0,1,1,0},{0,0,0,0,0,1},{1,1,1,0,0,0},{1,1,1,0,1,0}};
		MyLibrary.printIntMatrix(c);
		blackmat(c);

	}

}
