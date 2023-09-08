import java.util.Iterator;

import adts.list.*;

public class Main {
  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      l.add(i);
    }

    System.out.println("Imprimimos con el while");
    Iterator<Integer> it = l.iterator();
    while (it.hasNext()) {
      int i = it.next();
      System.out.println(i);
    }

    System.out.println("\nImprimimos con el for");
    for (int i : l) {
      System.out.println(i);
    }
  }
}
