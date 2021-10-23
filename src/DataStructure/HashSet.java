package DataStructure;
import java.util.LinkedList;

public class HashSet<T> implements Set<T>{

    static final int Defalt_buket=2;
    LinkedList<T>[] table=new LinkedList[Defalt_buket];
    int elements;
    public int hash(T key){
        return Math.abs(key.hashCode())%2;
    }
    T find(T ele){
        int bkt=hash(ele);
        if (table[bkt]==null)
            return null;
        else {
            for (T kv:table[bkt]){
                if (kv.hashCode()==ele.hashCode())
                    return kv;
            }
        }return null;
    }
    @Override
    public void add(T element) {
        int bkt=hash(element);
        if (table[bkt]==null)
            table[bkt]=new LinkedList<>();
        if (find(element)==null){
            table[bkt].add(element);
            elements++;
        }
    }

    @Override
    public void remove(T element) {
        int bkt=hash(element);
        if (find(element)!=null){
            table[bkt].remove(element);
            elements--;
        }
    }

    @Override
    public boolean contains(T element) {
        if (find(element)!=null)
            return true;
      else   return false;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        String str="";
        for (int i=0;i<table.length;i++){
            if (table[i]!=null)
                for (T kv:table[i]){
                    if (!str.equals(""))
                        str+=", ";
                    str+=kv;
                }
        }return str;
    }

}
