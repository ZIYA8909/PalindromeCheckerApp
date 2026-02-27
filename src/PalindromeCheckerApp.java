import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // ================= UC1 =================
        // Welcome Message
        System.out.println("Welcome to Palindrome Checker App!");
        System.out.println("---------------------------------\n");

        // ================= UC2 =================
        // Hardcoded Palindrome Check
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println("UC2: " + word + " is a palindrome.");
        } else {
            System.out.println("UC2: " + word + " is not a palindrome.");
        }

        // ================= UC3 =================
        // Palindrome using String Reverse (Loop)
        String inputUC3 = "level";
        String reversedUC3 = "";

        for (int i = inputUC3.length() - 1; i >= 0; i--) {
            reversedUC3 = reversedUC3 + inputUC3.charAt(i);
        }

        if (inputUC3.equals(reversedUC3)) {
            System.out.println("UC3: " + inputUC3 + " is a palindrome.");
        } else {
            System.out.println("UC3: " + inputUC3 + " is not a palindrome.");
        }

        // ================= UC4 =================
        // Two Pointer using char[]
        String inputUC4 = "radar";
        char[] chars = inputUC4.toCharArray();
        boolean isPalindromeUC4 = true;

        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindromeUC4 = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("UC4: " + inputUC4 +
                (isPalindromeUC4 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC5 =================
        // Stack Based Palindrome
        String inputUC5 = "civic";
        Stack<Character> stack = new Stack<>();

        for (char c : inputUC5.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindromeUC5 = true;
        for (char c : inputUC5.toCharArray()) {
            if (c != stack.pop()) {
                isPalindromeUC5 = false;
                break;
            }
        }

        System.out.println("UC5: " + inputUC5 +
                (isPalindromeUC5 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC6 =================
        // Queue + Stack (FIFO vs LIFO)
        String inputUC6 = "level";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();

        for (char c : inputUC6.toCharArray()) {
            queue.add(c);
            stackUC6.push(c);
        }

        boolean isPalindromeUC6 = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stackUC6.pop())) {
                isPalindromeUC6 = false;
                break;
            }
        }

        System.out.println("UC6: " + inputUC6 +
                (isPalindromeUC6 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC7 =================
        // Deque Based Palindrome
        String inputUC7 = "refer";
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : inputUC7.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindromeUC7 = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindromeUC7 = false;
                break;
            }
        }

        System.out.println("UC7: " + inputUC7 +
                (isPalindromeUC7 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC8 =================
        // Linked List Based Palindrome
        String inputUC8 = "level";
        LinkedList<Character> list = new LinkedList<>();

        for (char c : inputUC8.toCharArray()) {
            list.add(c);
        }

        boolean isPalindromeUC8 = true;
        while (list.size() > 1) {
            if (!list.removeFirst().equals(list.removeLast())) {
                isPalindromeUC8 = false;
                break;
            }
        }

        System.out.println("UC8: " + inputUC8 +
                (isPalindromeUC8 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC9 =================
        // Recursive Palindrome Check
        String inputUC9 = "madam";
        boolean isPalindromeUC9 = isPalindromeRecursive(inputUC9, 0, inputUC9.length() - 1);

        System.out.println("UC9: " + inputUC9 +
                (isPalindromeUC9 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC10 =================
        // Ignore Case & Spaces
        String inputUC10 = "Never Odd Or Even";
        String normalized = inputUC10.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindromeUC10 = true;
        int i = 0, j = normalized.length() - 1;

        while (i < j) {
            if (normalized.charAt(i) != normalized.charAt(j)) {
                isPalindromeUC10 = false;
                break;
            }
            i++;
            j--;
        }

        System.out.println("UC10: \"" + inputUC10 + "\"" +
                (isPalindromeUC10 ? " is a palindrome." : " is not a palindrome."));
    }

    // Helper method for UC9
    static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end)
            return true;
        if (str.charAt(start) != str.charAt(end))
            return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}