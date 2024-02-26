package opgave02.models;

public class ArrayBag<E> implements Bag<E> {

    // the array to hold the items
    private final E[] items;

    // current number of items in the bag,
    // items are at index 0..size-1
    private int size;

    /**
     * Create a bag with the given capacity.
     */
    public ArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        E[] empty = (E[]) new Object[capacity];
        items = empty;
        size = 0;
    }

    /**
     * Create a bag with capacity 10.
     */
    public ArrayBag() {
        this(10);
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E newEntry) {
        if (!isFull()) {
            int oldSize = size;
            if (size >= 1) {
                items[size] = newEntry;
                size += 1;
            } else {
                items[0] = newEntry;
                size += 1;
            }
            return oldSize < getCurrentSize();
        }
        return false;
    }

    @Override
    public E remove() {
        if (size > 0) {
            E olditem = items[size - 1];
            int oldSize = size;
            items[size - 1] = null;
            size -= 1;
            if (oldSize > getCurrentSize()) {
                return olditem;
            }
        }
        return null;
    }

    @Override
    public boolean remove(E anEntry) {
        int i = 0;
        while (i < size) {
            if (items[i].equals(anEntry)) {
                items[i] = items[size - 1];
                size -= 1;
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public void clear() {
        int i = 0;
        while (i < items.length) {
            remove();
            i++;
        }
    }

    @Override
    public int getFrequencyOf(E anEntry) {
        int frequency = 0;
        int i = 0;
        while (i < size) {
            if (items[i].equals(anEntry)) {
                frequency++;
            }
            i++;
        }
        return frequency;
    }

    @Override
    public boolean contains(E anEntry) {
        int i = 0;
        while (i < size) {
            if (items[i].equals(anEntry)) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public E[] toArray() {
        E[] newArray = (E[]) new Object[size];
        int i = 0;
        while (i < size) {
            newArray[i] = items[i];
            i++;
        }
        return newArray;
    }
}