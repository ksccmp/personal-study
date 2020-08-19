
public class Programmers_올바른괄호의갯수 {
	public static void main(String[] args) {
		System.out.println(solution(2));
		System.out.println(solution(3));
	}
	
	static int count;
    public static int solution(int n) {
    	count = 0;
        solve(0, 0, n);
        
        return count;
    }
    
    public static void solve(int left, int right, int n) {
        if(left + right >= n*2) {
            if(left == right) {
                count++;
            }
            return;
        }
        
        if(left < n) {
            solve(left+1, right, n);
            if(left > right) {
                solve(left, right+1, n);
            }
        } else if(left == n) {
            solve(left, right+1, n);
        }
    }
}
