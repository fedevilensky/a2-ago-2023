package adts.pair;

public class Pair<T1, T2> {
  public T1 fst;
  public T2 snd;

  public Pair() {
  }

  public Pair(T1 fst) {
    this.fst = fst;
  }

  public Pair(T1 fst, T2 snd) {
    this.fst = fst;
    this.snd = snd;
  }
}
