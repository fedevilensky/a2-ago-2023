package adts.graph;

import java.util.Iterator;

public interface Graph {
  int vertices();

  Iterator<Integer> adjacents(int v);

  boolean hasEdge(int v, int w);

  int getEdge(int v, int w);

  int[][] adjecencyMatrix();

  void addEdge(int v, int w);

  void addEdge(int v, int w, int weight);

  void removeEdge(int v, int w);

}
