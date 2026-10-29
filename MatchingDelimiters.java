/*
Description: Checks whether parentheses, brackets, and braces
are correctly matched using a stack and displays the stack trace.

Programmed by: Kayen Faith S. Antiporta, BSIT, 48079, CC104

Last Modified: October 29, 2026
Version: 1.1

Acknowledgements: ChatGPT was used for guidance on understanding
and modifying the stack execution trace.

Prompt: Help me modify my Matching Delimiters program to display
the stack operations during execution.
*/

import java.util.Scanner;
import java.util.Stack;

public class MatchingDelimiters {

    public static boolean checkDelimiters(String input) {
        Stack<Character> stack = new Stack<Character>();

        System.out.println("Input: " + input);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            System.out.println("Read: " + ch);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);

                System.out.println("Operation: PUSH " + ch);
                System.out.println("Stack: " + stack);

            } else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty()) {
                    System.out.println(
                        "Invalid: closing delimiter has no matching opening delimiter."
                    );
                    System.out.println("Stack: " + stack);
                    return false;
                }

                char top = stack.peek();

                System.out.println("Operation: PEEK -> " + top);

                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {

                    System.out.println(
                        "Invalid: mismatched delimiters. '" + ch
                        + "' does not match '" + top
                        + "' at the top of the stack."
                    );
                    System.out.println("Stack: " + stack);
                    return false;
                }

                stack.pop();

                System.out.println("Operation: POP " + top);
                System.out.println("Stack: " + stack);
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(
                "\nInvalid.Unmatched opening delimiter remains in the stack."
            );
            System.out.println("Stack: " + stack);
            return false;
        }

        System.out.println(
            "\nValid"
        );
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a delimiter sequence: ");
        String input = scanner.nextLine();
        
        checkDelimiters(input);
        scanner.close();
    }
}
