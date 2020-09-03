import java.io.IOException;

public class HackerRank_Forming_a_Magic_Square {
	static int min;
	public static int formingMagicSquare(int[][] s) {
        int array[] = new int[]{1,2,3,4,5,6,7,8,9};
        min = Integer.MAX_VALUE;
        		
        makeP(0, array, s);
        
        return min;
    }
	
	public static void makeP(int n, int array[], int s[][]) {
		if(n >= array.length) {
			if(isMagic(array)) {
				int sum = 0;
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						sum = sum + Math.abs(array[i*3+j] - s[i][j]);
					}
				}
				
				min = Math.min(min, sum);
			}
			
			return;
		}
		
		for(int a=n; a<array.length; a++) {
			int temp = array[a];
			array[a] = array[n];
			array[n] = temp;
			
			makeP(n+1, array, s);
			
			temp = array[a];
			array[a] = array[n];
			array[n] = temp;
		}
	}
	
	public static boolean isMagic(int array[]) {
		int val = -1;
		for(int i=0; i<3; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for(int j=0; j<3; j++) {
				sum1 = sum1 + array[i*3+j];
			}
			for(int j=0; j<3; j++) {
				sum2 = sum2 + array[i+j*3];
			}
			
			if(val == -1) {
				val = sum1;
			}
			
			if(val != sum1 || val != sum2) {
				return false;
			}
		}
		
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<3; i++) {
			sum1 = sum1 + array[i*3+i];
			sum2 = sum2 + array[(i+1)*2];
		}
		
		if(val != sum1 || val != sum2) {
			return false;
		}
		
		return true;
	}

    public static void main(String[] args) throws IOException {
        System.out.println(formingMagicSquare(new int[][]{{4,9,2},{3,5,7},{8,1,5}}));
        System.out.println(formingMagicSquare(new int[][]{{4,8,2},{4,5,7},{6,1,6}}));
        System.out.println(formingMagicSquare(new int[][]{{1,1,1},{1,1,1},{1,1,1}}));
    }
}
