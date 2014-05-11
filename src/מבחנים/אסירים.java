package מבחנים;

import LIS.MyLibrary;

public class אסירים {
	public static int pri(int x){
		int[] p=new int[x];
		int count=0;
		int days=0;
		boolean lamp=((int)Math.random()*2)==1?true:false;
		//boolean lamp=true;
		while(count<x*2-2){
			int in=(int)(Math.random()*x);
			days++;
			switch(in){
			case 0:
				if(lamp){
					lamp=false;
					count++;
				}
				break;
			default :
				if(p[in]<2&&!lamp){
					p[in]++;
					lamp=true;
				}
				break;
			}
			
		}
		return days;
		
	}
	public static void main(String[] args) {
		int count =0;
		System.out.println();
		for (int i = 0; i < 10000; i++) {
			count=count+pri(10);
		}
		System.out.println(count/10000);

	}

}
