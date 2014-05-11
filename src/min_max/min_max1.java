package min_max;

public class min_max1 {
	static void min_max(int[] arr){
		int x , y , size ;
		int max , min;
		if(arr[0] >arr[1] ){
			max = arr[0];
			min = arr[1];
		}
		else{
			max = arr[1];
			min = arr[0];
		}
		size = arr.length;
		if(size % 2 != 0){
			size--;
			if(max <arr[size])
				max = arr[size];
			else
				if(min >arr[size])
					min = arr[size];
		}
		for (int i = 2; i < size; i = i + 2) {
			x = arr[i];
			y = arr[i+1];
			if( x > y ){
				if(x >max)
					max = x;
				if(y <min)
					min = y;
			}
			else{
				if(y > max)
					max = y;
				if(x < min)
					min = x;
			}
		}
		System.out.println(" max: " + max);
		System.out.println(" min: " + min);
	}
	public static void main(String[] args) {
		int[] arr ={ 2 , 6 , 8 , 3 , 4 , 1 , 9 , 5 , 10};
		min_max(arr);
	}
}