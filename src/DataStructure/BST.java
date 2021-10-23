package DataStructure;

/**
 * Given a binary search tree and two keys of nodes, implement a method to find the 
 * key of the lowest common ancestor  (i.e. the shared ancestor that is located farthest 
 * from the root).
 */
 
public class BST {

	Node root;

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public Integer lowestCommonAncestor(int x, int y) {
		// TODO
		Node cur=this.find(x);
		Node need_find=this.find(y);

		if (cur.key==root.key){
			return root.key;
		}
		if (need_find.key==root.key){
			return root.key;
		}
		if (cur.key==need_find.parent.key){
			return cur.key;
		}
		if (need_find.key==cur.parent.key)
			return need_find.key;

		boolean aaaa=false;
		while (aaaa==false){
			need_find=need_find.parent;
			aaaa=this.finddad(need_find,cur);
		}
		return need_find.key;
	}


	public boolean finddad(Node parent, Node needtest){
		if (parent.left!=null){
			if (parent.left.key==needtest.key){
				return true;
			}
			else if (this.finddad(parent.left,needtest)==true)
				return true;
				;
		}
		if (parent.right!=null){
			if (parent.right.key==needtest.key){
				return true;
			}
			else if (this.finddad(parent.right,needtest)==true)
				return true;
		}
		return false;

	}
//	public boolean trverseNode(int a,int b,practice0420.Node needfind){
//		practice0420.Node copy1;
//		practice0420.Node copy2;
//		practice0420.Node orr=new practice0420.Node(needfind.key);
//
//		if (needfind.left==null&&needfind.right!=null){
//			if (needfind.right.key!=a) {
//				copy1=needfind.right;
//				this.trverseNode(a,copy1);
//			}
////			else if ()return true;
//
//		}
//		 else if (needfind.left!=null&&needfind.right==null){
//			if (needfind.left.key!=a ||needfind.key==orr.key ){
//				copy2=needfind.left;
//				this.trverseNode(a,copy2);}
//			else
//				return true;
//		}
//		else if(needfind.left!=null&&needfind.right!=null)
//			if (needfind.left.key!=a&&needfind.right.key!=a){
//				copy1=needfind.left;
//				this.trverseNode(a,copy1);
//				copy2=needfind.right;
//				this.trverseNode(a,copy2);
//		}
//		 else if (needfind.left.key==a&&needfind.left.key!= needfind.key){
//			return true;
//		}
//		 else if (needfind.right.key==a&&needfind.right.key!=needfind.key){
//			return true;
//		}
//		return false;
//	}

	public BST() {
		this.root = null;
	}

	/**
	* Find a node given a key
	*
	* @param key of a given node
	* @return the node that contains the key, otherwise null
	*/
	public Node find(Integer key) {
		Node current = root;
		while(current != null) {
			if(current.key.compareTo(key) < 0) {
				current = current.right;
			}else if (current.key.compareTo(key) > 0){
				current = current.left;
			}else if(current.key.compareTo(key) == 0) {
				return current;
			}
		}
		return null;
	}

	public Node insert(Integer key) {
		Node parent = null;
		Node current = root;
		while (current != null) {
			if(current.key.compareTo(key) < 0) {
				parent = current;
				current = current.right;
			}else if (current.key.compareTo(key) > 0){
				parent = current;
				current = current.left;
			}
		}

		if (parent == null && current == null) {
			this.root = new Node(key);  // no parent = root is empty
			return this.root;
		}else {
			Node newNode = new Node(key);

			if(parent.key.compareTo(key) < 0) {
				parent.right = newNode;
				newNode.parent = parent;
			}else if(parent.key.compareTo(key) > 0) {
				parent.left = newNode;
				newNode.parent = parent;
			}
			return newNode;
		}
	}

	public class Node {

		Integer key;
		Node parent;
		Node left;
		Node right;

		public Node(Integer key) {
			this.key = key;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
	}
}
