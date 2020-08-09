
public class Programmers_징검다리 {
	public static void main(String[] args) {
		int distance = 25;
		int rocks[] = {2,14,11,21,17};
		int n = 2;
		
		System.out.println(solution(distance, rocks, n));
	}
	
	public static int solution(int distance, int[] rocks, int n) {
        quickSort(0, rocks.length-1, rocks);
        
        int left = 1;
        int right = distance;
        int res = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2; // 거리 최소값 중 최대값
            int prev = 0;
            int cnt = 0;
            
            for(int i=0; i<rocks.length; i++) {
                if(rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
            }
            
            if(cnt > n) {
                right = mid-1;
            } else {
                left = mid+1;
                res = Math.max(res, mid);
            }
        }
        
        return res;
    }
    
    public static void quickSort(int start, int end, int rocks[]) {
        if(start >= end) {
            return;
        }
        
        int pivot = partition(start, end, rocks);
        quickSort(start, pivot-1, rocks);
        quickSort(pivot+1, end, rocks);
    }
    
    public static int partition(int start, int end, int rocks[]) {
        int p = start-1;
        
        for(int i=start; i<end; i++) {
            if(rocks[end] > rocks[i]) {
                int temp = rocks[++p];
                rocks[p] = rocks[i];
                rocks[i] = temp;
            }
        }
        
        int temp = rocks[++p];
        rocks[p] = rocks[end];
        rocks[end] = temp;
        
        return p;
    }
}
