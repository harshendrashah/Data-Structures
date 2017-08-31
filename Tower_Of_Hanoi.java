
import java.util.*;
public class Tower_Of_Hanoi{

   public void solve(int n, String start, String via, String end) {
       if (n == 1) {
           System.out.println(start + " -> " + end);
       } else {
           solve(n - 1, start, end, via);
           System.out.println(start + " -> " + end);
           solve(n - 1, via, start, end);
       }
   }

   public static void main(String[] args) {
	   Tower_Of_Hanoi tower = new Tower_Of_Hanoi();
       System.out.print("Enter number of discs: ");
       Scanner in = new Scanner(System.in);
       int discs = in.nextInt();
       double sTime = System.currentTimeMillis();
       tower.solve(discs, "A", "B", "C");
     	double eTime = System.currentTimeMillis();
     	double t=(eTime-sTime)/1000;
       System.out.println("Time  :  "+t+" s. ");
   }
}

