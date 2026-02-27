import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1
        System.out.println("Welcome to Palindrome Checker App!");

        // UC2
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println(word.equalsIgnoreCase(reversed)
                ? word + " is a palindrome."
                : word + " is not a palindrome.");

        // UC3
        String input = "level";
        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            rev += input.charAt(i);
        }
        System.out.println(input.equals(rev)
                ? input + " is a palindrome (UC3)."
                : input + " is not a palindrome (UC3).");

        // UC4
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

        // UC5
        java.util.Stack<Character> stack = new java.util.Stack<>();
        String stackInput = "noon";
        for (char ch : stackInput.toCharArray()) {
            stack.push(ch);
        }
        String stackRev = "";
        while (!stack.isEmpty()) {
            stackRev += stack.pop();
        }
        System.out.println(stackInput.equals(stackRev)
                ? stackInput + " is a palindrome (UC5)."
                : stackInput + " is not a palindrome (UC5).");

        // UC6
        java.util.Queue<Character> queue = new java.util.LinkedList<>();
        java.util.Stack<Character> stackQS = new java.util.Stack<>();
        String qsInput = "civic";

        for (char ch : qsInput.toCharArray()) {
            queue.add(ch);
            stackQS.push(ch);
        }

        boolean isQS = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stackQS.pop())) {
                isQS = false;
                break;
            }
        }
        System.out.println(isQS
                ? qsInput + " is a palindrome (UC6)."
                : qsInput + " is not a palindrome (UC6).");

        // UC7: Deque Based Optimized Palindrome Check
        String dequeInput = "refer";
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : dequeInput.toCharArray()) {
            deque.addLast(ch);
        }

        boolean isDequePalindrome = true;

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isDequePalindrome = false;
                break;
            }
        }

        System.out.println(isDequePalindrome
                ? dequeInput + " is a palindrome (UC7)."
                : dequeInput + " is not a palindrome (UC7).");
    }
}