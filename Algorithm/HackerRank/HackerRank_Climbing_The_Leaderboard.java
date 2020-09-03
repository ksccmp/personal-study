import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HackerRank_Climbing_The_Leaderboard {
	public static int[] climbingLeaderboard(int[] scores, int[] alice) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<scores.length; i++) {
			set.add(scores[i]);
		}
		
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		int res[] = new int[alice.length];
		Arrays.fill(res, Integer.MAX_VALUE);
		for(int i=0; i<alice.length; i++) {
			search(0, list.size()-1, list, alice, res, i);
			if(res[i] == Integer.MAX_VALUE) {
				res[i] = list.size()+1;
			}
		}
		
		return res;
    }
	
	public static void search(int a, int b, List<Integer> list, int alice[], int res[], int index) {
		if(a >= b) {
			if(alice[index] >= list.get(a)) {
				res[index] = a+1;
			} else {
				res[index] = a+2;
			}
			return;
		}
		
		int mid = (a+b)/2;
		
		if(list.get(mid) == alice[index]) {
			res[index] = mid+1;
			return;
		} else if(list.get(mid) > alice[index]) {
			search(mid+1, b, list, alice, res, index);
		} else {
			search(a, mid, list, alice, res, index);
		}
	}
    
	public static void main(String[] args) {
		System.out.println(Arrays.toString(climbingLeaderboard(new int[]{100, 100, 50, 40, 40, 20, 10}, new int[]{5, 25, 50, 120})));
		System.out.println(Arrays.toString(climbingLeaderboard(new int[]{100, 90, 90, 80, 75, 60}, new int[]{50, 65, 77, 90, 102})));
	}
}
