import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the password to search for: ");
        String searchPhrase = scanner.nextLine();

        BruteForce(searchPhrase);
    }

    public static void BruteForce(String searchPhrase) {
        // Set the maximum length of the combination
        int maxLength = 8;

        String chars = "abcdefghijklmnpqrstubwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!-_";

        // Generate all possible combinations of the characters
        for (int length = 1; length <= maxLength; length++) {
            // Generate all combinations of the current length
            generateCombinations(chars, "", length, searchPhrase);
        }
    }

    // This method generates all combinations of the specified length using the given characters
    public static void generateCombinations(String chars, String prefix, int length, String searchPhrase) {
        // If we have reached the desired length, print the current combination
        if (length == 0) {
            if(prefix.equalsIgnoreCase(searchPhrase)){
                System.out.println("Password Found: " + prefix);
                return;
            }
            System.out.println(prefix);
            return;
        }




        // Try all possible characters for the next position in the combination
        for (int i = 0; i < chars.length(); i++) {
            // Recursively generate combinations with the current character added to the prefix
            if(!prefix.equals(searchPhrase))
                generateCombinations(chars, prefix + chars.charAt(i), length - 1, searchPhrase);
        }
    }
}