package DataStructure;

public interface Map<K,V> {
    public void put(K Key,V value);
    public void remove(K Key);
    public V get(K Key);
    public int size();
}
