package אסירים;

public class temp {

	public static int lampunknow(int n){
		int[] enter=new int[n];
		for (int i = 0; i < enter.length; i++) 	enter[i]=0;
		int steps=0;
		int count=0;
		boolean lamp=((int)Math.random()*2)==0?true:false;
		while(count<n*2-2){
			int rand=(int)(Math.random()*n);
			if(rand==0){
				if(lamp){
					count++;
					lamp=false;
				}
			}
			else{
				if(enter[rand]<2&&!lamp){
					lamp=true;
					enter[rand]++;
				}
			}
			steps++;
		}
		return steps;
	}
	public static void checklampunknow(){
		int n = 10, count = 0, nTry = 100000;
		for (int i=1; i<nTry; i++){
			count+=lampunknow(n) ;
		}
		System.out.println(count/nTry);
	}
	public static void main(String[] args) {
		//lampunknow(10);
		checklampunknow();
	}

}
