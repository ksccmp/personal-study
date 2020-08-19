
public class Programmers_최댓값과최솟값 {
	public static void main(String[] args) {
		System.out.println(solution("1 2 3 4"));
		System.out.println(solution("-1 -2 -3 -4"));
		System.out.println(solution("-1 -1"));
	}
	
	public static String solution(String s) {
        String tempArray[] = s.split(" ");
        int array[] = new int[tempArray.length];
        
        for(int i=0; i<tempArray.length; i++) {
            array[i] = Integer.valueOf(tempArray[i]);
        }
        
        quickSort(0, array.length-1, array);
        
        return array[0] + " " + array[array.length-1];
    }
    
    public static void quickSort(int start, int end, int array[]) {
        if(start > end) {
            return;
        }
        
        int pivot = partition(start, end, array);
        quickSort(start, pivot-1, array);
        quickSort(pivot+1, end, array);
    }
    
    public static int partition(int start, int end, int array[]) {
        int p = start-1;
        for(int a=start; a<end; a++) {
            if(array[end] > array[a]) {
                int temp = array[++p];
                array[p] = array[a];
                array[a] = temp;
            }
        }
        
        int temp = array[++p];
        array[p] = array[end];
        array[end] = temp;
        
        return p;
    }
}
