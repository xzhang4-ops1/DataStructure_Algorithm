package DataStructure;

public class BstSet<T> implements Set<T> {
    BstTree tree;
    int elements;

    class BstTree {
        T element;
        BstTree left, right;

        BstTree find(T element) {
            if (this.element != null) {
                if (element.equals(this.element))
                    return this;
                else if (element.hashCode() > this.element.hashCode()) {
                    if (right != null)
                        return right.find(element);
                } else if (element.hashCode() < this.element.hashCode()) {
                    if (left != null)
                        return left.find(element);
                }
            } return null;
        }

        BstTree add(T element) {
            if (this.element == null) {
                this.element = element;
                return this;
            } else if (element.hashCode() > this.element.hashCode()) {
                if (right == null)
                    right = new BstTree();
                return right.add(element);
            } else  if (element.hashCode() < this.element.hashCode()){
                if (left == null)
                    left = new BstTree();
                return left.add(element);
            } return null;

        }
        void add(BstTree subtree){
            if (subtree!=null&&subtree.element!=null){
                add(subtree.element);
                add(subtree.left);
                add(subtree.right);
            }
        }
        @Override
        public String toString(){
            if (element==null)
                return "";
            String str="";
            if (left!=null&&left.element!=null)
                 str+=left+", ";
            str+=element;
            if (right!=null&&right.element!=null)
               str+=", "+right;
            return str;

        }
    }
    @Override
    public void add(T element){
       if (tree==null)
           tree=new BstTree();
       if (tree.add(element)!=null)
           elements++;
    }

    @Override
    public void remove(T element) {
        if (tree.find(element)!=null){
        BstTree root=tree.find(element);
        BstTree l=root.left;
        BstTree r=root.right;
        root.left=null;
        root.right=null;
        root.element=null;
        tree.add(l);
        tree.add(r);
        elements--;
        }
    }


    @Override
    public boolean contains(T element) {
        return tree.find(element)!=null;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        if (tree==null)
            return "";
        else return tree.toString();
    }
}