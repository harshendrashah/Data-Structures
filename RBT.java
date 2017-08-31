
public class RBT {
	NodeRBT root;
	public void insert(int data){
		if(root==null){
			root = new NodeRBT(null,data);
			root.color=false;
		}
		else
			root = insert(root,data);
	}
	private NodeRBT insert(NodeRBT node, int data) {
		if(node.data>=data){
			if(node.left==null){
				node.left= new NodeRBT(node,data);
				return node;
			}
			else{
				node.left=insert(node.left,data);
				isRotate(node,true);
				return node;
			}
		}
		else{
			if(node.right==null){
				node.right=insert(node.right,data);
				return node;
			}
			else{
				node.right=insert(node.right,data);
				isRotate(node,false);
				return node;
			}
		}
		
	}
	private void isRotate(NodeRBT node,boolean isLeft) {
		NodeRBT son,grndson,uncle;
		boolean isRight;
		if(isLeft)
			son=node.left;
		else
			son = node.right;
		if(son.color==false)
			return;
		else if(son.left==null){
			if(son.right.color==false)
				return;
			isRight=true;
			grndson=son.right;
		}
		else if(son.right==null){
			if(son.left.color==false)
				return;
			isRight = false;
			grndson=son.left;
		}
		else if(son.right.color==false&&son.left.color==false)
			return;
		else{
			if(son.right.color){
				isRight=true;
				grndson=son.right;
			}
			else{
				grndson=son.left;
				isRight=false;
			}
		}
		if(isLeft)
			uncle=node.right;
		else
			uncle = node.left;
		if(uncle!=null&&son.color==uncle.color){
			son.color=false;
			uncle.color=false;
			node.color=true;
		}
		else{
			if(isLeft){
				if(isRight)
					node=rotateRL(node);
				else
					node = rotateR(node);
			}
			else{
				if(isRight)
					node = rotateLR(node);
				else
					node = rotateL(node);
			}
		}
	}
	private NodeRBT rotateL(NodeRBT node) {
		NodeRBT temp = node.right;
		node.right=temp.left;
		temp.left=node;
		node.color=true;
		temp.color=false;
		return temp;
	}
	private NodeRBT rotateLR(NodeRBT node) {
		NodeRBT sec=node.right;
		NodeRBT temp = sec.left;
		sec.left=temp.right;
		temp.right=sec;
		return rotateL(node);
	}
	private NodeRBT rotateR(NodeRBT node) {
		NodeRBT temp = node.left;
		node.left=temp.right;
		temp.right=node;
		node.color=true;
		temp.color=false;
		return temp;
	}
	private NodeRBT rotateRL(NodeRBT node) {
		NodeRBT sec=node.left;
		NodeRBT temp = sec.right;
		sec.right=temp.left;
		temp.left=sec;
		return rotateR(node);
	}
}
class NodeRBT{
	boolean color;//false->black && True->Red
	int data;
	NodeRBT parent;
	NodeRBT left,right;
	public NodeRBT(NodeRBT parent, int info){
		this.parent=parent;
		data=info;
		color = true;
 	}
}
