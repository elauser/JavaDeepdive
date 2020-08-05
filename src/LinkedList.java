import java.util.*;

public class LinkedList<T> implements List<T> {
    protected ListElement<T> nextElement;

    private class ListElement<T> {
        T value;
        ListElement<T> nextElement;

        private ListElement(T value) {
            this.value = value;
        }
        private ListElement(T value, ListElement<T> nextElement){
            this.value = value;
            this.nextElement = nextElement;
        }
    }

    class ValueIterator implements Iterator<T> {
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

    public LinkedList(ListElement<T> firstElement) {
        this.nextElement = firstElement;
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
        return new ValueIterator();
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
        boolean retValue = false;
        for(T element:this){
            if(!c.contains(element)){
                this.remove(element);
                retValue = true;
            }
        }
        return retValue;
    }

    @Override
    public void clear() {
        this.nextElement = null;
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
        int counter = 0;
        if(index == 0) this.nextElement.value = element;
        ListElement<T> elementIter = this.nextElement;
        for (int i = 0; i < index; i++) {
            elementIter = elementIter.nextElement;
        }
        T previousValue = elementIter.value;
        elementIter.value = element;
        return previousValue;
    }

    @Override
    public void add(int index, T element) {
        int listSize = this.size();
        if(index < 0 || index > listSize) {
            throw new IndexOutOfBoundsException("Index needs to be between 0 and this.size()-1");
        }

        if(index == 0) {
            this.nextElement = new ListElement<T>(element, this.nextElement);
            return;
        }

        ListElement<T> pointer = this.nextElement;
        for(int i = 0; i < index-1; i++){
            pointer = pointer.nextElement;
        }
        pointer.nextElement = new ListElement<>(element, pointer.nextElement);
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
        int lastHit = -1;
        int counter = 0;
        for(T element: this){
            if (o.equals(element)) {
                lastHit = counter;
            }
            counter++;
        }
        return lastHit;
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
        if(fromIndex==toIndex) return new LinkedList<>();
        if(fromIndex < 0 || toIndex > this.size()-1) throw new IndexOutOfBoundsException("Must be bigger than 0 and smaller than size-1");
        if(fromIndex>toIndex) throw new IllegalArgumentException("fromIndex can't be smaller than toIndex");

        List<T> newList = new LinkedList<>();

        int counter = 0;
        for(T element: this){
            if(counter >= fromIndex && counter < toIndex){
                newList.add(element);
                counter++;
            }
        }
        return newList;
    }

}
