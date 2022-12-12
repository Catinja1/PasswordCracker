import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the password to hash: ");
        String searchPhrase = scanner.nextLine();
        System.out.print("Enter the hash you to use Ex.(SHA256 or MD5) ");
        String whatType = scanner.nextLine();
        String sus = whatType;
        if (sus.equals("MD5")) {
            commonPasswordsMD5(searchPhrase);
            DictionaryMD5(searchPhrase);
            BruteForceMD5(searchPhrase);
        }
        if (sus.equals("SHA256")){
            commonPasswordsSha256(searchPhrase);
            DictionarySha256(searchPhrase);
        }


    }

            public static void BruteForceMD5(String searchPhrase) throws NoSuchAlgorithmException {
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
    public static void generateCombinations(String chars, String prefix, int length, String searchPhrase) throws NoSuchAlgorithmException {
        // If we have reached the desired length, print the current combination
        if (length == 0) {
            if (prefix.equalsIgnoreCase(searchPhrase)) {
                System.out.println("Password Found Using Brute: " + MD5a(prefix));
                System.exit(0);
                return;

            }

            return;
        }


        // Try all possible characters for the next position in the combination
        for (int i = 0; i < chars.length(); i++) {
            // Recursively generate combinations with the current character added to the prefix
            if (!prefix.equals(searchPhrase))
                System.out.println(prefix);
                generateCombinations(chars, prefix + chars.charAt(i), length - 1, searchPhrase);
        }
    }

    public static void DictionaryMD5(String searchPhrase) throws IOException, NoSuchAlgorithmException {
        String fileName = "DictionaryList.txt";
        String line = "";


        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            if (line.equalsIgnoreCase(searchPhrase)) {
                System.out.println("Password Found Using Dictionary: " + MD5a(line));
                System.exit(0);
                return;

            }
        }
        bufferedReader.close();
    }
    public static void DictionarySha256(String searchPhrase) throws IOException, NoSuchAlgorithmException {
        String fileName = "DictionaryList.txt";
        String line = "";


        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            if (line.equalsIgnoreCase(searchPhrase)) {
                System.out.println("Password Found Using Dictionary: " + SHA256a(line));
                System.exit(0);
                return;

            }
        }
        bufferedReader.close();
    }

    public static void commonPasswordsMD5(String searchPhrase) throws IOException, NoSuchAlgorithmException {
        String fileName = "10kPasswords.txt";
        String line = "";


        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            if (line.equalsIgnoreCase(searchPhrase)) {
                System.out.println("Password Found Using 10kPasswords: " + MD5a(line));
                System.exit(0);
            }
        }
        bufferedReader.close();
    }
    public static void commonPasswordsSha256(String searchPhrase) throws IOException, NoSuchAlgorithmException {
        String fileName = "10kPasswords.txt";
        String line = "";


        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            if (line.equalsIgnoreCase(searchPhrase)) {
                System.out.println("Password Found Using 10kPasswords: " + SHA256a(line));
                System.exit(0);
            }
        }
        bufferedReader.close();
    }
    public static String MD5a(String P) throws NoSuchAlgorithmException {
        String lower;
        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] data = P.getBytes();
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        lower=String.format("%1$032X", i);
        return lower.toLowerCase(Locale.ROOT);
    }

    //Function to create a SHA-256 hash from a string
    public static String SHA256a(String L) throws NoSuchAlgorithmException {
        String lower;
        MessageDigest m = MessageDigest.getInstance("SHA-256");
        byte[] data = L.getBytes();
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        lower= String.format("%1$064X", i);
        return lower.toLowerCase(Locale.ROOT);
    }
}