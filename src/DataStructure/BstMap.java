package DataStructure;

/*
 * Implement the Binary search tree map.
 */
public class BstMap<K, V> implements DataStructure.Map<K, V> {
    Bstree tree;
    int pairs;
   class KeyValuePair {
       K key;
       V val;
       public KeyValuePair(K key, V val){
           this.key=key;
           this.val=val;
       }

       @Override
       public String toString() {
           return "("+key+", "+val+")";
       }
   }
   class Bstree{
       Bstree left,right;
       KeyValuePair kv;
       Bstree find(K key) {
           if (this.kv != null) {
               if (key.equals(this.kv.key))
                   return this;
               else if (key.hashCode() > this.kv.key.hashCode()) {
                   if (right == null)
                       return null;
                   return right.find(key);
               } else if (key.hashCode() < this.kv.key.hashCode()) {
                   if (left == null)
                       return null;
                   return left.find(key);
               }

           }
           return null;
       }
       Bstree add(KeyValuePair kv){
           if (this.kv==null){
               this.kv=kv;
               return this;
           }
           else if (kv.key.hashCode()>this.kv.key.hashCode()){
               if (right==null){
                   right=new Bstree();
                   return right.add(kv);
               }
           }
           else if (kv.key.hashCode()<this.kv.key.hashCode()){
               if (left==null){
                   left=new Bstree();
                   return left.add(kv);
               }
           }return null;
       }
       void add(Bstree subtree){
           if (subtree!=null&&subtree.kv!=null){
            add(subtree.kv);
            add(subtree.left);
            add(subtree.right);
           }
       }

       @Override
       public String toString() {
           if (kv==null)
               return "";
           String str="";
           if (left!=null&&left.kv!=null)
               str+=left+", ";
           str+=kv;
           if (right!=null&&right.kv!=null)
               str+=", "+right;
           return str;
       }
   }
    @Override
    public void put(K Key, V value) {
        if (tree==null)
            tree=new Bstree();
        KeyValuePair kv=new KeyValuePair(Key,value);
        if (tree.find(Key)==null){
            tree.add(kv);
            pairs++;
        }
        else if (tree.find(Key)!=null){
            tree.find(Key).kv.val=value;
        }
    }

    @Override
    public void remove(K Key) {
       if (tree.find(Key)!=null){
           Bstree root=tree.find(Key);
           Bstree l=root.left;
           Bstree r=root.right;
           root.kv=null;
           root.left=null;
           root.right=null;
           tree.add(l);
           tree.add(r);
           pairs--;
       }

    }

    @Override
    public V get(K Key) {
       if (tree.find(Key)!=null){
           return tree.find(Key).kv.val;
       }
      else   return null;
    }

    @Override
    public int size() {
        return pairs;
    }
    @Override
    public String toString(){
      if (tree==null)return "";
      else return tree.toString();

    }}







































  /*  Bstree tree;
    int pairs;

    class Bstree {
        Bstree left, righ;
        Kvpai kv;
        Bstree add(Kvpai kv) {
            if (this.kv == null) {
                this.kv = kv;
                return this;
            } else if (kv.key.hashCode() > this.kv.key.hashCode()) {
                if (righ == null)
                    righ = new Bstree();
                return righ.add(kv);
            } else if (kv.key.hashCode() < this.kv.key.hashCode()) {
                if (left == null)
                    left = new Bstree();
                return left.add(kv);
            }
            return null;
        }
        void add(Bstree subtree) {
            if (subtree != null && subtree.kv != null) {
                add(subtree.kv);
                add(subtree.left);
                add(subtree.righ);
            }
        }
        Bstree find(K key) {
            if (this.kv != null) {
                if (key.equals(this.kv.key))
                    return this;
                else if (key.hashCode() > this.kv.key.hashCode()) {
                    if (righ == null)
                        return null;
                    return righ.find(key);
                } else if (key.hashCode() < this.kv.key.hashCode()) {
                    if (left == null)
                        return null;
                    return left.find(key);
                }

            }
            return null;
        }
        @Override
        public String toString() {
            if (kv==null)
                return "";
            String str="";
            if (left!=null&&left.kv!=null)
                str+=left+", ";
            str+=kv;
            if (righ!=null&&righ.kv!=null)
                str+=", "+righ;
            return str;
        }
    }
    class Kvpai {
        K key;
        V value;
        Kvpai(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    @Override
    public void put(K Key, V value) {
        if (tree == null)
            tree = new Bstree();
        if (tree.find(Key) == null) {
            Kvpai kv = new Kvpai(Key, value);
            tree.add(kv);
            pairs++;
        } else if (tree.find(Key) != null) {
                Bstree bs = tree.find(Key);
                bs.kv.value = value;
            }

    }

    @Override
    public void remove(K Key) {
        if (tree.find(Key)!=null){
            Bstree root=tree.find(Key);
            Bstree l= root.left;
            Bstree r=root.righ;
            root.left=null;
            root.righ=null;
            root.kv=null;
            tree.add(l);
            tree.add(r);
            pairs--;

        }    }
    @Override
    public V get(K Key) {
        if (tree.find(Key)!=null){
            Bstree root=tree.find(Key);
            return root.kv.value;
        }
        else return null;
    }

    @Override
    public int size() {
        return pairs;
    }

    @Override
    public String toString() {
        if (tree == null)
            return "";
        else return tree.toString();
    }
}









*/