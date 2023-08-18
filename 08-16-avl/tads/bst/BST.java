package tads.bst;

public interface BST<T extends Comparable<T>>{
    public void insert(T data);
    public void remove(T data);
    public boolean contains(T data);
    public int height();
    public int size();
}