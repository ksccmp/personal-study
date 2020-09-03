import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HackerRank_Picking_Numbers {
	public static int pickingNumbers(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<a.size(); i++) {
            int target = a.get(i);
            if(map.containsKey(target)) {
                map.put(target, map.get(target)+1);
            } else {
                map.put(target, 1);
            }
        }

        List<Integer> keys = new ArrayList<Integer>(map.keySet());
        Collections.sort(keys, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int res = 2;
        for(int i=0; i<keys.size()-1; i++) {
            res = Math.max(res, Math.max(map.get(keys.get(i+1)), map.get(keys.get(i))));
            if(keys.get(i+1) - keys.get(i) == 1) {
                res = Math.max(res, map.get(keys.get(i+1)) + map.get(keys.get(i)));
            }
        }

        if(keys.size() == 1) {
            res = Math.max(res, map.get(keys.get(0)));
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		Integer array[] = new Integer[]{4,6,5,3,3,1};
		System.out.println(pickingNumbers(Arrays.asList(array)));
		array = new Integer[]{1,2,2,3,1,2};
		System.out.println(pickingNumbers(Arrays.asList(array)));
		array = new Integer[]{3,3,3,3,3,3};
		System.out.println(pickingNumbers(Arrays.asList(array)));
	}
}
