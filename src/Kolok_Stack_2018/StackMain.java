package Kolok_Stack_2018;

import java.util.Scanner;
import java.util.Stack;

public class StackMain {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Stack<Character> postfixStack = new Stack<>();
        String expression = reader.nextLine();
        String [] elements = expression.split("");
        char[] chars = new char[elements.length];
        for (int i = 0; i < elements.length; i++) {
            chars[i] = elements[i].charAt(0);
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ')
                continue;

            if(chars[i] == '('){
                postfixStack.push(chars[i]);
            }else if((chars[i] == '*' || chars[i] == '/')){
                while (!postfixStack.isEmpty() && (postfixStack.peek() == '*'
                        || postfixStack.peek() == '/')){
                    output.append(" " + postfixStack.pop());
                }
                postfixStack.push(chars[i]);
            }else if((chars[i] == '+' || chars[i] == '-')){
                while (!postfixStack.isEmpty() && (postfixStack.peek() == '+'
                        || postfixStack.peek() == '-' || (postfixStack.peek() == '*'
                        || postfixStack.peek() == '/'))){
                    output.append(" " + postfixStack.pop());
                }
                postfixStack.push(chars[i]);
            }else if(chars[i] == ')'){
                while (!postfixStack.isEmpty() && postfixStack.peek() != '('){
                    output.append(" " + postfixStack.pop());
                }
                postfixStack.pop();
            }else {
                output.append(" " + chars[i]);
            }
        }
        while (!postfixStack.isEmpty()){
            output.append(" " + postfixStack.pop());
        }
        System.out.println(output.toString());
    }
}