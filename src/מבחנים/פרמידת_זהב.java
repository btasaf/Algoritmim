package מבחנים;

import java.util.Stack;

public class פרמידת_זהב {
	public static void findgold(node root){
		

	}
	public static gw findgoldrec(node root){
		gw l=findgoldrec(root.l);
		gw r=findgoldrec(root.r);
		gw back;
		if(l.gold>r.gold){
			 back=new gw(l.gold+root.gold,l.way+"l");
		}
		else{
			 back=new gw(r.gold+root.gold,r.way+"r");
		}
		return back;
	}
	static class node{
		node l,r;
		int gold;
		public node(int g){
			gold=g;
		}
	}
	static class gw{
		String way;
		int gold;
		gw(int g,String s){
			way=s;
			gold=g;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
