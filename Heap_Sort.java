import java.util.Random;
import java.util.Scanner;

public class Heap_Sort {
	
    private static int  a[];
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    
    public static void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    public static void maxheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    public static void exchange(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
        }
    
    public static void sort(int []a0){
        a=a0;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter length of array");
    	int n=sc.nextInt();
    	int arr[]=new int[n];
    	System.out.println("Enter array elements : ");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		long initialtime1=System.nanoTime();
        sort(arr);
        long finaltime1=System.nanoTime();
        System.out.println("Time : "+(finaltime1-initialtime1)+"ns");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] + " ");
        }
    }
}

