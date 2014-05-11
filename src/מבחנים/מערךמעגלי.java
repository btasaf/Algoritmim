package îáçğéí;

public class îòøêîòâìé {

	public static int ss(int[] arr){
		int h=arr.length;
		int l=0;
		while(h>=l){
			int mid=(l+h)/2;
			if(arr[mid]<arr[0]){
				if(arr[mid]<arr[mid-1])
					return arr[mid-1];
				else
					h=mid;
			}
			else 
				l=mid;
		}
		return arr[0];
	}
	public static void main(String[] args) {
		int[] a={1,2,3,4};
		System.out.println(ss(a));
	}

}
