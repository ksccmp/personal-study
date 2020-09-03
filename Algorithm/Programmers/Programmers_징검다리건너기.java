import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programmers_징검다리건너기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
	}
	
	public static int solution(int[] stones, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<stones.length; i++) {
            set.add(stones[i]);
        }
        
        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        
        int min = 0;
        firstloop : for(int i=0; i<list.size(); i++) {
            min = list.get(i);
            int index = -1;
            while(index < stones.length) {
                for(int j=k; j>0; j--) {
                    if(index+j >= stones.length) {
                        continue firstloop;
                    }
                    
                    if(stones[index+j]-min > 0) {
                        index = index+j;
                        break;
                    }
                    
                    if(j == 1) {
                        break firstloop;
                    }
                }
            }
        }
        
        return min;
    }
}
