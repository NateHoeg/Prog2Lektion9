package opgave03.models;

import java.util.ArrayList;

public class ArrayListRing<T> implements Ring<T> {


    //!!!Ikke færdig og der mangler nogle exceptions i nogle opgaver!!!


    private ArrayList<T> arrayList;
    private T currentItem;

    public ArrayListRing(T currentItem) {
        this.arrayList = new ArrayList<>();
        this.currentItem = currentItem;
    }

    @Override
    public void advance() {
        if(!isEmpty()) {
            int index = arrayList.indexOf(currentItem);
            if(index == arrayList.size() - 1) {
                currentItem = arrayList.get(0);
            }
            else {
                currentItem = arrayList.get(index + 1);
            }
        }
    }

    @Override
    public T getCurrentItem() {
        return currentItem;
    }

    @Override
    public void add(T item) {
        arrayList.add(item);
    }

    @Override
    public boolean removeItem(T item) {
        if(item.equals(currentItem)) {
            advance();
        }
        return arrayList.remove(item);

    }

    @Override
    public T removeCurrentItem() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return !arrayList.isEmpty();
    }
}
