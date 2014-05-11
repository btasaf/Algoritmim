package max_max1;

import java.util.Stack;

public class temp {
	static class node{                               
		int num;
		Stack<Integer> st;
		node next, pri;
		public node(int num, node n, node p){
			this.num = num;
			st = new Stack<Integer>();
			next = n;
			pri = p;
		}
		public node(int num){
			this.num = num;
			st = new Stack<Integer>();
			next = null;
			pri = null;
		}
		public String toString(){
			return ""+num;
		}
	}
	static class noderec{
		int num;
		Stack<Integer> st;
		public noderec(int n){
			num=n;
			st=new Stack<Integer>();
		}
	}
	public static void max1max2compare(int[] arr){
		int max1=Math.max(arr[0], arr[1]);
		int max2=Math.min(arr[0], arr[1]);
		int i=2;
		while(i<arr.length-1){
			if(max1<arr[i]){
				max2=max1;
				max1=arr[i];
			}
			else if(max2<arr[i])max2=arr[i];
			i++;
		}
		System.out.println("max 1: "+max1+"\nmax2= "+max2);
	}
	public static void max1max2induction(int[] arr){
		node head=new node(arr[0]);
		node in=head;
		for (int i = 1; i < arr.length; i++) {
			in.next=new node(arr[i],null,in);
			in=in.next;
			
		}
		node tail=in;
		tail.next=head;
		head.pri=tail;
		node i=head;
		while(i.next!=i){
			if(i.num>i.next.num){
				i.st.push(i.next.num);
				i.next.next.pri=i;
				i.next=i.next.next;
			}
			else{
				i.next.st.push(i.num);
				i.next.pri=i.pri;
				i.pri.next=i.next;
			}
			i=i.next;
		}
		int max1=i.num;
		int max2=0;
		while(!i.st.isEmpty()){
			max2=Math.max(max2, i.st.pop());
		}
		System.out.println("max 1="+max1+"\nmax 2="+max2);
	}
	public static void max1max2recurtion(int[] a){
		noderec[] arr=new noderec[a.length];
		for (int i = 0; i < a.length; i++)arr[i]=new noderec(a[i]);
		int index=max1max2recurtion(arr,0,arr.length-1);
		System.out.println("max1= "+arr[index].num);
		int max2=arr[index].st.pop();
		while(!arr[index].st.isEmpty()){
			max2=Math.max(max2, arr[index].st.pop());
		}
		System.out.println("max2= "+max2);
	}
	private static int max1max2recurtion(noderec[] arr, int start, int end) {
		int index;
		int mid=(end+start)/2;
		if(end==start)return end;
		int a=max1max2recurtion(arr, start, mid);
		int b=max1max2recurtion(arr, mid+1, end);
		if(arr[a].num>arr[b].num){
			arr[a].st.push(arr[b].num);
			return a;
		}
		else{
			arr[b].st.push(arr[a].num);
			return b;
		}
	}
	public static void printallnode(node head){
		node i=head.next;
		System.out.println(head.toString());
		while(i!=head){
			System.out.println(i.toString());
			i=i.next;
		}
	}
	public static void main(String[] args) {
		int[] arr ={ 2 , 6 , 8 , 3 , 4 , 1 , 9 , 5 , 10};
		int[] arr1={1,0, 21,33 ,12, 3,5,7,2,5,3,8,94,3,15,};
		max1max2recurtion(arr1);
	}

}
