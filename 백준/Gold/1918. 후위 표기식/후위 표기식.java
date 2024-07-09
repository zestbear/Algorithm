import java.io.*;
import java.util.*;

class Main {

    public static int isOperation(String input) {
        if(input.equals("+") || input.equals("-")) return 1;
        else if(input.equals("*") || input.equals("/")) return 2;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        for (String input : inputs) {
            if (isOperation(input) == -1 && !input.equals("(") && !input.equals(")")) {
                sb.append(input);
            } else if (isOperation(input) != -1) {
                while (!stack.isEmpty()) {
                    int top = isOperation(stack.peek());
                    if (top < isOperation(input)) {
                        break;
                    }
                    sb.append(stack.pop());
                }
                stack.add(input);
            } else if (input.equals("(")) {
                stack.add(input);
            } else if (input.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    sb.append(stack.pop());
                }
                stack.pop(); // "(" pop
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}