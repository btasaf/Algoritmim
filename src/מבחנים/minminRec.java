package מבחנים;

public class minminRec {

	public static void minminrec(int[] arr){
		int[] ens={0,0};
		if(arr[0]<arr[1]){
			ens[0]=arr[0];
			ens[1]=arr[1];
		}
		else{
			ens[0]=arr[1];
			ens[1]=arr[0];
		}
		int[] a=	minminrec(arr,2,ens);
		System.out.println("min1="+ens[0]+"\nmin2="+ens[1]);
	}
	public static int[] minminrec(int[] arr,int indval,int[] ens){
		if(arr[indval]<ens[0]){
			ens[1]=ens[0];
			ens[0]=arr[indval];
		}
		else if(arr[indval]<ens[1])
			ens[1]=arr[indval];
		
		if(indval==arr.length-1){
			return ens;
		}
		else
			return minminrec(arr,indval+1,ens);
	}
	public static void main(String[] args) {
		int[] a={1,2,4,7,9,4,5,6,9,3,-2};
		minminrec(a);

	}

}
