import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_호텔방배정 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution((long)10, new long[]{1,3,4,1,3,1})));
	}
	
	public static long[] solution(long k, long[] room_number) {
		long res[] = new long[room_number.length];
        Map<Long, Long> indexMap = new HashMap<Long, Long>();
        List<Long> save = new ArrayList<Long>();
        
        for(int i=0; i<room_number.length; i++) {
            long num = room_number[i];
            save.clear();
            
            while(indexMap.get(num) != null) {
                save.add(num);
                num = indexMap.get(num);
            }
            
            res[i] = num;
            for(int j=0; j<save.size(); j++) {
                indexMap.put(save.get(j), num+1);
            }
            indexMap.put(num, num+1);
        }
        
        return res;
	}
}
