package max_max1;

import java.util.Stack;
import java.util.Vector;
public class Max_Max {
	public static void max_max ( int[] a ){
		Vector<Node> v= new Vector<Node>();
		for( int i =0 ; i< a.length ; i++){
			Node n = new Node ( a[i] );
			v.add( n );
		}
		int i= 0;
		while( v.size() > 1 ){
			if ( v.elementAt(i).num > v.elementAt( i+1 ).num) {
				v.elementAt(i).st.push(v.remove( i+1 ) .num);
			}
			else {
				v.elementAt( i+1 ).st.push(v.remove(i).num);
			}
			i++;
			/**
			 * כל פעם שהאיי והגודל של וי מגיעים אחד לשני זה מאפס את איי כדי שלא יבקש אלמנט מחוץ לוקטור
			 */
			if ( ( v.size() == i ) || ( ( v.size()-1 ) == i ) )
				i=0;
		}
		int max1 = v.elementAt(0).num;
		int max2 = v.elementAt(0).st.pop();
		int temp;
		while( v.elementAt(0).st.size() > 0 ){
			temp = v.elementAt(0).st.pop();
			if( temp > max2 )
				max2 = temp;
		}
		System.out.println("O( n+log(n) )- max_1: "+max1+" , max_2: "+max2);
	}
	public static void main(String[] args) {
		int[] a = new int[10];
		for(int i=0; i < a.length ; i++){
			a[i] = ( (int) (Math.random()*100) ) + 10 ;
			System.out.println(" a["+i+"]: "+a[i]);
		}
		max_max(a);
	}
}
class Node1 {
	int num;
	Stack<Integer> st;
	public Node1 ( int value ){
		num = value;
		st = new Stack<Integer>();
	}
}

