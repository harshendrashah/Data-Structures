import java.util.Random;
import java.util.Scanner;

public class Sorting {
	static void Insertion(int arr[]){
		int temp,j;
		for(int i=1;i<arr.length;i++){
			temp=arr[i];
			j=i-1;
			while(j>-1 && arr[j]>temp){/* For descending order use < */
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
	}
	static void Bubble(int arr[]){
		int temp;
		for(int i=0;i<arr.length;i++){
			for(int j=arr.length-1;j>i;j--){
				if(arr[j]<arr[j-1]){/* For descending order use > */
					temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
	}
	static void Selection(int arr[]){
		 int min;
		 int temp;
		 for(int i=0;i<arr.length;i++){
			 min=i;
			 for(int j=i+1;j<arr.length;j++){
				 if(arr[j]<arr[min]){
					 min=j;
				 }
			 }
			 if(min!=i){
				 temp=arr[i];
				 arr[i]=arr[min];
				 arr[min]=temp;
			 }
		 }
	}
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
    static int Partition(int arr[],int low,int high){
    	int pivot = arr[low];
    	int i=high+1;
    	for(int j=high;j>low;j--){
    		if(arr[j]>=pivot){
    			i--;
    			int temp=arr[i];
    			arr[i]=arr[j];
    			arr[j]=temp;
    		}
    	}
    	int temp = arr[i-1];
        arr[i-1] = arr[low];
        arr[low] = temp;
        return i-1;
    }
    static void QSort(int arr[],int low,int high){
    	if(low<high){
    		int pi=Partition(arr,low,high);
    		QSort(arr,low,pi-1);
    		QSort(arr,pi+1,high);
    	}
    }
	static void printArray(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]+" ");
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[10];
		Random r=new Random();
		for(int i=0;i<10;i++){
			arr[i]=r.nextInt(100);
		}
		System.out.println("1.Insertion Sort");
		System.out.println("2.Bubble Sort");
		System.out.println("3.Selection Sort");
		System.out.println("4.Merge Sort");
		System.out.println("5.Quick Sort");
		System.out.println("6.Heap Sort");
		System.out.println("Enter a choice : ");
		int m=sc.nextInt();
		switch(m){
			case 1: long initialtime1=System.nanoTime();
					Insertion(arr);
					long finaltime1=System.nanoTime();
					printArray(arr);
					System.out.println("Time : "+(finaltime1-initialtime1)+"ns");
					break;
					
			case 2: long initialtime2=System.nanoTime();
					Bubble(arr);
					long finaltime2=System.nanoTime();
					printArray(arr);
					System.out.println("Time : "+(finaltime2-initialtime2)+"ns");
					break;
					
			case 3: long initialtime3=System.nanoTime();
					Selection(arr);
			 		long finaltime3=System.nanoTime();
			 		printArray(arr);
			 		System.out.println("Time : "+(finaltime3-initialtime3)+"ns");
			 		break;
					
			case 4: long initialtime4=System.nanoTime();
					Msort(arr,0,arr.length-1);
					long finaltime4=System.nanoTime();
					printArray(arr);
					System.out.println("Time : "+(finaltime4-initialtime4)+"ns");
					break;
					
			case 5:	long initialtime5=System.nanoTime();
					QSort(arr,0,arr.length-1);
					long finaltime5=System.nanoTime();
					printArray(arr);
					System.out.println("Time : "+(finaltime5-initialtime5)+"ns");
					break;
			}
	}
}
