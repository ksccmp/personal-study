
public class Programmers_문자열압축 {
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}
	
	public static int solution(String s) {
		int res = Integer.MAX_VALUE;
        for(int k=1; k<=s.length()/2; k++) {
            String resString = "";
            String temp = "";
            int count = 0;
            
            for(int j=0; j<s.length(); j=j+k) {
                String a = s.substring(j, Math.min(j+k, s.length()));
                if(temp.equals("")) {
                    count = 1;
                } else if(temp.equals(a)) {
                    count++;
                } else {
                    if(count == 1) {
                        resString = resString + temp;
                    } else {
                        resString  = resString + count + temp;
                    }
                    count = 1;
                }
                temp = a;
            }
            
            if(count == 1) {
            	resString = resString + temp;
            } else if(count > 1) {
            	resString = resString + count + temp;
            }
            
            res = Math.min(res, resString.length());
        }
        
        return s.length() == 1 ? 1 : res;
    }
}
