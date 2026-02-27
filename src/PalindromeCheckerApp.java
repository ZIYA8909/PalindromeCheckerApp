import java.util.*;

// ================= MAIN APPLICATION =================
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker App");
        System.out.println("--------------------------------");

        // UC1
        System.out.println("UC1: Application Started");

        // UC2
        String uc2 = "madam";
        System.out.println("UC2: " + uc2 + " -> " + isPalindromeReverse(uc2));

        // UC3
        String uc3 = "level";
        System.out.println("UC3: " + uc3 + " -> " + isPalindromeLoop(uc3));

        // UC4
        String uc4 = "radar";
        System.out.println("UC4: " + uc4 + " -> " + isPalindromeTwoPointer(uc4));

        // UC5
        String uc5 = "civic";
        System.out.println("UC5: " + uc5 + " -> " + isPalindromeStack(uc5));

        // UC6
        String uc6 = "level";
        System.out.println("UC6: " + uc6 + " -> " + isPalindromeQueueStack(uc6));

        // UC7
        String uc7 = "refer";
        System.out.println("UC7: " + uc7 + " -> " + isPalindromeDeque(uc7));

        // UC8
        String uc8 = "level";
        System.out.println("UC8: " + uc8 + " -> " + isPalindromeLinkedList(uc8));

        // UC9
        String uc9 = "madam";
        System.out.println("UC9: " + uc9 + " -> " + isPalindromeRecursive(uc9, 0, uc9.length() - 1));

        // UC10
        String uc10 = "Never Odd Or Even";
        System.out.println("UC10: " + uc10 + " -> " + isPalindromeIgnoreCaseSpace(uc10));

        // UC11
        PalindromeService service = new PalindromeService();
        System.out.println("UC11: RaceCar -> " + service.checkPalindrome("RaceCar"));

        // UC12 (STRATEGY PATTERN)
        PalindromeContext context = new PalindromeContext();

        context.setStrategy(new StackStrategy());
        System.out.println("UC12 (Stack Strategy): level -> " + context.execute("level"));

        context.setStrategy(new DequeStrategy());
        System.out.println("UC12 (Deque Strategy): level -> " + context.execute("level"));
    }

    // ================= UC2 =================
    static boolean isPalindromeReverse(String s) {
        return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
    }

    // ================= UC3 =================
    static boolean isPalindromeLoop(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return s.equals(rev);
    }

    // ================= UC4 =================
    static boolean isPalindromeTwoPointer(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i++] != arr[j--]) return false;
        }
        return true;
    }

    // ================= UC5 =================
    static boolean isPalindromeStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // ================= UC6 =================
    static boolean isPalindromeQueueStack(String s) {
        Queue<Character> q = new LinkedList<>();
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            q.add(c);
            st.push(c);
        }
        while (!q.isEmpty()) {
            if (!q.remove().equals(st.pop())) return false;
        }
        return true;
    }

    // ================= UC7 =================
    static boolean isPalindromeDeque(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) dq.add(c);
        while (dq.size() > 1) {
            if (!dq.removeFirst().equals(dq.removeLast())) return false;
        }
        return true;
    }

    // ================= UC8 =================
    static boolean isPalindromeLinkedList(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) list.add(c);
        while (list.size() > 1) {
            if (!list.removeFirst().equals(list.removeLast())) return false;
        }
        return true;
    }

    // ================= UC9 =================
    static boolean isPalindromeRecursive(String s, int i, int j) {
        if (i >= j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return isPalindromeRecursive(s, i + 1, j - 1);
    }

    // ================= UC10 =================
    static boolean isPalindromeIgnoreCaseSpace(String s) {
        String clean = s.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = clean.length() - 1;
        while (i < j) {
            if (clean.charAt(i++) != clean.charAt(j--)) return false;
        }
        return true;
    }
}

// ================= UC11 =================
class PalindromeService {
    public boolean checkPalindrome(String input) {
        String clean = input.toLowerCase();
        int i = 0, j = clean.length() - 1;
        while (i < j) {
            if (clean.charAt(i++) != clean.charAt(j--)) return false;
            i++;
        }
        return true;
    }
}

// ================= UC12 (STRATEGY PATTERN) =================
interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : input.toCharArray()) dq.add(c);
        while (dq.size() > 1) {
            if (!dq.removeFirst().equals(dq.removeLast())) return false;
        }
        return true;
    }
}

class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
    }
}