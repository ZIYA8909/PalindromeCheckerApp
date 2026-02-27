import java.util.*;
import java.io.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // =========================
        // UC1: Welcome Message
        // =========================
        System.out.println("Welcome to Palindrome Checker App!");

        // =========================
        // UC2: Hardcoded Palindrome Check
        // =========================
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println(word + " is a palindrome. (UC2)");
        } else {
            System.out.println(word + " is not a palindrome. (UC2)");
        }

        // =========================
        // UC3: Palindrome Using String Reverse (Loop)
        // =========================
        String inputUC3 = "level";
        String revUC3 = "";

        for (int i = inputUC3.length() - 1; i >= 0; i--) {
            revUC3 = revUC3 + inputUC3.charAt(i);
        }

        if (inputUC3.equals(revUC3)) {
            System.out.println(inputUC3 + " is a palindrome. (UC3)");
        } else {
            System.out.println(inputUC3 + " is not a palindrome. (UC3)");
        }

        // =========================
        // UC4: Palindrome Using char[] + Two Pointer
        // =========================
        String inputUC4 = "radar";
        char[] arr = inputUC4.toCharArray();
        int left = 0, right = arr.length - 1;
        boolean isPalindromeUC4 = true;

        while (left < right) {
            if (arr[left] != arr[right]) {
                isPalindromeUC4 = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindromeUC4) {
            System.out.println(inputUC4 + " is a palindrome. (UC4)");
        } else {
            System.out.println(inputUC4 + " is not a palindrome. (UC4)");
        }

        // =========================
        // UC5: Palindrome Using Stack
        // =========================
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

        if (isPalindromeUC5) {
            System.out.println(inputUC5 + " is a palindrome. (UC5)");
        } else {
            System.out.println(inputUC5 + " is not a palindrome. (UC5)");
        }

        // =========================
        // UC6: Queue + Stack Palindrome Check
        // =========================
        String inputUC6 = "level";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();

        for (char c : inputUC6.toCharArray()) {
            queue.add(c);
            stackUC6.push(c);
        }

        boolean isPalindromeUC6 = true;
        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stackUC6.pop())) {
                isPalindromeUC6 = false;
                break;
            }
        }

        if (isPalindromeUC6) {
            System.out.println(inputUC6 + " is a palindrome. (UC6)");
        } else {
            System.out.println(inputUC6 + " is not a palindrome. (UC6)");
        }

        // =========================
        // UC7: Deque Based Palindrome Check
        // =========================
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

        if (isPalindromeUC7) {
            System.out.println(inputUC7 + " is a palindrome. (UC7)");
        } else {
            System.out.println(inputUC7 + " is not a palindrome. (UC7)");
        }

        // =========================
        // UC8: Linked List Based Palindrome Check
        // =========================
        String inputUC8 = "level";
        Node head = createLinkedList(inputUC8);

        if (isPalindromeLinkedList(head)) {
            System.out.println(inputUC8 + " is a palindrome. (UC8)");
        } else {
            System.out.println(inputUC8 + " is not a palindrome. (UC8)");
        }

        // =========================
        // UC9: Recursive Palindrome Check
        // =========================
        String inputUC9 = "racecar";

        if (isPalindromeRecursive(inputUC9, 0, inputUC9.length() - 1)) {
            System.out.println(inputUC9 + " is a palindrome. (UC9)");
        } else {
            System.out.println(inputUC9 + " is not a palindrome. (UC9)");
        }
    }

    // =========================
    // UC8 Helper Methods (Linked List)
    // =========================
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node createLinkedList(String str) {
        Node head = null, tail = null;

        for (char c : str.toCharArray()) {
            Node node = new Node(c);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }

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

    static boolean isPalindromeLinkedList(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    // =========================
    // UC9 Helper Method (Recursion)
    // =========================
    static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}