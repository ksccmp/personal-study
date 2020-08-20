
public class Programmers_기지국설치 {
	public static void main(String[] args) {
		System.out.println(solution(11, new int[]{4,11}, 1));
		System.out.println(solution(16, new int[]{9}, 2));
	}
	
	public static int solution(int n, int[] stations, int w) {
        int length = w*2 + 1;
        int start = 1;
        int res = 0;
        
        for(int i=0; i<stations.length; i++) {
            if(stations[i] - w > start) {
                res = res + (stations[i] - w - start - 1)/length + 1;
            }
            start = stations[i] + w + 1;
        }
        
        if(start <= n) {
            res = res + (n - start)/length + 1;
        }
        
        return res;
    }
}
