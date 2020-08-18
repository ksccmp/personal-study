import java.util.Arrays;

public class Programmers_최고의집합 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2, 9)));
		System.out.println(Arrays.toString(solution(2, 1)));
		System.out.println(Arrays.toString(solution(2, 8)));
	}
	
	public static int[] solution(int n, int s) {
        int res[];
        
        int a = s/n;
        int b = s%n;
        
        if(a == 0) {
            res = new int[1];
            res[0] = -1;
        } else {
            res = new int[n];
            for(int i=0; i<n; i++) {
                res[i] = a;
            }

            for(int i=1; i<=b; i++) {
                res[n-i]++;
            }
        }
        
        return res;
    }
}
