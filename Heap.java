class tree{
	tree(int data){
		data=data;
		right=null;
		left=null;
	}
	int data;
	tree right,left;	
}
public class Heap {
	tree root;
	public void insert(int data){
		root=insert(root,data);
	}
	private tree insert(tree root,int data){
		if(root==null){
			root=new tree(data);
		}
		else{
			if (data <= root.data){ 
	        root.left = insert(root.left, data);
	        }
	        else{
	        	root.right = insert(root.right, data);
	            }
	        }
	    return root;
	}
	
	
	static void heapify(int arr[]){
		int i=(int)(arr.length/2)-1;
		for(int j=i;j>=0;j--){
			if(arr[j]<arr[(2*j)+1] && arr[(2*j)]<arr[(2*j)+1]){
				int temp=arr[j];
				arr[j]=arr[(2*j)+1];
				arr[(2*j)+1]=temp;
			}
			if(arr[j]<arr[(2*j)] && arr[(2*j)+1]<arr[(2*j)]){
				int temp=arr[j];
				arr[j]=arr[(2*j)];
				arr[(2*j)]=temp;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={6,8,12,7,14,10};
		heapify(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
