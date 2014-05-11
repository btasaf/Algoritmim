package מבחנים;

public class חזקה {

	public static int power(int x,int n){
		int res=1;
		while(n!=0){
			if(n%2==1)
				res=x*res;
			x=x*x;
			n=n/2;
		}
		
		return res;
	}
	public static void main(String[] args) {
		System.out.println(power(2,0));

	}

}
