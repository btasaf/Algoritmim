package min_max;

public class temp {

	public static void minmax(int[] arr){
		int max=Math.max(arr[0], arr[1]);
		int min=Math.min(arr[0], arr[1]);
		int i=0;
		while(i+1<arr.length) {
			min=Math.min(Math.min(arr[i], arr[i+1]), min);
			max=Math.max(Math.max(arr[i], arr[i+1]), max);
			i=i+2;
		}
		i=i-1;
		if(i+1==arr.length-1){
			min=Math.min(Math.min(arr[i], arr[i+1]), min);
			max=Math.max(Math.max(arr[i], arr[i+1]), max);
		}
		System.out.println("max= "+max+"\nmin= "+min);
	}
	public static void main(String[] args) {
		int[] arr ={ 2 , 6 , 8 , 3 , 4 , 1 , 9 , 5 , 10};
		minmax(arr);
	}

}
