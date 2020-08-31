public class Programmers_불량사용자 {
	public static void main(String[] args) {
		System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
		System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
		System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
	}
	
	static int res;
    static String array[];
    static boolean end;
    
    public static int solution(String[] user_id, String[] banned_id) {
        res = 0;
        array = new String[banned_id.length];
        end = false;
        makeC(user_id.length, banned_id.length, user_id, banned_id);
        
        return res;
    }
    
    public static void makeC(int n, int r, String user_id[], String banned_id[]) {
        if(r <= 0) {
        	end = false;
            makeP(0, banned_id);
            return;
        } else if(n < r) {
            return;
        } else {
            array[r-1] = user_id[n-1];
            makeC(n-1, r-1, user_id, banned_id);
            makeC(n-1, r, user_id, banned_id);
        }
    }
    
    public static void makeP(int n, String banned_id[]) {
    	if(end) {
    		return;
    	}
    	
    	if(n >= array.length) {
    		boolean visited[] = new boolean[array.length];
            int count = 0;
            firstLoop : for(int i=0; i<banned_id.length; i++) {
                for(int j=0; j<array.length; j++) {
                    if(!visited[j]) {
                        String ban = banned_id[i];
                        String user = array[j];
                        if(ban.length() == user.length()) {
                            for(int k=0; k<user.length(); k++) {
                                if(ban.charAt(k) != '*' && (ban.charAt(k) != user.charAt(k))) {
                                    break;
                                }
                                
                                if(k == user.length() - 1) {
                                    visited[j] = true;
                                    count++;
                                    continue firstLoop;
                                }
                            }
                        }
                    }
                }
            }
            
            if(count == banned_id.length) {
            	end = true;
                res++;
            }
            
            return;
    	}
    	
    	for(int a=n; a<array.length; a++) {
    		String temp = array[a];
    		array[a] = array[n];
    		array[n] = temp;
    		
    		makeP(n+1, banned_id);
    		
    		temp = array[a];
    		array[a] = array[n];
    		array[n] = temp;
    	}
    }
}
