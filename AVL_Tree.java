import com.sun.corba.se.impl.orbutil.graph.Node;

public class AVL_Tree{

	public static void main(String[] args){
		AVL avl = new AVL();
		/*avl.insert(1);
		avl.insert(2);
		avl.insert(3);
		avl.insert(4);
		avl.insert(5);
		avl.insert(3);
		avl.insert(-1);
		avl.insert(15);
		avl.insert(56);
		avl.insert(11);
		avl.insert(89);
		avl.insert(69);
		avl.insert(-9);
		avl.insert(0);
		avl.insert(-99);
		avl.insert(1);
		avl.insert(12);*/
		avl.insert(50);
		avl.insert(100);
		avl.insert(25);
		avl.insert(80);
		avl.insert(90);
		avl.insert(20);
		avl.insert(30);
		avl.insert(91);
		avl.prntIn(avl.root);
		System.out.println(" ");
		avl.del(90);
		avl.prntIn(avl.root);
	}
}

class AVL{
	NodeAVL root=null;
	public void insert(int data){
		if(root==null){
			root = new NodeAVL(data);
		}
		else	
			root = insert(root,data);
	}

	private NodeAVL insert(NodeAVL node, int data){
		if(node==null){
			node = new NodeAVL(data);
			return node;
		}
		else{
			if (node.data>data) {
				node.left=insert(node.left,data);
				if(node.left==null)
					node.hLeft=0;
				else
					node.hLeft= Math.max(node.left.hLeft,node.left.hRight)+1;
			}
			else{
				node.right = insert(node.right, data);
				if(node.right==null)
					node.hRight=0;
				else
					node.hRight = Math.max(node.right.hLeft,node.right.hRight)+1;
			}

			node = isRotate(node);
		} 

		return node;
	}
	public NodeAVL rotateLR(NodeAVL node){
		NodeAVL sec = node.left;
		NodeAVL temp=sec.right;
		node.left=temp;
		sec.right=temp.left;
		temp.left=sec;
		node.left=temp.right;
		temp.right=node;
		if(node.left==null)
			node.hLeft=0;
		else
			node.hLeft=Math.max(node.left.hLeft,node.left.hRight)+1;
		if(sec.right==null)
			sec.hRight=0;
		else
			sec.hRight=Math.max(sec.right.hLeft,sec.right.hRight)+1;
		temp.hLeft=Math.max(sec.hLeft,sec.hRight)+1;
		temp.hRight=Math.max(node.hLeft,node.hRight)+1;

		return temp;
	}
	public NodeAVL rotateRL(NodeAVL node){
		NodeAVL sec = node.right;
		NodeAVL temp=sec.left;
		node.right=temp;
		sec.left=temp.right;
		temp.right=sec;
		node.right=temp.left;
		temp.left=node;
		if(node.right==null)
			node.hRight=0;
		else
			node.hRight=Math.max(node.right.hLeft,node.right.hRight)+1;
		if(sec.left==null)
			sec.hLeft=0;
		else
			sec.hLeft=Math.max(sec.left.hLeft,sec.left.hRight)+1;
		temp.hRight=Math.max(sec.hLeft,sec.hRight)+1;
		temp.hLeft=Math.max(node.hLeft,node.hRight)+1;

		return temp;
	}

	public NodeAVL rotateLL(NodeAVL node){
		NodeAVL temp=node.left;
		node.left=temp.right;
		temp.right=node;
		if(node.left==null)
			node.hLeft=0;
		else 
			node.hLeft=Math.max(node.left.hRight,node.left.hLeft)+1;
		temp.hRight=Math.max(node.hRight,node.hLeft)+1;
		return temp;
	}
	public NodeAVL rotateRR(NodeAVL node){
		NodeAVL temp=node.right;
		node.right=temp.left;
		temp.left=node;
		if(node.right==null)
			node.hRight=0;
		else 
			node.hRight=Math.max(node.right.hRight,node.right.hLeft)+1;
		temp.hLeft=Math.max(node.hRight,node.hLeft)+1;
		return temp;
	}
	
	public NodeAVL isRotate(NodeAVL node){
	 	if(node.hRight-node.hLeft>=2){
	 		if(node.right.hRight-node.right.hLeft>=1)
	 			node=rotateRR(node);
	 		else if(node.right.hRight-node.right.hLeft<=-1)
	 			node=rotateRL(node);
	 	}
	 	else if(node.hRight-node.hLeft<=-2){
	 		if(node.left.hRight-node.left.hLeft<=-1)
	 			node=rotateLL(node);
	 		else if(node.left.hRight-node.left.hLeft>=1)
	 			node = rotateLR(node);
	 	}
	 	return node;
	 }

	 public void prntIn(NodeAVL node){
	 	if(node==null)
			return;
		else if(node.left==null&&node.right==null)
			System.out.print(node.data+" ");
		
		else{
			prntIn(node.left);
			System.out.print(node.data+" ");
			prntIn(node.right);
		}

	 }
	 public void del(int data){
		 if(root.data==data){
			 NodeAVL temp = root.right;
			 if(root.left==null&&root.right==null)
				 root=null;
			 else if(root.left==null)
				 root=root.right;
			 else if(temp==null)
				 root=root.left;
			 else{
				 int dta=0;
				 if(root.right.left==null){
					 root.right.left=root.left;
					 root=root.right;
				 }
				 else{
					  dta = Go(temp);
					  root.data=dta;
					  }
				 if(root.right==null)
					 root.hRight=0;
				 else
					 root.hRight = Math.max(root.right.hLeft, root.right.hLeft);
				 //System.out.print(root.data);
				 root = isRotate(root);
			 }
		 }
		 else
			 del(root,data);
	 }
	 private void del(NodeAVL node, int data){
		 if(node.right == null&&node.left==null)
			 return;
		 if(node.right!=null&&node.right.data==data){
			 NodeAVL del = node.right;
			 if(del.right==null && del.left==null)
				 node.right = null;
			 else if(del.left==null)
				 node.right=del.right;
			 else if(del.right==null)
				 node.right=del.left;
			 else{
				 NodeAVL temp = del.right;
				 if(temp.left==null)
					 node.right=node.right.right;
				 else
					 del.data=Go(temp);
				 del.hRight=Math.max(del.right.hLeft, del.right.hRight);
			 }
		 }
		 else if(node.left!=null && node.left.data == data){
			 NodeAVL del = node.left;
			 if(del.right==null && del.left==null)
				 node.left = null;
			 else if(del.left==null)
				 node.left=del.right;
			 else if(del.right==null)
				 node.left=del.left;
			 else{
				 NodeAVL temp = del.right;
				 if(temp.left==null)
					 node.left=node.left.right;
				 del.data=Go(temp);
				 del.hRight=Math.max(del.right.hLeft, del.right.hRight);
			 }
		 }
		 else if(node.data>data){
			 del(node.left,data);
			 if(node.left==null)
				 node.hLeft=0;
			 else
			 node.hLeft=Math.max(node.left.hLeft,node.left.hRight)+1;
			 
		 }
		 else if(node.data<data){
			 del(node.right,data);
			 if(node.right==null)
				 node.hRight=0;
			 else
			 node.hRight=Math.max(node.right.hLeft,node.right.hRight)+1;
		 }
		 node = isRotate(node);
	}
	 public int Go(NodeAVL node){
		 if(node.left.left==null){
			 int data;
			 if(node.left!=null)
				 data = node.left.data;
			 else
				 data=node.data;
			 node.left=null;
			 return data;
		 }
		 node = node.left;
		 int data = Go(node);
		 if(node.left==null)
			 node.hLeft=0;
		 else
			 node.hLeft=Math.max(node.left.hLeft,node.left.hLeft );
		 node=isRotate(node);
		 return data;
	}
}
class NodeAVL{
	int hLeft;
	int hRight;
	int data;
	NodeAVL left;
	NodeAVL right;
	public NodeAVL(int data){
		hLeft=0;
		hRight=0;
		this.data=data;
		left=null;
		right=null;
	}

}