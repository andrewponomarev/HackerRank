package cracking_the_coding_interview.stacks_BalancedBrackets;

import java.util.*;

/**
 * Created by ponomarevandrew on 08.11.17.
 */
public class Solution {

    static List<Character> openBrackets = Arrays.asList(new Character[]{'{', '(', '['});
    static List<Character> closeBrackets = Arrays.asList(new Character[]{'}', ')', ']'});

    public static boolean isBalanced(String expression) {
        Stack stack = new Stack();
        for (int i = 0; i < expression.length(); i++) {
            if (openBrackets.contains(expression.charAt(i))) {
                stack.push(expression.charAt(i));
            }
            if (closeBrackets.contains(expression.charAt(i))) {
                char lastBracket = (Character) stack.pop();
                if (!(lastBracket == '{' && expression.charAt(i) == '}' ||
                        lastBracket == '(' && expression.charAt(i) == ')'||
                        lastBracket == '[' && expression.charAt(i) == ']')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }

}
