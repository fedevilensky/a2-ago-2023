package adts.list;

import java.util.Iterator;

public class ArrayList<T> implements List<T> {
  Object[] arr = new Object[100];
  int length = 0;

  class ArrayListIterator implements Iterator<T> {
    Object[] arr;
    int length;
    int currPos = 0;

    ArrayListIterator(Object[] arr, int length) {
      this.arr = arr;
      this.length = length;
    }

    @Override
    public boolean hasNext() {
      return this.currPos < length;
    }

    @Override
    public T next() {
      T data = (T) arr[currPos];
      currPos++;
      return data;
    }

  }

  @Override
  public Iterator<T> iterator() {
    return new ArrayListIterator(arr, length);
  }

  @Override
  public void add(T data) {
    if (arr.length < length) {
      Object[] old = arr;
      arr = new Object[old.length * 2];
      for (int i = 0; i < old.length; i++) {
        arr[i] = old[i];
      }
    }

    arr[length] = data;
    length++;
  }

  @Override
  public void remove(T data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public void removeAt(int pos) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeAt'");
  }

  @Override
  public int size() {
    return length;
  }

  @Override
  public T get(int pos) {
    return (T) arr[pos];
  }
}
