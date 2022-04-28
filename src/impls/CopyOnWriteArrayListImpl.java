package impls;

import java.io.Serializable;
import java.util.*;


/**
 * The "snapshot" style iterator method uses a
 *  * reference to the state of the array at the point that the iterator
 *  * was created. This array never changes during the lifetime of the
 *  * iterator, so interference is impossible and the iterator is
 *  * guaranteed not to throw {@code ConcurrentModificationException}.
 *  * The iterator will not reflect additions, removals, or changes to
 *  * the list since the iterator was created.  Element-changing
 *  * operations on iterators themselves ({@code remove}, {@code set}, and
 *  * {@code add}) are not supported. These methods throw
 *  * {@code UnsupportedOperationException}
 * */
public class CopyOnWriteArrayListImpl<E> implements List<E>, Cloneable, Serializable, RandomAccess {

    private static final long serialVersionUID = 1L;


    private final transient Object lock = new Object();
    private transient volatile Object[] array;

    public CopyOnWriteArrayListImpl(Object[] array) {
        setArray(new Object[0]);
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    @Override
    public int size() {
        return getArray().length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
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
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
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
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
