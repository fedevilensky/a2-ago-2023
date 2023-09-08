package adts.list;

public interface List<T> extends Iterable<T> {
  void add(T data);

  void remove(T data);

  void removeAt(int pos);

  int size();

  T get(int pos);
}
