package מבחנים;

import LIS.MyLibrary;

public class סידרה_מתחלפת {

	public static boolean ser(int[] arr){
		int[] n=new int[arr.length];
		n[0]=arr[0];
		for (int i = 1; i < n.length; i++) {
			n[i]=arr[i]+n[i-1];
		}
		MyLibrary.printIntegerArray(n);
		boolean back=true;
		int i;
		if(n[0]<n[1]){
			for (i = 1; i < n.length-1; i=i+2) {
				if(n[i]<n[i-1]||n[i]<n[i+1])back=false;
			}
			if(n.length%2!=0&&n[n.length-2]<n[n.length-1])back=false;
		}
		else{
			for ( i = 1; i < n.length; i++) {
				if(n[i]<n[i-1]||n[i]<n[i+1])back=false;
			}
			if(n.length%2!=0&&n[n.length-1]>n[n.length-2])back=false;
		}
		boolean flag=n[0]>n[1]?true:false;
		for (int j = 1; j < n.length; j++) {
			if(flag){
				if(n[j]>n[j-1]){
					back=false;
					break;
				}
				else{
					flag=!flag;
				}
			}
			else{
				if(n[j]<n[j-1]){
					back=false;
					break;
				}
				else flag=!flag;
			}
		}
		return back;
	}
	public static void main(String[] args) {
		int[] c={1,2,-6,8,-1};
		
		System.out.println(ser(c));
	}

}
