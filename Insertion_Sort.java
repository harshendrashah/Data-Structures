import java.util.Scanner;

public class Insertion_Sort 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );        
        int n;
        System.out.println("Input number of integers to sort :");
        n = sc.nextInt();
        int arr[] = new int[ n ];
        System.out.println("\nEnter "+ n +" integer elements :");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int N = arr.length;
        int  j, temp;
        long initialtime=System.nanoTime();
        for (int i = 1; i< N; i++){
            j = i;
            temp = arr[i];    
            while (j > 0 && temp < arr[j-1]){
                arr[j] = arr[j-1];
                j = j-1;
            }
            arr[j] = temp;            
        }
        long finaltime=System.nanoTime();
        System.out.println("Sorted list of numbers : ");        
        for (int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Time : "+(finaltime-initialtime)+"ns");
    }
}