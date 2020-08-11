import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_야근지수 {
	public static void main(String[] args) {
		System.out.println(solution(4, new int[]{4,3,3}));
		System.out.println(solution(1, new int[]{2,1,2}));
		System.out.println(solution(3, new int[]{1,1}));
	}

    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            } 
         });
         
         for(int i=0; i<works.length; i++) {
             pqueue.add(works[i]);
         }
         
         for(int i=1; i<=n; i++) {
             if(!pqueue.isEmpty()) {
                 int a = pqueue.poll();
                 if(a-1 > 0) {
                     pqueue.add(a-1);
                 }
             } else {
                 break;
             }
         }
         
         long res = 0;
         
         while(!pqueue.isEmpty()) {
             res = res + (long)(Math.pow(pqueue.poll(), 2));
         }
         
         return res;
    }
}
