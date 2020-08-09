
public class Programmers_땅따먹기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
	}
	
	public static int solution(int[][] land) {
        int sum[][] = new int[land.length][4];
        for(int j=0; j<land[0].length; j++) {
            sum[0][j] = land[0][j];
        }
        
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<land[i].length; j++) {
                for(int k=0; k<land[i].length; k++) {
                    if(k == j) {
                        continue;
                    }
                    
                    sum[i][j] = Math.max(sum[i][j], sum[i-1][k]);
                }
                sum[i][j] = sum[i][j] + land[i][j];
            }
        }
        
        int res = 0;
        
        for(int j=0; j<land[0].length; j++) {
            res = Math.max(res, sum[land.length-1][j]);
        }
        
        return res;
    }
}
