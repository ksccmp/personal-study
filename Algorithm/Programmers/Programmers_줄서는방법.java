import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_줄서는방법 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4, 6)));
	}
	
    public static int[] solution(int n, long k) {
    	List<Integer> list = new ArrayList<Integer>();
        int res[] = new int[n];
        int select = 0;
        long fac = 1;
        
        for(int i=1; i<=n; i++) {
            fac = fac * i;
            list.add(i);
        }
        
        k--;
        while(n > 0) {
            fac = fac / n--;
            res[select++] = list.remove((int)(k/fac));
            k = k%fac;
        }
        
        return res;
    }
}
