package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.security.PublicKey;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> correct = new AListNoResizing<>();
      BuggyAList<Integer> broken = new BuggyAList<>();

      correct.addLast(5);
      correct.addLast(10);
      correct.addLast(15);

      broken.addLast(5);
      broken.addLast(10);
      broken.addLast(15);

      assertEquals(correct.size(), broken.size());

      assertEquals(correct.removeLast(), broken.removeLast());
      assertEquals(correct.removeLast(), broken.removeLast());
      assertEquals(correct.removeLast(), broken.removeLast());
  }

  @Test
  public void randomizedTest(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> R = new BuggyAList<>();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              R.addLast(randVal);

          } else if (operationNumber == 1) {
              // size
              int size = L.size();
              assertEquals(size, R.size());

          } else if (operationNumber == 2) {
              //getLast
              if (L.size() != 0 && R.size() != 0){
                  int out1 = L.getLast();
                  int out2 =  R.getLast();
                  assertEquals(out1, out2);

              }
          } else if (operationNumber == 3) {
              //removeLast
              if (L.size() != 0 && R.size() != 0){
                  int out1 = L.removeLast();
                  int out2 =  R.removeLast();
                  assertEquals(out1, out2);
                  
              }
          }
      }
  }
}
