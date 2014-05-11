package Power;

public class temp {

	public static int power(int num,int pow){
		int back=1;
		while(pow>0){
			if(pow%2==1)back=back*num;
			
			num=num*num;
			pow=pow/2;
		}
		return back;
	}
	public static int powerrec(int num,int pow){
		if(pow==0)return 1;
		if(pow%2==1)return num*powerrec(num*num,pow/2);
		return powerrec(num*num,pow/2);
	}
	public static void main(String[] args) {
		System.out.println(powerrec(2,3));
	}

}
