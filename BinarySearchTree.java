 import java.util.Scanner;

class bstNode{
	
	bstNode right;
	bstNode left;
	int data;
	
	bstNode(int num){
		data=num;
		left = null;
		right = null;
	}
	
	public void setLeft(bstNode temp){
		left= temp;
	}
	
	public void setRight(bstNode temp){
		right=temp;
	}
	
	public bstNode getLeft(){
		return left;
	}
	
	public bstNode getRight(){
		return right;
	}
	
	public int getData(){
		return data;
	}
}

class BST{
	
	private bstNode root;
	
	public BST(){
		root = null;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	public void insert(int data){
		root=insert(root,data);
	}
	
	private bstNode insert(bstNode root,int data){
		if (root == null){
            root = new bstNode(data);
		}
		else{
            if (data <= root.getData()){ 
                root.left = insert(root.left, data);
            }
            else{
                root.right = insert(root.right, data);
            }
        }
        return root;
	}
	
	 public boolean search(int val){ 
         return search(root, val);
     }
	
	 private boolean search(bstNode root, int val){
         boolean found = false;
         while ((root != null) && !found){
             int rval = root.getData();
             if (val < rval)
                 root = root.getLeft();
             else if (val > rval)
                 root = root.getRight();
             else{
                 found = true;
                 break;
             }
             found = search(root, val);
         }
         return found;
     }
	 
	 public void inorder(){
         inorder(root);
     }
	 
     private void inorder(bstNode r){
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             inorder(r.getRight());
         }
     }

     public void preorder(){
         preorder(root);
     }
     private void preorder(bstNode r){
         if (r != null)
         {
             System.out.print(r.getData() +" ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
     }
     
     public void postorder(){
         postorder(root);
     }
     private void postorder(bstNode r){
         if (r != null){
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() +" ");
         }
     }  
     
     public void delete(int k){
         if (isEmpty())
             System.out.println("Tree Empty");
         else if (!search(k))
             System.out.println(k + " not found");
         else{
             root = delete(root, k);
             System.out.println(k+ " deleted from the tree");
         }
     }
     private bstNode delete(bstNode root, int k){
         bstNode p, p2, n;
         if (root.getData() == k){
             bstNode lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null){
                 p = rt;
                 return p;
             }
             else if (rt == null){
                 p = lt;
                 return p;
             }
             else{
                 p2 = rt;
                 p = rt;
                 while (p.getLeft() != null)
                     p = p.getLeft();
                 p.setLeft(lt);
                 return p2;
             }
         }
         if (k < root.getData()){
             n = delete(root.getLeft(), k);
             root.setLeft(n);
         }
         else{
             n = delete(root.getRight(), k);
             root.setRight(n);             
         }
         return root;
     }
 
     public int countNodes(){
         return countNodes(root);
     }

     private int countNodes(bstNode r){
         if (r == null)
             return 0;
         else{
             int l = 1;
             l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             return l;
         }
     }
     
     /*public void leftRotate(int k){
    	 
    	 if (isEmpty())
             System.out.println("Tree Empty");
         else if (!search(k))
             System.out.println(k + " not found");
         else
        	 leftRotate(root,k);
    	 
     }
     
     private bstNode leftRotate(bstNode root, int k){

    	 bstNode rt = root.right;
    	 bstNode lt = root.left;
    	 if(root.left.getData() == k){
    		 bstNode temp = lt.right.left;
    		 root.left = lt.right;
    		 root.left.left = lt;
    		 lt.right = temp;
    	 }
    	 else if(root.right.getData() == k){
    		 bstNode temp = rt.right.left;
    		 root.right = rt.right;
    		 root.right.left = rt;
    		 rt.right = temp;
    	 }
    	 else{
    		 if (k < root.getData())
    			 leftRotate(root.left,k);
             else
            	 leftRotate(root.right,k);
    		 
    	 }
    	 return root; 
     }*/
}

public class BinarySearchTree {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		BST bst=new BST();
		System.out.println("Binary Search Tree Test\n");          
        char ch;

        do{
            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1. Insert ");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Count Nodes");
            System.out.println("5. Check Empty"); 
            System.out.println("6. Print Tree");
            System.out.println("7. Left Rotate");
 
            int n = scan.nextInt();            
            switch (n)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                bst.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to delete");
                bst.delete( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ bst.search( scan.nextInt() ));
                break;                                          
            case 4 : 
                System.out.println("Nodes = "+ bst.countNodes());
                break;     
            case 5 :  
                System.out.println("Empty status = "+ bst.isEmpty());
                break; 
            case 6:
            	//System.out.print("\nPost order : ");
                //bst.postorder();
                //System.out.print("\nPre order : ");
                //bst.preorder();
                System.out.print("\nIn order : ");
                bst.inorder();
                break;
            /*case 7:
            	System.out.println("\nEnter the element from which node is to be rotated");
            	int k = scan.nextInt();
            	bst.leftRotate(k);
            	break;    */     			
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            
 
            System.out.println("\nDo you want to continue (Type Y or N) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
        
    }
	
}
