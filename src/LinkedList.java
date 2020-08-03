import java.util.*;

public class LinkedList<T> implements  List<T> {
    protected ListElement<T> nextElement;

    private class ListElement<T>{
        T value;
        ListElement<T> nextElement;

        public ListElement(T value) {
            this.value = value;
        }
        public void setNextElement(T t){
            nextElement = new ListElement<T>(t);
        }
    }

    public LinkedList() {
    }

    @Override
    public int size() {
       if(this.isEmpty()) return 0;

       int counter = 1;
       ListElement<T> next = this.nextElement;
       while(Objects.nonNull(next.nextElement)){
           next = next.nextElement;
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
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            ListElement<T> thisElement = nextElement;

            @Override
            public boolean hasNext() {
                return Objects.nonNull(thisElement) && Objects.nonNull( thisElement.nextElement);
            }

            @Override
            public T next() {
                thisElement = thisElement.nextElement;
                return thisElement.value;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if(Objects.isNull(t)) return false;

        if(Objects.isNull(this.nextElement)){
            this.nextElement = new ListElement<T>(t);
            return true;
        }

        ListElement<T> elementIter = this.nextElement;
        while(Objects.nonNull(elementIter.nextElement)){
            elementIter = elementIter.nextElement;
        }
        elementIter.nextElement = new ListElement<T>(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
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
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
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
