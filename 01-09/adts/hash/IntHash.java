package adts.hash;

public class IntHash implements Hash<Integer> {

  @Override
  public int hash(Integer data) {
    return data;
  }

}
