package question;

import java.util.LinkedList;
import java.util.Queue;

public class ATMQueue {

  public static void main(String[] args) {
    int k =2;
    int n=3;
    int [] amount = {2,5,1};
    Queue<Integer> queue = new LinkedList<>();
    for(int i=0; i< n ; i++) {
      queue.add(i);
    }

    int result [] = new int[3];

    int j=0;
    while (!queue.isEmpty()) {
      int curr = amount[queue.peek()];
      if(curr <= k) {
        result[j] = queue.poll()+1;
        j++;
      } else {
        amount[queue.peek()] =  curr - k;
        int q = queue.poll();
        queue.add(q);
      }
    }
    //answer is in array result
    for(int i = 0; i< result.length ; i++) {
      System.out.println(result[i]);
    }
  }
}
