package adts.table;

import java.util.Iterator;
import java.util.LinkedList;

import adts.hash.Hash;
import adts.pair.DeletePair;
import adts.pair.Pair;

public class ClosedHashTable<K, V> implements Table<K, V> {
  private Hash<K> hashFunc;
  /** DeletePair{K,V}[] */
  private Object[] arr;
  private int elements = 0;

  public ClosedHashTable(Hash<K> hashFunc, int expectedSize) {
    this.hashFunc = hashFunc;
    this.arr = new Object[2 * expectedSize + 1];
  }

  @Override
  public void add(K key, V value) {
    int h = abs(hashFunc.hash(key));
    int collissions = 0;
    int pos = h % arr.length;
    while (arr[pos] != null && !((DeletePair<K, V>) arr[pos]).isDeleted) {
      collissions++;
      pos = (h + collissions * collissions) % arr.length;
    }
    arr[pos] = new DeletePair<K, V>(key, value);
    elements++;
  }

  private int abs(int x) {
    if (x < 0) {
      return -x;
    } else {
      return x;
    }
  }

  @Override
  public void delete(K key) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public int size() {
    return elements;
  }

  @Override
  public boolean has(K key) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'has'");
  }

  @Override
  public V get(K key) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public Iterable<K> keys() {
    LinkedList<K> l = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      DeletePair<K, V> elem = (DeletePair<K, V>) arr[i];
      if (elem != null && !elem.isDeleted) {
        l.add(elem.fst);
      }
    }

    return l;
  }

  @Override
  public Iterable<V> values() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'values'");
  }

  @Override
  public Iterator<Pair<K, V>> iterator() {
    LinkedList<Pair<K, V>> l = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      DeletePair<K, V> elem = (DeletePair<K, V>) arr[i];
      if (elem != null && !elem.isDeleted) {
        l.add(elem);
      }
    }

    return l.iterator();
  }

}
