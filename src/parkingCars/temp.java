package parkingCars;

public class temp {
	public static int claccars(int[] arr,int start){
		int count=0,mark=-1,size=arr.length,i=start+1,fr=arr[start];
		boolean flag=true;
		while(flag){
			
			if(arr[i%size]==fr)arr[i%size]=mark;

			if(arr[start]==mark)flag=false;
			
			count++;
			i++;
		}
		System.out.println(arr.length);
		return count;

	}
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,3,2,1,2,3,4,2,3,5,-1,0,6,4,3};
		System.out.println(claccars(arr, 17));

	}

}
