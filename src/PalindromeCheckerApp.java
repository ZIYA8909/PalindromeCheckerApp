import java.util.*;

public class PalindromeCheckerApp {

    // UC8: Linked List Node
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        // UC1: Welcome Message
        System.out.println("Welcome to Palindrome Checker App!");

        // =========================
        // UC2: Hardcoded Palindrome
        // =========================
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println(word + " is a palindrome (UC2).");
        } else {
            System.out.println(word + " is not a palindrome (UC2).");
        }

        // =========================
        // UC3: String Reverse using Loop
        // =========================
        String inputUC3 = "level";
        String reversedUC3 = "";

        for (int i = inputUC3.length() - 1; i >= 0; i--) {
            reversedUC3 = reversedUC3 + inputUC3.charAt(i);
        }

        if (inputUC3.equals(reversedUC3)) {
            System.out.println(inputUC3 + " is a palindrome (UC3).");
        } else {
            System.out.println(inputUC3 + " is not a palindrome (UC3).");
        }

        // =========================
        // UC4: Char Array + Two Pointer
        // =========================
        String inputUC4 = "radar";
        char[] chars = inputUC4.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindromeUC4 = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindromeUC4 = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println(isPalindromeUC4
                ? inputUC4 + " is a palindrome (UC4)."
                : inputUC4 + " is not a palindrome (UC4).");

        // =========================
        // UC5: Stack Based Palindrome
        // =========================
        String inputUC5 = "civic";
        Stack<Character> stack = new Stack<>();

        for (char ch : inputUC5.toCharArray()) {
            stack.push(ch);
        }

        boolean isPalindromeUC5 = true;
        for (char ch : inputUC5.toCharArray()) {
            if (ch != stack.pop()) {
                isPalindromeUC5 = false;
                break;
            }
        }

        System.out.println(isPalindromeUC5
                ? inputUC5 + " is a palindrome (UC5)."
                : inputUC5 + " is not a palindrome (UC5).");

        // =========================
        // UC6: Queue + Stack (FIFO vs LIFO)
        // =========================
        String inputUC6 = "level";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();

        for (char ch : inputUC6.toCharArray()) {
            queue.add(ch);
            stackUC6.push(ch);
        }

        boolean isPalindromeUC6 = true;
        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stackUC6.pop())) {
                isPalindromeUC6 = false;
                break;
            }
        }

        System.out.println(isPalindromeUC6
                ? inputUC6 + " is a palindrome (UC6)."
                : inputUC6 + " is not a palindrome (UC6).");

        // =========================
        // UC7: Deque Based Optimized Check
        // =========================
        String inputUC7 = "refer";
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : inputUC7.toCharArray()) {
            deque.add(ch);
        }

        boolean isPalindromeUC7 = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindromeUC7 = false;
                break;
            }
        }

        System.out.println(isPalindromeUC7
                ? inputUC7 + " is a palindrome (UC7)."
                : inputUC7 + " is not a palindrome (UC7).");

        // =========================
        // UC8: Linked List Based Palindrome
        // =========================
        String inputUC8 = "level";
        Node head = createLinkedList(inputUC8);

        System.out.println(isPalindromeLinkedList(head)
                ? inputUC8 + " is a palindrome (UC8)."
                : inputUC8 + " is not a palindrome (UC8).");
    }

    // ---------- UC8 Helper Methods ----------

    // Convert string to linked list
    static Node createLinkedList(String input) {
        Node head = null, tail = null;

        for (char ch : input.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Reverse linked list
    static Node reverse(Node head) {
        Node prev = null, curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Check palindrome using linked list
    static boolean isPalindromeLinkedList(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
}