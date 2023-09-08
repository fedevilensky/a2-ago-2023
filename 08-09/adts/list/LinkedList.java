package adts.list;

import java.util.Iterator;
import java.util.ListIterator;

public class LinkedList<T> implements List<T> {
  private Node head;
  private int length;

  class Node {
    T data;
    Node next = null;

    Node(T data) {
      this.data = data;
    }
  }

  class ListIterator implements Iterator<T> {
    Node curr;

    ListIterator(Node head) {
      curr = head;
    }

    @Override
    public boolean hasNext() {
      return curr != null;
    }

    @Override
    public T next() {
      T data = curr.data;
      curr = curr.next;
      return data;
    }
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator(head);
  }

  @Override
  public void add(T data) {
    if (length == 0) {
      head = new Node(data);
    } else {
      Node old = head;
      head = new Node(data);
      head.next = old;
    }
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

}
