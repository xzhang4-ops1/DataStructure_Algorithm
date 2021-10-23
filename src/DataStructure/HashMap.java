package DataStructure;

import java.util.LinkedList;

public class HashMap<K, V> implements Map<K, V> {
    class Kvpair{
        K key;
        V val;
        public Kvpair(K key, V val){
            this.key=key;
            this.val=val;
        }
        @Override
        public String toString() {
            return "("+key+ ", "+val+")";
        }
    }int parirs;

    final  static int defaflt=2;
    LinkedList <Kvpair> table[]=new LinkedList[defaflt];
    public int hash(K key){
        return Math.abs(key.hashCode())%2;
    }
    Kvpair find(K key){
        int bkt=hash(key);
        if (table[bkt]!=null){
            for (Kvpair kv:table[bkt]){
                if (kv.key.equals(key))
                    return kv;
            }
        }return null;
    }

    public void put(K Key, V value) {
        Kvpair kv=new Kvpair(Key,value);
        int bkt=hash(Key);
        if (table[bkt]==null)
            table[bkt]=new LinkedList<>();
        if (find(Key)==null){
            table[bkt].add(kv);
            parirs++;
        }
        if (find(Key)!=null){
            Kvpair kk=find(Key);
            kk.val=value;
        }
    }

    @Override
    public void remove(K Key) {
        int bkt=hash(Key);
        if (find(Key)!=null){
            Kvpair kv=find(Key);
            table[bkt].remove(kv);
            parirs--;
        }
    }

    @Override
    public V get(K Key) {
        int bkt=hash(Key);
        if (find(Key)!=null){
            Kvpair kv=find(Key);
            return kv.val;
        }
        return null;
    }

    @Override
    public int size() {
        return parirs;
    }
    @Override
    public String toString(){
        if (table==null)
            return "";
        String str="";
        for (int i=0;i<table.length;i++){
            if (table[i]!=null){
                for (Kvpair kv:table[i]){
                    if (!str.equals(""))
                        str+=", ";
                    str+=kv;
                }
            }
        }return str;
    }
}





















































    /*
    static final int Defalt_buket=2;
    LinkedList<Kvpair>[] table=new LinkedList[Defalt_buket];
    int element;
    class Kvpair{
        K Key;
        V value;
        Kvpair(K Key, V value){
            this.Key=Key;
            this.value=value;
        }

        @Override
        public String toString() {
            return "("+Key+", "+ value+")";
        }
    }
    Kvpair find(K key){
        int bkt=hash(key);
        if (table[bkt]==null)
            return null;
        else {
            for (Kvpair kv:table[bkt]){
                if (kv.Key.equals(key))
                    return kv;
            }
        }return null;
    }
    public int hash(K key){
        return Math.abs(key.hashCode())%2;
    }
    @Override
    public void put(K Key, V value) {
        int bkt=hash(Key);
        if (table[bkt]==null)
            table[bkt]=new LinkedList<>();
        if (find(Key)==null){
            Kvpair kv=new Kvpair(Key, value);
            table[bkt].add(kv);
            element++;
        }else if (find(Key)!=null){
            Kvpair kv=find(Key);
            kv.value=value;
        }
    }
    @Override
    public void remove(K Key) {
        int bkt=hash(Key);
        if (find(Key)!=null){
            Kvpair kv=find(Key);
            table[bkt].remove(kv);
            element--;
        }
    }
    @Override
    public V get(K Key) {
        if (find(Key)!=null){
            Kvpair kv=find(Key);
            return kv.value;
        }
       else return null;
    }

    @Override
    public int size() {
        return element;
    }

    @Override
    public String toString() {

        String str="";
        for (int i=0;i<table.length;i++){
            if (table[i]!=null)
            for (Kvpair kv:table[i]){
                if (!str.equals(""))
                    str+=", ";
                str+=kv;
            }
        }return str;
    }
}

*/




























































