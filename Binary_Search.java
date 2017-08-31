import java.util.*;
 
class Binary_Search {
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements :");
		int n = sc.nextInt(); 
		int[] array = new int[n];
 
		System.out.println("Enter " + n + " integers :");
 
 
	    for (int i = 0; i < n; i++){
	      array[i] = sc.nextInt();
	    }
	    System.out.println("Enter value to find : ");
	    int search = sc.nextInt();
	 
	    int first  = 0;
	    int last   = n - 1;
	    int  middle = (first + last)/2;
	    long initialtime=System.nanoTime();
	    while( first <= last ){
		      if ( array[middle] < search )
		        first = middle + 1;    
		      else if ( array[middle] == search ) 
		      {
		        System.out.println(search + " found at location " + (middle + 1) + ".");
		        break;
		      }
		      else
		         last = middle - 1;
	    }
	    if ( first > last ){
	    	System.out.println(search + " is not present in the list.\n");
	    }
	    long finaltime=System.nanoTime();
	    System.out.println();
	    System.out.println("Time : "+(finaltime-initialtime)+"ns");
	}
}