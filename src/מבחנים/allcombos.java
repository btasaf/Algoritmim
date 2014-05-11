package מבחנים;

import LIS.MyLibrary;

public class allcombos {

	public static String[] combos(char[] arr){
		String[] com=new String[(int)Math.pow(2, arr.length)];
		for (int i = 0; i < com.length; i++) com[i]="";
		int[] bin=new int[arr.length];
		plus1(bin);
		for (int i = 0; i < com.length; i++) {
			for (int j = bin.length-1; j >=0; j--) {
				if(bin[j]==1)
				com[i]=arr[j]+com[i];
			}
			plus1(bin);
		}
		return com;
	}
	private static void plus1(int[] bin) {
		int i=bin.length-1;
		while(i>=0&&bin[i]==1){
			bin[i--]=0;
		}
		if(i>=0)
		bin[i]=1;
	}
	public static void main(String[] args) {
		String a="asaf";
		char[] b=a.toCharArray();
		String[] c=combos(b);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
	}

}
