import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1: Welcome message
        System.out.println("Welcome to Palindrome Checker App!");

        // UC2: Hardcoded Palindrome Check
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println(word.equalsIgnoreCase(reversed)
                ? word + " is a palindrome."
                : word + " is not a palindrome.");

        // UC3: Palindrome using string reverse (loop)
        String input = "level";
        String reversedWord = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversedWord += input.charAt(i);
        }
        System.out.println(input.equals(reversedWord)
                ? input + " is a palindrome (UC3)."
                : input + " is not a palindrome (UC3).");

        // UC4: Palindrome using char[] & two pointers
        String text = "radar";
        char[] chars = text.toCharArray();
        int start = 0, end = chars.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println(isPalindrome
                ? text + " is a palindrome (UC4)."
                : text + " is not a palindrome (UC4).");

        // UC5: Palindrome using Stack
        String stackInput = "noon";
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char ch : stackInput.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters to reverse
        String stackReversed = "";
        while (!stack.isEmpty()) {
            stackReversed += stack.pop();
        }

        if (stackInput.equals(stackReversed)) {
            System.out.println(stackInput + " is a palindrome (UC5).");
        } else {
            System.out.println(stackInput + " is not a palindrome (UC5).");
        }
    }
}