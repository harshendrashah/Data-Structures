import java.util.Scanner;

class Node{
	Node(int num){
	data = num;
	next = null;
	}
	int data;
	Node next;
}

public class StacksViaLinkedList{

	static Node push(Node head,int data){
		Node temp = head;
		if(temp == null){
			Node newnode = new Node(data);
			newnode.next = null;
			head = newnode;
		}
		else{
			while(temp.next != null){
				temp = temp.next;
			}
			Node newnode = new Node(data);
			newnode.next = null;
			temp.next = newnode;
		}
		return head;
	}

	public static void display (Node head){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	static Node pop(Node head,int m){
		Node temp=head;
		while(temp.next.next!=null){
			temp=temp.next;
		}
		temp.next=null;
		return temp;
	}
	public static void main(String[] args) {
		Node head = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements to be inserted :");
		int n = sc.nextInt();
		System.out.println("Insert the numbers:");
		for(int i=1;i<=n;i++){
			int data = sc.nextInt();
			head = push(head,data);
			
		}
		display(head);
		pop(head,n);
		System.out.println();
		display(head);
	}

}

