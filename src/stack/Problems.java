package stack;

import java.util.Arrays;
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

        System.out.println("Reversed String = " + Arrays.toString(ch));
    }

    public static void nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i= arr.length-1; i>=0; i--){
            if (!stack.isEmpty()){
                while (!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
            }
            if (stack.isEmpty()){
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        System.out.println("Next Greater Element = " + Arrays.toString(result));
    }

    public static void isValidParenthesis(String s){
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    System.out.println("Invalid Parenthesis");
                    return;
                }else {
                    char top = stack.peek();
                    if (c == ')' && top == '(' || c == '}' && top == '{' || c == ']' && top == '['){
                        stack.pop();
                    }else {
                        System.out.println("Invalid Parenthesis");
                        return;
                    }
                }
            }
        }
        System.out.println(stack.isEmpty() ? "Valid Parenthesis" : "Invalid Parenthesis");
    }

    public static void main(String[] args) {
        reverseString("Mango");
        nextGreaterElement(new int[]{8,2,5,3,1,4});
        isValidParenthesis("{()}");
    }
}
