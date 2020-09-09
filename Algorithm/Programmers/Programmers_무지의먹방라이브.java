import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_무지의먹방라이브 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,1,2}, 5));
		System.out.println(solution(new int[]{1,5,5,10,13}, 20));
	}
	
	public static int solution(int[] food_times, long k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<food_times.length; i++) {
            if(map.containsKey(food_times[i])) {
                map.put(food_times[i], map.get(food_times[i]) +1);
            } else {
                map.put(food_times[i], 1);
            }
        }
        
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        
        int removeCount = 0;
        int beforeVal = 0;
        long sum = 0;
        for(int i=0; i<list.size(); i++) {
            long temp = (long)(food_times.length-removeCount) * (long)(list.get(i) - beforeVal);
            
            if(sum + temp > k) {
                break;
            } else {
                sum = sum + temp;
                beforeVal = list.get(i);
                removeCount = removeCount + map.get(beforeVal);
            }
        }
        
        int temp = food_times.length-removeCount;
        if(temp == 0) {
            return -1;
        } else {
            k = (k - sum)%temp;
        
            int res = -1;
            for(int i=0; i<food_times.length; i++) {
                if(food_times[i] <= beforeVal) {
                    continue;
                }

                if(k == 0) {
                    res = i+1;
                    break;
                }

                k = k - 1;
            }

            return res;
        }
    }
}
