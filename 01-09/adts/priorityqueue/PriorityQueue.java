package adts.priorityqueue;

public interface PriorityQueue<E, P extends Comparable<P>> {
  void push(E elem, P prio);

  E pop();

  E top();

  int size();
}
