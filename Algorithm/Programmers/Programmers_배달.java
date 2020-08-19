
public class Programmers_배달 {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3));
		System.out.println(solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4));
	}
	
	public static int solution(int N, int[][] road, int K) {
        int array[][] = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                array[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=0; i<road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int val = road[i][2];
            
            array[b][a] = array[a][b] = Math.min(array[a][b], val);
        }
        
        int minIndex = 1;
        boolean visited[] = new boolean[N+1];
        int min[] = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        min[minIndex] = 0;
        
        while(true) {
            if(minIndex < 0) {
                break;
            }
            
            visited[minIndex] = true;
            for(int i=1; i<=N; i++) {
                if(!visited[i] && array[minIndex][i] != Integer.MAX_VALUE) {
                    min[i] = Math.min(min[i], min[minIndex] + array[minIndex][i]);
                }
            }
            
            minIndex = -1;
            
            for(int i=1; i<=N; i++) {
                if(!visited[i]) {
                    if(minIndex == -1) {
                        minIndex = i;
                    } else {
                        if(min[minIndex] > min[i]) {
                            minIndex = i;
                        }
                    }
                }
            }
        }
        
        int res = 0;
        for(int i=1; i<=N; i++) {
            if(min[i] <= K) {
                res++;
            }
        }
        
        return res;
    }
}
