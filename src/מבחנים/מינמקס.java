package מבחנים;

public class מינמקס {

	public static void minmax(int[] a){
		int max=Math.max(a[0], a[1]),min=Math.min(a[0], a[1]);
		int i=0;
		for ( i = 2; i < a.length-1; i=i+2) {
			if(a[i]>a[i+1]){
				min=Math.min(a[i+1],min);
				max=Math.max(a[i], max);
			}
			else{
				min=Math.min(a[i],min);
				max=Math.max(a[i+1],max);
			}
		}
		if(a.length%2!=0){
			if(a[i]>max)max=a[i];
			if(a[i]<min)min=a[i];
		}
		
		System.out.println("max= "+max+"\nmin= "+min);
	}
	public static void main(String[] args) {
		int[] c={1,2,2,3,4};
		minmax(c);
	}

}
