package stack;

import java.util.Stack;

public class Problems {
    public static void reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        char[] ch = str.toCharArray();

        for (char c : ch) {
            stack.push(c);
        }

        for (int i = 0; i < str.length(); i++) {
            ch[i] = stack.pop();
        }

        System.out.println(ch);
    }

    public static void main(String[] args) {
        reverseString("Mango");
    }
}
