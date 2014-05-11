package מציאת_מינימוםמקסימום_במערך_מעגלי;

public class findminmax {
	public static void mm(int[] x){
		int mid=x.length/2;
		while(mid<x.length&&mid>=0){
			if(x[mid]<x[mid-1]&&x[mid]<x[mid+1]){
				System.out.println("max= "+x[mid-1]+"\nmin= "+x[mid]);
				return;
			}
			if(x[mid]>x[0])mid++;
			else mid--;
		}
		System.out.println("max= "+x[0]+"\nmin= "+x[x.length-1]);
	}
	public static void main(String[] args) {
		int[] x={6,1,2,3,5};
		mm(x);
	}

}
