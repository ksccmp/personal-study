import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Programmers_튜플 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
		System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
		System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
		System.out.println(Arrays.toString(solution("{{123}}")));
		System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
	}
	
	public static int[] solution(String s) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        String change = s.substring(1, s.length()-1).replace("},{", "}{");
        
        String setStr = "";
        for(int i=0; i<change.length(); i++) {
            char target = change.charAt(i);
            
            if(target == '{') {
                list.add(new ArrayList<Integer>());
            } else if(target == '}' || target == ',') {
                ArrayList<Integer> save = list.get(list.size()-1);
                save.add(Integer.valueOf(setStr));
                setStr = "";
            } else {
                setStr = setStr + target;
            }
        }
        
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
           public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
               return o1.size() - o2.size();
           } 
        });
        
        int res[] = new int[list.size()];
        int index = 0;
        boolean visited[] = new boolean[100001];
        for(int i=0; i<list.size(); i++) {
            ArrayList<Integer> temp = list.get(i);
            for(int j=0; j<temp.size(); j++) {
                if(!visited[temp.get(j)]) {
                    visited[temp.get(j)] = true;
                    res[index++] = temp.get(j);
                }
            }
        }
        
        return res;
    }
}
