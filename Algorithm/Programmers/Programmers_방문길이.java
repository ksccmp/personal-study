
public class Programmers_방문길이 {
	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
		System.out.println(solution("LULLLLLLU"));
	}
	
    public static int solution(String dirs) {
    	int mapsize = 11;
        boolean maps[][][][] = new boolean[mapsize][mapsize][mapsize][mapsize];
        
        int i = 5;
        int j = 5;
        int count = 0;
        
        for(int a=0; a<dirs.length(); a++) {
            int nexti = i;
            int nextj = j;
            switch(dirs.charAt(a)) {
                case 'L':
                    nextj--;
                    break;
                    
                case 'R':
                    nextj++;
                    break;
                    
                case 'U':
                    nexti--;
                    break;
                    
                case 'D':
                    nexti++;
                    break;
            }
            
            if(nexti >= 0 && nexti < mapsize && nextj >= 0 && nextj < mapsize) {
                if(!maps[i][j][nexti][nextj] && !maps[nexti][nextj][i][j]) {
                    count++;
                    maps[i][j][nexti][nextj] = maps[nexti][nextj][i][j] = true;
                }
                
                i = nexti;
                j = nextj;
            }
        }
        
        return count;
    }
}
