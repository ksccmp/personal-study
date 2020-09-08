import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programmers_후보키 {
	public static void main(String[] args) {
		System.out.println(solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
	}
	
	public static int solution(String[][] relation) {
        int col = relation[0].length;
        List<Integer> list = new ArrayList<Integer>();
        Set<String> set = new HashSet<String>();
        int res = 0;
        
        for(int a=0; a<(1<<col); a++) {
            list.clear();
            for(int j=0; j<col; j++) {
                if((a & (1<<j)) != 0) {
                    list.add(j);
                }
            }
            
            boolean ispossible = true;
            firstLoop : for(int i=0; i<relation.length; i++) {
                for(int j=i+1; j<relation.length; j++) {
                    for(int k=0; k<list.size(); k++) {
                        if(!relation[i][list.get(k)].equals(relation[j][list.get(k)])) {
                            break;
                        }
                        
                        if(k == list.size() - 1) {
                            ispossible = false;
                            break firstLoop;
                        }
                    }
                }
            }
            
            if(ispossible && list.size() != 0) {
            	int n = list.size();
            	boolean ispossible2 = true;
            	for(int b=0; b<(1<<n); b++) {
            		String str = "";
            		for(int c=0; c<n; c++) {
            			if((b & (1<<c)) != 0) {
            				str = str + list.get(c);
            			}
            		}
            		if(set.contains(str)) {
            			ispossible2 = false;
            			break;
            		}
            	}
            	
            	if(ispossible2) {
            		String str = "";
            		for(int b=0; b<list.size(); b++) {
            			str = str + list.get(b);
            		}
            		set.add(str);
            		res++;
            	}
            }
        }
        
        return res;
    }
}
