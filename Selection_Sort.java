import java.util.Scanner;

public class Selection_Sort {
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter length of an array : ");
		int n=sc.nextInt();
		System.out.println("Enter elements : ");
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int min,temp;
		long initialtime=System.nanoTime();
		for(int i=0;i<n;i++){
			min=i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[min]){
					min=j;
				}
			}
			if(min!=i){
				temp=arr[min];
				arr[min]=arr[i];
				arr[i]=temp;
			}
		}
		long finaltime=System.nanoTime();
		for(int i=0;i<n;i++){
			System.out.println(arr[i]);
		}
		System.out.println("Time : "+(finaltime-initialtime)+"ns");
	}
}
