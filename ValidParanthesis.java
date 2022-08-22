
import java.util.*;
public class ValidParanthesis {

    public static void main(String[] args) {
        String s = "()()[]{}{}";
        String sbad = "()()[{}{}";
        System.out.println(s + ", is there valid paranthesis?: " + isValid(s));
        System.out.println(sbad + ", is there valid paranthesis?: " + isValid(sbad));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
