import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Programmers_오픈채팅방 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
	}
	
	public static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<String, String>();
        Queue<Node> queue = new LinkedList<Node>();
        
        for(int i=0; i<record.length; i++) {
            String str[] = record[i].split(" ");
            String command = str[0];
            String id = str[1];
            
            if(command.equals("Leave")) {
                queue.add(new Node(command, id));
            } else {
                String nick = str[2];
                map.put(id, nick);
                if(command.equals("Enter")) {
                    queue.add(new Node(command, id));
                }
            }
        }
        
        String res[] = new String[queue.size()];
        for(int i=0 ;i<res.length; i++) {
            Node node = queue.poll();
            if(node.command.equals("Enter")) {
                res[i] = map.get(node.id) + "님이 들어왔습니다.";
            } else {
                res[i] = map.get(node.id) + "님이 나갔습니다.";
            }
        }
        
        return res;
    }
    
    private static class Node {
        String command, id;
        public Node(String command, String id) {
            this.command = command;
            this.id = id;
        }
    }
}
