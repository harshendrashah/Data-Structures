   
import java.util.Scanner;

public class Quick_Sort {
	    
	    public int partition(int arr[], int low, int high){
	        int pivot = arr[high]; 
	        int i = (low-1); 
	        for (int j=low; j<=high-1; j++){
	            if (arr[j] <= pivot){
	                i++;
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }                     
	        int temp = arr[i+1];
	        arr[i+1] = arr[high];
	        arr[high] = temp;
	        return i+1;
	    }
	    void sort(int arr[], int low, int high)
	    {
	        if (low < high){
	            int pi = partition(arr, low, high);
	            sort(arr, low, pi-1);
	            sort(arr, pi+1, high);
	        }
	    }
	    public static void main(String args[])
	    {
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Enter length of array : ");
	        int n=sc.nextInt();
	        int arr[]=new int[n];
	        System.out.println("Enter array elements");
			for(int i=0;i<n;i++){
				arr[i]=sc.nextInt();
			}
			long initialtime1=System.nanoTime();
	        Quick_Sort obj = new Quick_Sort();
	        obj.sort(arr, 0, arr.length-1);
	        long finaltime1=System.nanoTime();
	        System.out.println("Time : "+(finaltime1-initialtime1)+"ns");
	        System.out.println("sorted array");
	        for(int i=0;i<arr.length;i++){
	        	System.out.println(arr[i]);
	        }
	   }
}


