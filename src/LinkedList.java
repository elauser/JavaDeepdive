import java.lang.reflect.Array;
import java.util.*;

public class LinkedList<T> implements List<T> {
    protected ListElement<T> nextElement;

    private class ListElement<T> {
        T value;
        ListElement<T> nextElement;

        public ListElement(T value) {
            this.value = value;
        }

        public void setNextElement(T t) {
            nextElement = new ListElement<T>(t);
        }
    }

    class ElementIterator implements Iterator<T> {
        ListElement<T> thisElement = nextElement;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(thisElement);
        }

        @Override
        public T next() {
            T value = thisElement.value;
            thisElement = thisElement.nextElement;
            return value;
        }
    }

    public LinkedList() {
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Override
    public int size() {
        int counter = 0;
        for (T element : this) {
            counter++;
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(nextElement);
    }

    @Override
    public boolean contains(Object o) {
        for (T element : this) {
            if (element.equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        int counter = 0;
        for (T element : this) {
            a[counter++] = (T1) element;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        if (Objects.isNull(t)) return false;

        if (Objects.isNull(this.nextElement)) {
            this.nextElement = new ListElement<T>(t);
            return true;
        }

        ListElement<T> elementIter = this.nextElement;
        while (Objects.nonNull(elementIter.nextElement)) {
            elementIter = elementIter.nextElement;
        }
        elementIter.nextElement = new ListElement<T>(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (Objects.isNull(this.nextElement)) return false;

        if (this.nextElement.value.equals(o)) {
            this.nextElement = this.nextElement.nextElement;
            return true;
        }

        ListElement<T> pointer = this.nextElement;
        while (Objects.nonNull(pointer.nextElement)) {
            if (pointer.nextElement.value.equals(o)) {
                pointer.nextElement = pointer.nextElement.nextElement;
                return true;
            }
            pointer = pointer.nextElement;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o : c){
            if(!this.contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if(c.size()==0) return false;
        for(T object: c){
            this.add(object);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        int size = this.size();
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index needs to be between 0 and size()-1 (" + size + "), but was " + index);
        }

        int counter = 0;
        for (T element : this) {
            if (counter++ == index) return element;
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException("Index needs to be between 0 and this.size()-1");
        }

        if (index == 0) {
            T value = this.nextElement.value;
            this.nextElement = this.nextElement.nextElement;
            return value;
        }

        ListElement<T> elementIter = this.nextElement;
        for (int i = 0; i < index - 1; i++) {
            elementIter = elementIter.nextElement;
        }
        T value = elementIter.nextElement.value;
        elementIter.nextElement = elementIter.nextElement.nextElement;
        return value;
    }

    @Override
    public int indexOf(Object o) {
        int counter = 0;
        for (T element : this) {
            if (element.equals(o)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


}
