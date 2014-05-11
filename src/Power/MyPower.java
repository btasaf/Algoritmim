package Power;

public class MyPower {
	public static int power(int number,int power){
		int back=1;
		while(power>0){
			if(power%2==1)
				back=back*number;
			number=number*number;
			power=power/2;
		}
		return back;
	}
	public static int powerRecursion(int number,int power){
		if(power==0)return 1;
		if(power%2==1)return number *powerRecursion(number *number,power/2);
		return powerRecursion(number *number,power/2);
	}
	

	public static void main(String[] args) {
		System.out.println(power(2,2));
	}

}
