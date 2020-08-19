
public class Programmers_스티커모으기_2 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{14,6,5,11,3,9,2,10}));
		System.out.println(solution(new int[]{1,3,2,5,4}));
	}
	
	public static int solution(int sticker[]) {
        int n = sticker.length;
        int dp[][] = new int[n][2]; // [n][0]: 1번 스티커를 뜯을 경우, [n][1]: 1번 스티커를 뜯지 않을 경우
        if(n > 1) {
            dp[0][0] = sticker[0];
            dp[1][0] = Math.max(sticker[0], sticker[1]);
            dp[1][1] = sticker[1];

            int max = dp[1][0];

            for(int i=2; i<n-1; i++) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-2][0] + sticker[i]);
                max = Math.max(max, dp[i][0]);
            }

            for(int i=2; i<n; i++) {
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][1] + sticker[i]);
                max = Math.max(max, dp[i][1]);
            }

            return max;
        } else {
            return sticker[0];
        }
    }
}
