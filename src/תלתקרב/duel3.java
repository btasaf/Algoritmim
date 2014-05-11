package תלתקרב;

public class duel3 {
	public static void duel3d(int num){
		double pc=0.8,pd=0.5;
		int bwin=0,cwin=0,dwin=0;
		int B=1,C=2,D=3;
		boolean flag=true;
		for (int i = 0; i < num; i++) {
			int[] q=getQueuq3();
			switch(q[1]){
			case 1:
				if(Math.random()<pd)dwin++;
				else bwin++;
				break;
			case 2:
				if(Math.random()<pc)
					while(flag){
						if(Math.random()<pd){
							dwin++;
							break;
						}
						if(Math.random()<pc){
							cwin++;
							break;
						}
					}
				else{
					
						if(Math.random()<pd){
							dwin++;
							break;
						}
						else{
							bwin++;
							break;
						}
				}

				break;
			case 3:
				if(q[2]==2){
					if(Math.random()<pc)
						while(flag){
							if(Math.random()<pd){
								dwin++;
								break;
							}
							if(Math.random()<pc){
								cwin++;
								break;
							}
						}
					else{
						
							if(Math.random()<pd){
								dwin++;
								break;
							}
							else{
								bwin++;
								break;
							}
					}
				}
				else{
					if(Math.random()<pd)dwin++;
					else bwin++;
				}

				break;
			}
		}
		System.out.println("Bp= "+(double)bwin/num+"\nCp= "+(double)cwin/num+"\nDp= "+(double)dwin/num+"\nsum= "+((double)bwin/num+(double)cwin/num+(double)dwin/num));
	}
	public static int [] getQueuq3(){
		int[]q = {0,1,2,3};
		for (int i = 1; i < q.length; i++) {
			int j = (int)(Math.random()*3) + 1;
			int t = q[i];
			q[i] = q[j];
			q[j] = t;
		}
		//System.out.println(Arrays.toString(q));
		return q;
	}
	public static void main(String[] args) {
		int num = 1000000;
		duel3d(num);
	}

}
