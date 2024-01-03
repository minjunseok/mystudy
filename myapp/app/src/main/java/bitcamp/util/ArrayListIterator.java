package bitcamp.util;

public class ArrayListIterator<E> implements Iterator<E>{

    ArrayList<E> list;
    int cursor;

    public ArrayListIterator(ArrayList<E> list){
        this.list = list;
    }


    @Override
    public E next() {
        return list.get(cursor++);
    }

    @Override
    public boolean hasNext() {
        return cursor >= 0 && cursor < list.size();


    }
}
