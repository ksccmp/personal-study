
public class Programmers_소수만들기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,2,3,4}));
		System.out.println(solution(new int[]{1,2,7,6,4}));
	}
	
	static int array[];
    static boolean visited[];
    static int res;
    public static int solution(int[] nums) {
        int n = nums.length;
        int r = 3;
        
        array = new int[r];
        visited = new boolean[3000];
        res = 0;
        
        makeC(n, r, nums);
        
        return res;
    }
    
    public static void makeC(int n, int r, int nums[]) {
        if(r <= 0) {
            int sum = 0;
            for(int i=0; i<array.length; i++) {
                sum = sum + array[i];
            }
            
            if(visited[sum]) {
                res++;
            } else {
                if(isPrime(sum)) {
                    visited[sum] = true;
                    res++;
                }
            }
            
            return;
        } else if(n < r) {
            return;
        } else {
            array[r-1] = nums[n-1];
            makeC(n-1, r-1, nums);
            makeC(n-1, r, nums);
        }
    }
    
    public static boolean isPrime(int a) {
        for(int i=2; i<=a/2; i++) {
            if(a%i == 0) {
                return false;
            }
        }
        return true;
    }
}
