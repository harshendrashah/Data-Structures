import java.util.Scanner;

public class Merge_Link_List{

	public static Node insert(Node head,int data){
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
	public static void merge(Node head1,Node head2){
		while(head1.next!=null){
			head1=head1.next;
		}
		head1.next=head2;
	}
	public static void main(String[] args) {
		Node head1 = null;
		Node head2 = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements to be inserted :");
		int n = sc.nextInt();
		int m = n;
		System.out.println("Insert the numbers:");
		while(n>0){
			int data1 = sc.nextInt();
			head1 = insert(head1,data1);
			n--;
		}
		System.out.println("Enter the number of elements to be inserted :");
		int x = sc.nextInt();
		int y = x;
		System.out.println("Insert the numbers:");
		while(x>0){
			int data2 = sc.nextInt();
			head2 = insert(head2,data2);
			x--;
		}
		merge(head1,head2);
		System.out.println("Merged Linked List :");
		display(head1);
	}

}

