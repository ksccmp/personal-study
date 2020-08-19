
public class Programmers_쿠키구입 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,1,2,3}));
		System.out.println(solution(new int[]{1,2,4,5}));
	}
	
	public static int solution(int[] cookie) {
		int n = cookie.length;
        int dp[][] = new int[n][n];
        
        for(int i=0; i<n; i++) {
            dp[i][i] = cookie[i];
        }
        
        for(int k=1; k<n; k++) {
            for(int i=0; i+k<n; i++) {
                dp[i][i+k] = dp[i][i+k-1] + dp[i+k][i+k];
            }
        }
        // dp[0][1] = dp[0][0] + dp[1][1]
        // dp[1][2] = dp[1][1] + dp[2][2]
        // ...
        // dp[0][2] = dp[0][1] + dp[2][2]
        // dp[1][3] = dp[1][2] + dp[3][3]
        // ...
        // dp[0][3] = dp[0][2] + dp[3][3]
        
        int res = 0;
        for(int k=0; k<n; k++) {
            int left = 0;
            int right = 1;
            while((k-left) >= 0 && (k+right) < n) {
                if(dp[k-left][k] == dp[k+1][k+right]) {
                    res = Math.max(res, dp[k-left][k]);
                    right++;
                    left++;
                } else if(dp[k-left][k] > dp[k+1][k+right]) {
                    right++;
                } else {
                    left++;
                }
            }
        }
        
        return res;
    }
}
