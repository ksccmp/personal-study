import java.util.Stack;

public class Programmers_짝지어제거하기 {
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
	}
	
	public static int solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if(stack.size() == 0) {
                stack.push(temp);
            } else {
                char top = stack.pop();
                if(temp != top) {
                    stack.push(top);
                    stack.push(temp);
                }
            }
        }
        
        return stack.size() == 0 ? 1 : 0;
    }
}
