import java.util.*;

class Solution {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++){
			int N=sc.nextInt();
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			double t1=Math.sqrt(2)*N/v1;
			double t2=2*(N+1)/v2;
			if(t1>=t2){
				System.out.println("Elevator");
			}
			else{
				System.out.println("Stairs");
			}
		}
	}
}
