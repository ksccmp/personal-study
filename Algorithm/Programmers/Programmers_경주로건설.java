import java.util.LinkedList;
import java.util.Queue;

public class Programmers_경주로건설 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
		System.out.println(solution(new int[][]{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}));
		System.out.println(solution(new int[][]{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}));
		System.out.println(solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}));
	}
	
	public static int solution(int[][] board) {
        int N = board.length;
        int visited[][][] = new int[N][N][2]; // 0: 가로로 왔니? 1: 세로로 왔니?
        int dirj[] = {1, 0, -1, 0};
        int diri[] = {0, 1, 0, -1};
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<2; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        int res = Integer.MAX_VALUE;
        if(board[0][1] == 0) {
        	queue.add(new Node(0, 1, 100, 0, 0));
        }
        if(board[1][0] == 0) {
        	queue.add(new Node(1, 0, 100, 1, 1));
        }
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(node.i == N-1 && node.j == N-1) {
                res = Math.min(res, node.val);
                continue;
            }
            
            if(board[node.i][node.j] == 1) {
                continue;
            }
            
            if(visited[node.i][node.j][node.isdir] <= node.val) {
                continue;
            }
            
            visited[node.i][node.j][node.isdir] = node.val;
            
            for(int a=0; a<4; a++) {
                if(Math.abs(node.curdir-a) == 2) {
                    continue;
                }
                
                int nexti = node.i + diri[a];
                int nextj = node.j + dirj[a];
                if(nexti >= N || nexti < 0 || nextj >= N || nextj < 0) {
                    continue;
                }
                if(board[nexti][nextj] == 1) {
                    continue;
                }
                
                int temp = Math.abs(a - node.curdir);
                if(temp % 2 == 0) {
                    if(visited[nexti][nextj][0] > node.val + 100) {
                        queue.add(new Node(nexti, nextj, node.val + 100, a, node.isdir));
                    }
                } else {
                    if(visited[nexti][nextj][1] > node.val + 600) {
                        queue.add(new Node(nexti, nextj, node.val + 600, a, (node.isdir+1)%2));
                    }
                }
            }
        }
        
        return res;
    }
    
    private static class Node {
        int i, j, val, curdir, isdir;
        public Node(int i, int j, int val, int curdir, int isdir) {
            this.i = i;
            this.j = j;
            this.val = val;
            this.curdir = curdir;
            this.isdir = isdir;
        }
    }
}
