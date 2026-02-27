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
    }
}