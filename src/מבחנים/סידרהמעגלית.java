package מבחנים;

public class סידרהמעגלית {
	public static boolean iscs(int[] arr){
		boolean back=true,f=false;
		int a=0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]<arr[i-1]){
				if(!f){
					f=true;
					a=i;	
				}
				else{
					back=false;
					break;
				}
			}
		}
		if(back)
		System.out.println(a);
		return back;
	}
	public static void main(String[] args) {
		int[] a={4,5,6,1,2,3};
		System.out.println(iscs(a));

	}

}
