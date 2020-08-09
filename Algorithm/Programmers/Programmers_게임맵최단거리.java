import java.util.LinkedList;
import java.util.Queue;

public class Programmers_게임맵최단거리 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
	}
	
	public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int diri[] = {0, 1, 0, -1};
        int dirj[] = {1, 0, -1, 0};
        int res = Integer.MAX_VALUE;
        
        Queue<Node> queue = new LinkedList<Node>();
        boolean visited[][] = new boolean[n][m];
        queue.add(new Node(0, 0, 1));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.i == n-1 && node.j == m-1) {
                res = Math.min(res, node.count);
                continue;
            }
            
            if(visited[node.i][node.j]) {
                continue;
            }
            
            visited[node.i][node.j] = true;
            
            for(int a=0; a<4; a++) {
                int nexti = node.i + diri[a];
                int nextj = node.j + dirj[a];
                if(nexti >= n || nexti < 0 || nextj >= m || nextj < 0 || visited[nexti][nextj] || maps[nexti][nextj] == 0) {
                    continue;
                }
                
                queue.add(new Node(nexti, nextj, node.count+1));
            }
        }
        
        if(res == Integer.MAX_VALUE) {
            res = -1;
        }
        
        return res;
    }
    
    static class Node {
        int i, j, count;
        public Node(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }
}
