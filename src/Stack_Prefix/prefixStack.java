package Stack_Prefix;


import java.util.Scanner;
import java.util.Stack;

public class prefixStack {

    public static int precedence(char operator)
    {
        if(operator == '+' || operator =='-')
            return 1;
        else if(operator == '*' || operator == '/')
            return 2;
        else
            return 0;
    }//End of priority method

    public static boolean isOperator(char element)
    {
        if(element == '*' || element == '-' || element == '/' || element == '+')
            return true;
        else
            return false;
    }//End of isOperator method

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Stack<Character> prefixStack = new Stack<>();
        String expression = reader.nextLine();

        String output = "";
        char character = ' ';


        for(int limit = expression.length()-1; limit > 0 ; limit--)
        {
            character = expression.charAt(limit);

            if(isOperator(character))
            {
                output = output + character + " ";
            }
            else if(character == '(')
            {
                prefixStack.push(character);
            }
            else if(character == ')')
            {
                while(!prefixStack.peek().equals('('))
                    output = output + prefixStack.pop() + " ";
                prefixStack.pop();
            }
            else
            {
                if(Character.isDigit(character) && (limit + 1) < limit && Character.isDigit(expression.charAt(limit+1)))
                {
                    prefixStack.push(character);
                    prefixStack.push(expression.charAt(limit+1));
                }
                else if(Character.isDigit(character))
                {
                    prefixStack.push(character);
                }
                else
                {
                    output = output + character;
                }
            }
        }//End of for

        while(!prefixStack.isEmpty())
        {
            output = output + prefixStack.pop() + " ";
        }

        System.out.println(output);
    }
}

