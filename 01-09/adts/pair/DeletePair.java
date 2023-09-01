package adts.pair;

public class DeletePair<T1, T2> extends Pair<T1, T2> {
  public boolean isDeleted = false;

  public DeletePair() {
  }

  public DeletePair(T1 fst) {
    this.fst = fst;
  }

  public DeletePair(T1 fst, T2 snd) {
    this.fst = fst;
    this.snd = snd;
  }
}
