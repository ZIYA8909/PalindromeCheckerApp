import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("Welcome to Palindrome Checker App!");
        System.out.println("----------------------------------");

        // ================= UC2 =================
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println("UC2: " + word +
                (word.equalsIgnoreCase(reversed) ? " is a palindrome." : " is not a palindrome."));

        // ================= UC3 =================
        String inputUC3 = "level";
        String revUC3 = "";
        for (int i = inputUC3.length() - 1; i >= 0; i--) {
            revUC3 += inputUC3.charAt(i);
        }
        System.out.println("UC3: " + inputUC3 +
                (inputUC3.equals(revUC3) ? " is a palindrome." : " is not a palindrome."));

        // ================= UC4 =================
        String inputUC4 = "radar";
        char[] arr = inputUC4.toCharArray();
        boolean isPalUC4 = true;
        int start = 0, end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalUC4 = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("UC4: " + inputUC4 +
                (isPalUC4 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC5 =================
        String inputUC5 = "civic";
        Stack<Character> stack = new Stack<>();
        for (char c : inputUC5.toCharArray()) stack.push(c);

        boolean isPalUC5 = true;
        for (char c : inputUC5.toCharArray()) {
            if (c != stack.pop()) {
                isPalUC5 = false;
                break;
            }
        }
        System.out.println("UC5: " + inputUC5 +
                (isPalUC5 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC6 =================
        String inputUC6 = "level";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack6 = new Stack<>();

        for (char c : inputUC6.toCharArray()) {
            queue.add(c);
            stack6.push(c);
        }

        boolean isPalUC6 = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack6.pop())) {
                isPalUC6 = false;
                break;
            }
        }
        System.out.println("UC6: " + inputUC6 +
                (isPalUC6 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC7 =================
        String inputUC7 = "refer";
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : inputUC7.toCharArray()) deque.addLast(c);

        boolean isPalUC7 = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalUC7 = false;
                break;
            }
        }
        System.out.println("UC7: " + inputUC7 +
                (isPalUC7 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC8 =================
        String inputUC8 = "level";
        LinkedList<Character> list = new LinkedList<>();
        for (char c : inputUC8.toCharArray()) list.add(c);

        boolean isPalUC8 = true;
        while (list.size() > 1) {
            if (!list.removeFirst().equals(list.removeLast())) {
                isPalUC8 = false;
                break;
            }
        }
        System.out.println("UC8: " + inputUC8 +
                (isPalUC8 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC9 =================
        String inputUC9 = "madam";
        System.out.println("UC9: " + inputUC9 +
                (isPalindromeRecursive(inputUC9, 0, inputUC9.length() - 1)
                        ? " is a palindrome." : " is not a palindrome."));

        // ================= UC10 =================
        String inputUC10 = "Never Odd Or Even";
        String normalized = inputUC10.replaceAll("\\s+", "").toLowerCase();
        boolean isPalUC10 = true;
        int i = 0, j = normalized.length() - 1;

        while (i < j) {
            if (normalized.charAt(i) != normalized.charAt(j)) {
                isPalUC10 = false;
                break;
            }
            i++;
            j--;
        }
        System.out.println("UC10: \"" + inputUC10 + "\"" +
                (isPalUC10 ? " is a palindrome." : " is not a palindrome."));

        // ================= UC11 =================
        PalindromeChecker checker = new PalindromeChecker();
        String inputUC11 = "RaceCar";
        System.out.println("UC11: " + inputUC11 +
                (checker.checkPalindrome(inputUC11)
                        ? " is a palindrome." : " is not a palindrome."));
    }

    // UC9 helper
    static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}

// ================= UC11 =================
// Object-Oriented Palindrome Service
class PalindromeChecker {

    public boolean checkPalindrome(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = cleaned.length() - 1;

        while (i < j) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}