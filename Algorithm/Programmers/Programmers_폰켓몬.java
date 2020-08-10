import java.util.HashSet;
import java.util.Set;

public class Programmers_폰켓몬 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,1,2,3}));
		System.out.println(solution(new int[]{3,3,3,2,2,4}));
		System.out.println(solution(new int[]{3,3,3,2,2,2}));
	}
	
    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        
        return set.size() >= nums.length/2 ? nums.length/2 : set.size();
    }
}
