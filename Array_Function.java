import java.util.*;

public class Array_Function{

	private int array[] = new int [100];
	private int sizeOfArray=0;
	
	public Array_Function(int input[],int s){
		array = input;
		sizeOfArray = s;
	}

	public void addToFront(int front){
		if(sizeOfArray==100){
			System.out.println("***Array Overflow***");
			return;
			}	
		for(int i = sizeOfArray;i>=1;i--)
			array[i] = array[i-1];
		array[0] = front;
		sizeOfArray++;
	}
	
	public void addToRear(int rear){
		if(sizeOfArray==100){
			System.out.println("***Array Overflow***");
			return;
			}
		array[sizeOfArray] = rear;
		sizeOfArray++;
	}
	
	public void add(int index, int element){
		if(sizeOfArray==100){
			System.out.println("***Array Overflow***");
			return;
			}
		int j;
		for(j = sizeOfArray;j>index;j--)
			array[j] = array[j-1];
		array[j] = element;
		sizeOfArray++;
	}
	
	public int size(){
		return sizeOfArray;
	}
	
	public boolean isEmpty(){
		return sizeOfArray==0;
	}
	
	public int deleteFront(){
		if(sizeOfArray==0){
			System.out.println("Array Empty");
			return 0;
			}
		int dFront = array[0];
		for(int k = 0;k<sizeOfArray-1;k++)
			array[k] = array[k+1];
		sizeOfArray--;
		return dFront;
	}
	
	public int deleteRear(){
		if(sizeOfArray==0){
			System.out.println("Array Empty");
			return 0;
			}
		int dRear = array[sizeOfArray-1];
		array[sizeOfArray-1] = 0;
		sizeOfArray--;
		return dRear;
	}
	
	public int delete(int iDelete){
		if(sizeOfArray==0){
			System.out.println("Array Empty");
			return 0;
			}
		int d = array[iDelete];
		for(int k = iDelete;k<sizeOfArray-1;k++)
			array[k] = array[k+1];
		sizeOfArray--;
		return d;
	}
	
	public void display(){
		if(sizeOfArray>100 || sizeOfArray<1){
			System.out.println("Array does not exist.");
			return;
			}
		System.out.println("Current Array : ");
		System.out.print("{");
		for(int i=0;i<sizeOfArray;i++)
			System.out.print(array[i]+",");
		System.out.print("\b}");
	}
}
