import java.util.*;

public class Stack{

	private static int stack[] = new int[100];
	private static int top;
	
	public static void Initiation(int t,int s[]){
		top = t;
		for(int i=0;i<t;i++){
			stack[i] = s[i];
		}
	}
	
	public static void push(int element){
		stack[top] = element;
		top++;
	}
	
	public static int pop(){
		if(top>0){
			int p = stack[top-1];
			top--;
			return p;
		}
		else{
			System.out.println("Stack empty");
			return -1;
		}
	}
	
	public static int peek(){
		return stack[top-1];
	}
	
	public static boolean isEmpty(){
		return top==0;
	}

	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements to enter in the stack");
		
		int t = sc.nextInt();
		int stack[] = new int[t];
		
		System.out.println("Enter the elements");
		for(int i=0;i<t;i++){
			stack[i] = sc.nextInt();
		}
		
		Initiation(t,stack);
		
		System.out.println("Enter the operation to perform");
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("0. Exit");
		
		int operation = sc.nextInt();
		int p;
		while(operation!=0){
			switch(operation){
		
				case 1: System.out.println("Enter the element to push");
					p = sc.nextInt();
					push(p);
					break;
				case 2: System.out.println("Removed element: "+pop());
					break;
		
			}
			operation = sc.nextInt();
		}
		
			
	}


}
