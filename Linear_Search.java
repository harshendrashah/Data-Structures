import java.util.Scanner;
public class Linear_Search {
	  public static void main(String args[]){
		    
		  	int i;
		    Scanner sc= new Scanner(System.in);
		    System.out.println("Enter number of elements : ");
		    int n = sc.nextInt(); 
		    int array[] = new int[n];
		 
		    System.out.println("Enter " + n + " integers");
		 
		    for ( i = 0; i < n; i++){
		      array[i] = sc.nextInt();
		    }
		    System.out.println("Enter value to find : ");
		    int search = sc.nextInt();
		    long initialtime=System.nanoTime();
		    for ( i= 0; i < n; i++)
		    {
		      if (array[i] == search)     /* Searching element is present */
		      {
		         System.out.println(search + " is present at location " + (i + 1) + ".");
		          break;
		      }
		   }
		   if(i == n)  /* Searching element is absent */
		     System.out.println(search + " is not present in array.");
		   long finaltime=System.nanoTime();
			 System.out.println("Time : "+(finaltime-initialtime)+"ns");
		  }
	 

}

