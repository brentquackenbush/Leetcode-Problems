import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(3 * (2/3));
//        String s = "2-2*10-10";
//        System.out.println(calculate(s));
    }
    public static int calculate(String s) {
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = num * 10 + c - '0';
            if (i == s.length() - 1 || !Character.isDigit(c) && c!=' ') {
                switch(lastSign) {
                    case '+':
                        sum+=tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        sum+=tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                }
                lastSign = c;
                num=0;
            }
        }
        sum+=tempSum;
        return sum;
    }
//    public static int calculate(String s) {
//
//        if (s == null || s.isEmpty()) return 0;
//        int len = s.length();
//        Stack<Integer> stack = new Stack<Integer>();
//        int currentNumber = 0;
//        char operation = '+';
//        for (int i = 0; i < len; i++) {
//            char currentChar = s.charAt(i);
//            if (Character.isDigit(currentChar)) {
//                currentNumber = (currentNumber * 10) + (currentChar - '0');
//            }
//            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
//                if (operation == '-') {
//                    stack.push(-currentNumber);
//                }
//                else if (operation == '+') {
//                    stack.push(currentNumber);
//                }
//                else if (operation == '*') {
//                    stack.push(stack.pop() * currentNumber);
//                }
//                else if (operation == '/') {
//                    stack.push(stack.pop() / currentNumber);
//                }
//                operation = currentChar;
//                currentNumber = 0;
//            }
//        }
//        int result = 0;
//        while (!stack.isEmpty()) {
//            result += stack.pop();
//        }
//        return result;
//    }
}
