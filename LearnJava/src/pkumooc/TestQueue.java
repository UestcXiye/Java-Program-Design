package pkumooc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuwenchen
 * @create 2020-07-09 20:52
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<5;i++) q.offer(i);
        while(!q.isEmpty()) System.out.println(q.poll());
    }
}
