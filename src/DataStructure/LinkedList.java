package DataStructure;

public class LinkedList<T> implements List<T> {
    Node first, last;
    int elments;
    class Node{
        Node next;
        T ele;
        public Node( T ele,Node next) {
            this.next=next;
            this.ele=ele;
        }

        @Override
        public String toString() {
            if (next==null)
                return ele.toString();
            else return ele+" "+next;
        }
    }
    private Node find(Node start,int index){
        if (index==0)
            return start;
        else return find(start.next,index-1);
    }
    private Node recursivereversal(Node oldfirst){
        if (oldfirst.next==null)
            return oldfirst;
        else {
            Node Newprior=oldfirst.next;
            Node First=recursivereversal(Newprior);
            Newprior.next=oldfirst;
            return First;
        }
    }
    @Override
    public void add(T value) {
        if (first==null)
            first=last=new Node(value,null);
        else {
            last.next=new Node(value,null);
            last=last.next;
        }
        elments++;
    }

    @Override
    public void remove(int index) {
        if (index==0){
            first=first.next;
        }else {
            Node prior=find(first,index-1);
            prior.next=prior.next.next;
        }elments--;
    }

    @Override
    public T get(int index) {
        if (index==0)
            return first.ele;
        else return find(first,index).ele;

    }

    @Override
    public int size() {
        return elments;
    }

    @Override
    public void reverse() {
        if (first!=null){
            last=first;
            first=recursivereversal(first);
            last.next=null;
        }
    }
    @Override
    public String toString(){
        if (first==null)
            return "";
        else return first.toString();
    }
}






































    /*
    Node first,last;
    int elemnt;
    class Node{
        T val;
        Node next;
        public Node(T val, Node next){
            this.val=val;
            this.next=next;
        }

        @Override
        public String toString() {
            if (next==null)
                return val.toString();
            else return val+" "+next;
        }
    }
    private Node getnode(Node start, int index){
        if (index==0)
            return start;
        else return getnode(start.next, index-1);
    }
    private Node recursivereversal(Node oldfirst){
        if (oldfirst.next==null)
            return oldfirst;
        else {
            Node newprior=oldfirst.next;
            Node first=recursivereversal(newprior);
            newprior.next=oldfirst;
            return first;
        }
    }
    @Override
    public void add(T value) {
        if (first==null)
            first=last=new Node(value,null);
        else {
            last.next=new Node(value,null);
            last=last.next;
        }
        elemnt++;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            first = first.next;
        } else {
            Node oldfirst = getnode(first, index - 1);
            oldfirst.next = oldfirst.next.next;
        }elemnt--;
    }

    @Override
    public T get(int index) {
       return getnode(first,index).val;
    }

    @Override
    public int size() {
        return elemnt;
    }

    @Override
    public void reverse() {
        if (first!=null){
            last=first;
            first=recursivereversal(first);
            last.next=null;

        }
    }
    @Override
    public String toString(){
        if (first==null)
            return "";
        else return first.toString();
    }
}
*/








































































