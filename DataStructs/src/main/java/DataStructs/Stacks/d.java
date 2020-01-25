package DataStructs.Stacks;

import java.util.Stack;

class BalancedBrackets {

    /**
     * Check if {@code leftBracket} and {@code rightBracket} is paired or not
     *
     * @param leftBracket   left bracket
     * @param rightBracket right bracket
     * @return {@code true} if {@code leftBracket} and {@code rightBracket} is paired,
     * otherwise {@code false}
     */
    public static boolean isPaired(char leftBracket, char rightBracket) {
        char[][] pairedBrackets = {
                {'(', ')'},
                {'[', ']'},
                {'{', '}'},
                {'<', '>'}
        };
        for (char[] pairedBracket : pairedBrackets) {
            if (pairedBracket[0] == leftBracket && pairedBracket[1] == rightBracket) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if {@code brackets} is balanced
     *
     * @param brackets the brackets
     * @return {@code true} if {@code brackets} is balanced, otherwise {@code false}
     */
    public static boolean isBalanced(String brackets) {
        if (brackets == null) {
            throw new IllegalArgumentException("brackets is null");
        }
        Stack<Character> bracketsStack = new Stack<>();
        for (char bracket : brackets.toCharArray()) {
            switch (bracket) {
                case '(':
                case '[':
                case '{':
                    bracketsStack.push(bracket);
                    break;
                case ')':
                case ']':
                case '}':
                    if (bracketsStack.isEmpty() || !isPaired(bracketsStack.pop(), bracket)) {
                        return false;
                    }
                    break;
                default: /* other character is invalid */
                    return false;
            }
        }
        return bracketsStack.isEmpty();
    }


    public static void main(String[] args) {
        assert isBalanced("[()]{}{[()()]()}");
        assert !isBalanced("[(])");
    }
}
