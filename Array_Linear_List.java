import java.util.*;

public class Array_Linear_List{

	public static void main(String args[]){
		int arr[]=new int[100];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of Array : ");
		int size = sc.nextInt();
		if(size>100 || size<0){
			System.out.println("Array size incompatible");
			return;
			}
		System.out.println("Enter the numbers");
		
		for(int i=0;i<size;i++)	
			arr[i] = sc.nextInt();
		
		Array_Function af = new Array_Function(arr,size);
		int c=1;
		while(c==1){
		
			System.out.println("1. Add to Front");
			System.out.println("2. Add to Rear");
			System.out.println("3. Add in between");
			System.out.println("4. Size");
			System.out.println("5. Check whether empty");
			System.out.println("6. Delete front");
			System.out.println("7. Delete rear");
			System.out.println("8. Delete in between");
			System.out.println("9. Display");
			System.out.println();
			
			int select = sc.nextInt();
			int element,position;

		
			switch(select){
				case 1: System.out.println("Enter the number to add to front");
					element = sc.nextInt();
					af.addToFront(element);
					af.display();
					break;
				case 2: System.out.println("Enter the element to add to rear");
					element = sc.nextInt();
					af.addToRear(element);
					af.display();
					break;
				case 3: System.out.println("Enter the index to add");
					position = sc.nextInt();
					System.out.println("Enter the number to add");
					element = sc.nextInt();
					af.add(position,element);
					af.display();
					break;
				case 4: System.out.println("The size of array is "+af.size());
					break;
				case 5: if(af.isEmpty())
						System.out.println("Array is empty");
					else 
						System.out.println("Array is not empty");
					break;
				case 6: System.out.println("The number deleted was: "+af.deleteFront());
					af.display();
					break;
				case 7: System.out.println("The number deleted was: " +af.deleteRear());
					af.display();
					break;
				case 8: System.out.println("Enter the index to delete");
					position = sc.nextInt();
					System.out.println("The number deleted was: "+af.delete(position));
					af.display();
					break;
				case 9: af.display();
					break;
				default: System.out.println("Unrecognized operation");	
			}
			System.out.println();
			System.out.println("Press 1 to continue or 0 to exit");
			c = sc.nextInt();
					
		}
		
	
	}

}
