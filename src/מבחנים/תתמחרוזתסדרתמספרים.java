package מבחנים;

import LIS.MyLibrary;

public class תתמחרוזתסדרתמספרים {
	public static int lisonlysize(int[] arr){
		int[] d=new int[arr.length];
		d[0]=arr[0];
		int beg=0,index=0;
		for (int i = 0; i < d.length; i++) {
			 index=bsb(d,beg,arr[i]);
			 d[index]=arr[i];
			 if(index>beg)beg++;
		}
		
		return beg+1;
	}
	public static int bsb(int[] arr,int end,int val){
		if(arr[end]<val)return end+1;
		if(arr[0]>val)return 0;
		int h=end,l=0;
		while(l<=h){
			int mid=(h+l)/2;
			if(l==h)return l;
			if(arr[mid]==val)return mid;
			if(arr[mid]<val)l=mid+1;
			else h=mid;
		}
		return 0;
	}
	public static void main(String[] args) {
		int[] ccc={ 11 ,22, 33 , 1 , 2 ,-1 , 3,-2, 4 ,5 };
		System.out.println(lisonlysize(ccc));
	}

}
