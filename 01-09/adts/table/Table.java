package adts.table;

import adts.pair.Pair;

public interface Table<K, V> extends Iterable<Pair<K, V>> {
  void add(K key, V value);

  void delete(K key);

  int size();

  boolean has(K key);

  V get(K key);

  Iterable<K> keys();

  Iterable<V> values();

}
