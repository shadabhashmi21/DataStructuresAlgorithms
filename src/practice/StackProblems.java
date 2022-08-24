package practice;

import java.util.Arrays;
import java.util.Stack;

public class StackProblems {
    public static void reverseString(String str){
        Stack<Character> stack = new Stack<>();
        char[] ch = str.toCharArray();

        for (char c : ch) stack.push(c);

        for (int i = 0; i < str.length(); i++){
            ch[i] = stack.pop();
        }

        System.out.println(Arrays.toString(ch));
    }
}
