
public class Programmers_숫자의표현 {
	public static void main(String[] args) {
		System.out.println(solution(15));
	}
	
	public static int solution(int n) {
        int count = 0;
        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                sum = sum + (i+j);
                if(sum > n) {
                    break;
                } else if(sum == n) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
