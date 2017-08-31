import java.util.Scanner;
 
public class Bubble_Sort {
	  public static void main(String []args) {
		    int n,swap;
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Input number of integers to sort : ");
		    n = sc.nextInt();
		    int array[] = new int[n];
		    System.out.println("Enter " + n + " integers :");
		    for (int i = 0; i < n; i++) 
		    	array[i] = sc.nextInt();
		    long initialtime=System.nanoTime();
		    for (int i = 0; i < ( n - 1 ); i++) {
		    	for (int j = 0; j < n - i - 1; j++) {
			        if (array[j] > array[j+1]) /* For descending order use < */
			        {
			          swap       = array[j];
			          array[j]   = array[j+1];
			          array[j+1] = swap;
			        }
			      }
		    }
		    long finaltime=System.nanoTime();
		    System.out.println("Sorted list of numbers : ");
		    for (int i = 0; i < n; i++) 
		    	System.out.print(array[i]+" ");
		    System.out.println();
		    System.out.println("Time : "+(finaltime-initialtime)+"ns");
	  }
}
