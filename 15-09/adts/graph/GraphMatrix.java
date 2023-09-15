package adts.graph;

import java.util.Iterator;

public class GraphMatrix implements Graph {
  int[][] mat;
  boolean isDirected;

  GraphMatrix(int vertices, boolean isDirected) {
    this.isDirected = isDirected;
    this.mat = new int[vertices + 1][vertices + 1];
    // this.mat = new int[vertices + 1][];
    // for (int i = 1; i <= vertices; i++) {
    // this.mat[i] = new int[vertices + 1];
    // }
  }

  @Override
  public int vertices() {
    return this.mat.length - 1;
  }

  @Override
  public Iterator<Integer> adjacents(int v) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'adjacents'");
  }

  @Override
  public boolean hasEdge(int v, int w) {
    return this.mat[v][w] != 0;
  }

  @Override
  public int getEdge(int v, int w) {
    if (!hasEdge(v, w)) {
      throw new RuntimeException("Edge does not exist");
    }
    return this.mat[v][w];
  }

  @Override
  public int[][] adjecencyMatrix() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'adjecencyMatrix'");
  }

  @Override
  public void addEdge(int v, int w) {
    this.mat[v][w] = 1;
    if (this.isDirected) {
      this.mat[w][v] = 1;
    }
  }

  @Override
  public void addEdge(int v, int w, int weight) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
  }

  @Override
  public void removeEdge(int v, int w) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeEdge'");
  }

}
