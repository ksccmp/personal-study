
public class Programmers_다음큰숫자 {
	public static void main(String[] args) {
		System.out.println(solution(78));
		System.out.println(solution(15));
	}
	
	public static int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;
        
        for(int i=0; i<binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                count++;
            }
        }
        
        for(int i=n+1; i<=1000000; i++) {
            binary = Integer.toBinaryString(i);
            int tempcount = 0;
            for(int j=0; j<binary.length(); j++) {
                if(binary.charAt(j) == '1') {
                    tempcount++;
                }
            }
            
            if(count == tempcount) {
                return i;
            }
        }
        
        return -1;
    }
}
