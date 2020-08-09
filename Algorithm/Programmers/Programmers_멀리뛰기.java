
public class Programmers_멀리뛰기 {
	public static void main(String[] args) {
		System.out.println(solution(4));
		System.out.println(solution(3));
	}
	
	public static long solution(int n) {
        long res[] = new long[n+1];
        res[0] = 1;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=2; j++) {
                if(i - j >= 0) {
                    res[i] = (res[i] + res[i-j])%1234567;
                }
            }
        }
        
        return res[n];
    }
}
