import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers_가사검색 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));
	}
	
	public static int[] solution(String[] words, String[] queries) {
		Node root = new Node(new HashMap<Character, Node>(), new HashMap<Integer, Integer>());
		Node rroot = new Node(new HashMap<Character, Node>(), new HashMap<Integer, Integer>());
		int res[] = new int[queries.length];
		
		for(int i=0; i<words.length; i++) {
			insert(root, words[i], 0);
			insert(rroot, new StringBuffer(words[i]).reverse().toString(), 0);
		}
		
		for(int i=0; i<queries.length; i++) {
			String query = queries[i];
			if(query.charAt(0) == '?') {
				res[i] = select(rroot, new StringBuffer(query).reverse().toString(), 0);
			} else {
				res[i] = select(root, query, 0);
			}
		}
		
		return res;
	}
	
	public static int select(Node node, String query, int index) {
		if(index >= query.length()) {
			return 0;
		}
		
		char target = query.charAt(index);
		int gab = query.length() - index - 1;
		
		if(target == '?') {
			if(node.depth.containsKey(gab)) {
				return node.depth.get(gab);
			} else {
				return 0;
			}
		} else if(node.child.containsKey(target)) {
			return select(node.child.get(target), query, index+1);
		} else {
			return 0;
		}
	}
	
	public static void insert(Node node, String word, int index) {
		if(index >= word.length()) {
			return;
		}
		
		char target = word.charAt(index);
		int gab = word.length() - index - 1;
		
		if(node.depth.containsKey(gab)) {
			node.depth.put(gab, node.depth.get(gab)+1);
		} else {
			node.depth.put(gab,  1);
		}
		
		if(!node.child.containsKey(target)) {
			node.child.put(target, new Node(new HashMap<Character, Node>(), new HashMap<Integer, Integer>()));
		}
		
		insert(node.child.get(target), word, index+1);
	}
	
	private static class Node {
		Map<Character, Node> child;
		Map<Integer, Integer> depth;
		
		public Node(HashMap<Character, Node> child, HashMap<Integer, Integer> depth) {
			this.child = child;
			this.depth = depth;
		}
	}
}
