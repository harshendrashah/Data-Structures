import java.util.*;

class Node {
	Node(int num){
	data = num;
	next = null;
	}
	int data;
	Node next;
}

public class Linked_List{

	static Node insert(Node head,int data){
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
	
	static Node delete(Node head,int m){
		if(m==0){
			head=head.next;
			return head;
		}
		Node temp=head;
		for(int i=0;i<m-1;i++){
			temp= temp.next;
		}
		Node prev=temp;
		prev.next=temp.next.next;
		return head;
	}
	public static Node reverse(Node head1,int m){
		Node temp=head1;
		Node head2=new Node(0);
		for(int j=1;j<=m;j++){
			temp=head1;
			for(int i=m;i>j;i--){
			temp=temp.next;
			}
			head2=insert(head2,temp.data);
		}
		head2=delete(head2,0);
		head1=head2;
		return(head1);
	}
	public static void main(String[] args) {
		Node head = null;
		Scanner sc = new Scanner(System.in);
		
		int c=1;
		while(c==1){
			System.out.println("Enter a function to perform :");
			System.out.println("1.Insert");
			System.out.println("2.Delete");
			System.out.println("3.Reverse");
			int select=sc.nextInt();
			switch(select){
			case 1: System.out.println("Enter the number of elements to be inserted :");
					int n = sc.nextInt();
					System.out.println("Insert the numbers:");
					while(n>0){
						int data = sc.nextInt();
						head = insert(head,data);
						n--;
					}
					display(head);
					break;
			case 2: System.out.println("Enter the position of element to be deleted:");
					int m=sc.nextInt();
					delete(head,m);
					display(head);
					break;
			case 3 :System.out.print("Enter size of linked list :");
					int temp=sc.nextInt();
					head=reverse(head,temp);
					display(head);
			default: System.out.println("Unrecognized operation");
			}
			System.out.println();
			System.out.println("Press 1 to continue or 0 to exit");
			c = sc.nextInt();
		}
	}
}

