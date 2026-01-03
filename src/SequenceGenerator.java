import java.util.*;

public class SequenceGenerator {
    public static void generateSequences(char[] letters) {
        for (int length = 1; length <= letters.length; length++) {
            List<String> sequences = new ArrayList<>();
            generateSequencesRecursive(letters, "", 0, length, sequences);

            System.out.print(length + "-element sequences: ");
            printSequences(sequences);
        }
    }

    private static void generateSequencesRecursive(char[] letters, String current, int index, int targetLength, List<String> sequences) {
        // Base case: if the current sequence reaches the target length, add it to the list
        if (current.length() == targetLength) {
            sequences.add(current);
            return;
        }

        // Recursive case: explore sequences by including each letter from the current index onward
        for (int i = index; i < letters.length; i++) {
            generateSequencesRecursive(letters, current + letters[i], i + 1, targetLength, sequences);
        }
    }

    private static void printSequences(List<String> sequences) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sequences.size(); i++) {
            result.append(sequences.get(i));
            if (i < sequences.size() - 1) {
                result.append(", ");
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of characters
        System.out.print("Enter the number of characters in the array: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Create an array of characters
        char[] letters = new char[n];
        System.out.println("Enter each character followed by Enter:");
        for (int i = 0; i < n; i++) {
            System.out.print("Character " + (i + 1) + ": ");
            letters[i] = scanner.nextLine().charAt(0);
        }

        // Generate and print all sequences
        System.out.println("\nAll possible ordered sequences:");
        SequenceGenerator.generateSequences(letters);

        scanner.close();
    }
}
