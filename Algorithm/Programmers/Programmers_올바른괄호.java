import java.util.Stack;

public class Programmers_올바른괄호 {
	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));
	}
	
	public static boolean solution(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add(1);
            } else {
                if(stack.size() == 0) {
                    return false;
                }
                
                stack.pop();
            }
        }
        
        if(stack.size() != 0) {
            return false;
        }
        
        return true;
    }
}
