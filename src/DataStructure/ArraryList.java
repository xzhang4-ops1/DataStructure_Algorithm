package DataStructure;

public class ArraryList<T> implements DataStructure.List<T> {
    private static final int INITIAL_SIZE = 2;
    private static final float GROWTH_FACTOR = 1.5f;
    private T[] values = (T[]) new Object[INITIAL_SIZE];
T value;
int elements;
    @Override
    public void add(T value) {
        if (elements == values.length) {  // we need to grow
            T[] tmp = (T[]) new Object[(int) (values.length * GROWTH_FACTOR)];
            for (int i = 0; i < values.length; i++) {
                tmp[i] = values[i];
            }
            values = tmp;
        }
        values[elements] = value;
        elements++;
    }


    @Override
    public void remove(int index) {
        elements--;
        for (int i = index; i < elements; i++) {
            values[i] = values[i+1];
        }
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public void reverse() {
        for (int i = 0; i < elements/2; i++) {
            T tmp = values[i];
            values[i] = values[(elements - 1)- i];
            values[(elements - 1)- i] = tmp;
        }
    }

    @Override
    public int size() {
        return elements;
    }
}
