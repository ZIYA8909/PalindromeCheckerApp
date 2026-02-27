import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1: Welcome message
        System.out.println("Welcome to Palindrome Checker App!");

        // UC2: Hardcoded Palindrome
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println(word.equalsIgnoreCase(reversed)
                ? word + " is a palindrome."
                : word + " is not a palindrome.");

        // UC3: String reverse using loop
        String input = "level";
        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            rev += input.charAt(i);
        }
        System.out.println(input.equals(rev)
                ? input + " is a palindrome (UC3)."
                : input + " is not a palindrome (UC3).");

        // UC4: char[] + two pointer
        String text = "radar";
        char[] arr = text.toCharArray();
        int start = 0, end = arr.length - 1;
        boolean isPal = true;

        while (start < end) {
            if (arr[start] != arr[end]) {
                isPal = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println(isPal
                ? text + " is a palindrome (UC4)."
                : text + " is not a palindrome (UC4).");

        // UC5: Stack based palindrome
        String stackInput = "noon";
        Stack<Character> stack = new Stack<>();

        for (char ch : stackInput.toCharArray()) {
            stack.push(ch);
        }

        String stackReverse = "";
        while (!stack.isEmpty()) {
            stackReverse += stack.pop();
        }

        System.out.println(stackInput.equals(stackReverse)
                ? stackInput + " is a palindrome (UC5)."
                : stackInput + " is not a palindrome (UC5).");

        // UC6: Queue + Stack based palindrome
        String qsInput = "civic";

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stackQS = new Stack<>();

        // Insert characters into both Queue and Stack
        for (char ch : qsInput.toCharArray()) {
            queue.add(ch);     // FIFO
            stackQS.push(ch);  // LIFO
        }

        boolean isPalindromeQS = true;

        // Compare dequeue vs pop
        while (!queue.isEmpty()) {
            if (queue.remove() != stackQS.pop()) {
                isPalindromeQS = false;
                break;
            }
        }

        System.out.println(isPalindromeQS
                ? qsInput + " is a palindrome (UC6)."
                : qsInput + " is not a palindrome (UC6).");
    }
}