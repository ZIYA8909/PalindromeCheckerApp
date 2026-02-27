public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1: Welcome message
        System.out.println("Welcome to Palindrome Checker App!");

        // UC2: Hardcoded Palindrome Check
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }

        // UC3: Palindrome Check Using String Reverse (loop)
        String input = "level";
        String reversedWord = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversedWord = reversedWord + input.charAt(i);
        }

        if (input.equals(reversedWord)) {
            System.out.println(input + " is a palindrome (UC3).");
        } else {
            System.out.println(input + " is not a palindrome (UC3).");
        }

        // UC4: Palindrome using char[] and Two-Pointer Technique
        String text = "radar";
        char[] chars = text.toCharArray();

        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println(text + " is a palindrome (UC4).");
        } else {
            System.out.println(text + " is not a palindrome (UC4).");
        }
    }
}