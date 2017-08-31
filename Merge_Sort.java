  import java.util.Scanner;

public class Merge_Sort{
	
	static void Merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int temp1[] = new int [n1];
        int temp2[] = new int [n2];
        for (int i=0; i<n1; ++i)
            temp1[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            temp2[j] = arr[m + 1+ j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2){
            if (temp1[i] <= temp2[j]){
                arr[k] = temp1[i];
                i++;
            }
            else{
                arr[k] = temp2[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            arr[k] = temp1[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = temp2[j];
            j++;
            k++;
        }
    }
    static void Msort(int arr[], int low, int high){
        if (low < high) {
            int mid = (low+high)/2;
            Msort(arr, low, mid);
            Msort(arr , mid+1, high);
            Merge(arr, low, mid, high);
        }
    }
    public static void main(String args[]){
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter length of Array : ");
    	int n=sc.nextInt();
        int arr[] =new int[n];
        System.out.println("Enter array elements :");
        for(int i=0;i<n;i++){
        	arr[i]=sc.nextInt();
        }
        long initialtime=System.nanoTime();
        Merge_Sort ob = new Merge_Sort();
        ob.Msort(arr, 0, arr.length-1);
        long finaltime=System.nanoTime();
        System.out.println("\nSorted array");
        for(int i=0;i<n;i++){
        	System.out.println(arr[i]);
        }
        System.out.println("Time : "+(finaltime-initialtime)+"ns");
    }

}
