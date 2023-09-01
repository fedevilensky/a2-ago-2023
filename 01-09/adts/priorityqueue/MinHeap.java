package adts.priorityqueue;

import adts.pair.Pair;

public class MinHeap<E, P extends Comparable<P>> implements PriorityQueue<E, P> {
  /** Pair{K,V}[] */
  private Object[] arr;
  private int elements;

  public MinHeap(int expectedSize) {
    arr = new Object[expectedSize + 1];
  }

  @Override
  public void push(E elem, P prio) {
    elements++;
    if (elements >= arr.length) {
      // ACA SE ROMPE, ARREGLENLOOOOO!!!!!
    }
    arr[elements] = new Pair<E, P>(elem, prio);
    siftUp(elements);
  }

  private void siftUp(int pos) {
    if (pos == 1) {
      return;
    }
    int parentPos = pos / 2;
    Pair<E, P> curr = (Pair<E, P>) arr[pos];
    Pair<E, P> parent = (Pair<E, P>) arr[parentPos];
    if (curr.snd.compareTo(parent.snd) < 0) {
      swap(pos, parentPos);
      siftUp(parentPos);
    }
  }

  @Override
  public E pop() {
    E ret = top();
    arr[1] = arr[elements];
    elements--;
    siftDown(1);

    return ret;
  }

  @Override
  public E top() {
    if (size() < 1) {
      throw new RuntimeException("Heap is empty");
    }
    return ((Pair<E, P>) arr[1]).fst;
  }

  @Override
  public int size() {
    return elements;
  }

}
