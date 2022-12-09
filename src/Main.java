import java.io.StringReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the password to search for: ");
        String searchPhrase = scanner.nextLine();

        BruteForce(searchPhrase);
        Dictionary(searchPhrase);
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
            if (prefix.equalsIgnoreCase(searchPhrase)) {
                System.out.println("Password Found: " + prefix);
                System.exit(0);
                return;

            }
            System.out.println(prefix);
            return;
        }


        // Try all possible characters for the next position in the combination
        for (int i = 0; i < chars.length(); i++) {
            // Recursively generate combinations with the current character added to the prefix
            if (!prefix.equals(searchPhrase))
                generateCombinations(chars, prefix + chars.charAt(i), length - 1, searchPhrase);
        }
    }

    public static ArrayList<String> readStringsFromFile(String filePath, String searchPhrase) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;


        ArrayList<String> stringz = StringReader.readStringsFromFile("OneDrive - Clear Creek ISD/to/Documents/to/DictionaryList.txt");

        for (String string : strings) {
            System.out.println(string);
        }
    }
}