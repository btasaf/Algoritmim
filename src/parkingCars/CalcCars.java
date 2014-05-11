package parkingCars;

public class CalcCars {

	// number of cars calculation
	public static int calcCars(int []arr , int start){
		int size = arr.length;
		int count = 1; // איפוס
		int i = 1 + start; //
		int startElement = arr[start]; // שמירת איבר ראשון
		boolean startExists = true;

		while(startExists){
			while(arr[( i % size )] != startElement){
				count++;
				i++;
			}
			arr[( i % size )] = startElement + 1 ;
			if (arr[( i % size )]== arr[start])
				startExists = false;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,1,1};
		System.out.println(calcCars(arr, 3));
	}
}
