package בניין_וכדור_זכוכית;

public class Tower_and_glassBall {
	public static int[] createRndArr(int size){
		int[] back=new int[size];
		back[0]=0;
		for(int i=1;i<back.length;i++)
			back[i]=back[i-1]+(int)(Math.random()*10);
		return back;
	}
	public static int runOnTower(int[] arr,int start,int stop,int breakpoint){
		for(int i=start;i<stop;i++){
			if(arr[i]>=breakpoint)return i;
		}
		return stop;
	}
	public static int twoballs(int[] arr,int breakpoint){
		int div=(int)Math.sqrt(arr.length);
		int checkplace=0;
		while(breakpoint>=arr[checkplace]){
			if(checkplace+div>=arr.length){
				for(int i=checkplace;i<arr.length;i++)
					if(arr[i]>=breakpoint)return i;
				return -1;
			}
			else{
				checkplace=checkplace+div;
			}
		}
		return runOnTower(arr,checkplace-div,checkplace,breakpoint);
	}
	public static int secendtwoballs(int[] arr,int breakpoint){
		int div=(int)((1+Math.sqrt(1+8*(arr.length-1)))/2);//דהבדל אחד
		int checkplace=0;
		while(breakpoint>=arr[checkplace]){
			if(checkplace+div>=arr.length){
				for(int i=checkplace;i<arr.length;i++)
					if(arr[i]>=breakpoint)return i;
				return -1;
			}
			else{
				checkplace=checkplace+div;
			}
		}
		return runOnTower(arr,checkplace-(div-1),checkplace,breakpoint);//הבדל שני
		
		
	}
	public static void main(String[] args) {
		int[] arr=createRndArr(100);
		for (int i=0;i<arr.length;i++){
			if(i<10)
				System.out.println(" "+i+"   : "+arr[i]);
			else
				System.out.println(i+"   : "+arr[i]);
		}
		System.out.println(twoballs(arr,320));


	}

}
