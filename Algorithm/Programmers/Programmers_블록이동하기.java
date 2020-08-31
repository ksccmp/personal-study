import java.util.LinkedList;
import java.util.Queue;

public class Programmers_블록이동하기 {
	public static void main(String[] args) {
		 System.out.println(solution(new int[][]{{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}}));
		 System.out.println(solution(new int[][]{{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}}));
		 System.out.println(solution(new int[][]{{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0}}));
		 System.out.println(solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}}));
	}
	
	public static int solution(int[][] board) {
        int dirj[] = {1, 0 ,-1, 0};
        int diri[] = {0 ,1 ,0 ,-1};
        int n = board.length;
        int res = -1;
        boolean visited[][][][] = new boolean[n][n][n][n];
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0, 0, 0, 1, 0));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(visited[node.i1][node.j1][node.i2][node.j2] || board[node.i1][node.j1] == 1 || board[node.i2][node.j2] == 1) {
                continue;
            }
            
            if((node.i1 == n-1 && node.j1 == n-1) || (node.i2 == n-1 && node.j2 == n-1)) {
                res = node.count;
                break;
            }
            
            visited[node.i1][node.j1][node.i2][node.j2] = visited[node.i2][node.j2][node.i1][node.j1] = true;
            
            for(int a=0; a<4; a++) {
                int nexti1 = node.i1 + diri[a];
                int nextj1 = node.j1 + dirj[a];
                int nexti2 = node.i2 + diri[a];
                int nextj2 = node.j2 + dirj[a];
                
                if(nexti1 >= n || nexti1 < 0 || nextj1 >= n || nextj1 < 0 || nexti2 >= n || nexti2 < 0 || nextj2 >= n || nextj2 < 0 || visited[nexti1][nextj1][nexti2][nextj2] || board[nexti1][nextj1] == 1 || board[nexti2][nextj2] == 1) {
                    continue;
                }

                queue.add(new Node(nexti1, nextj1, nexti2, nextj2, node.count+1));
            }
            
            if(node.i1 == node.i2) {
                if(node.j1 > node.j2) {
                    int temp = node.j1;
                    node.j1 = node.j2;
                    node.j2 = temp;
                }
                
                if(node.i1 + 1 < n && board[node.i1+1][node.j1] == 0 && board[node.i2+1][node.j2] == 0) {
                    queue.add(new Node(node.i1, node.j1, node.i1+1, node.j1, node.count+1));
                    queue.add(new Node(node.i2+1, node.j2, node.i2, node.j2, node.count+1));
                }
                
                if(node.i1 - 1 >= 0 && board[node.i1-1][node.j1] == 0 && board[node.i2-1][node.j2] == 0) {
                    queue.add(new Node(node.i1, node.j1, node.i1-1, node.j1, node.count+1));
                    queue.add(new Node(node.i2-1, node.j2, node.i2, node.j2, node.count+1));
                }
            } else if(node.j1 == node.j2) {
                if(node.i1 > node.i2) {
                    int temp = node.i1;
                    node.i1 = node.i2;
                    node.i2 = temp;
                }
                
                if(node.j1 + 1 < n && board[node.i1][node.j1+1] == 0 && board[node.i2][node.j2+1] == 0) {
                    queue.add(new Node(node.i1, node.j1, node.i1, node.j1+1, node.count+1));
                    queue.add(new Node(node.i2, node.j2+1, node.i2, node.j2, node.count+1));
                }
                
                if(node.j1 - 1 >= 0 && board[node.i1][node.j1-1] == 0 && board[node.i2][node.j2-1] == 0) {
                    queue.add(new Node(node.i1, node.j1, node.i1, node.j1-1, node.count+1));
                    queue.add(new Node(node.i2, node.j2-1, node.i2, node.j2, node.count+1));
                }
            }
        }
        
        return res;
    }
    
    private static class Node {
        int i1, j1, i2, j2, count;
        public Node(int i1, int j1, int i2, int j2, int count) {
            this.i1 = i1;
            this.j1 = j1;
            this.i2 = i2;
            this.j2 = j2;
            this.count = count;
        }
    }
}
