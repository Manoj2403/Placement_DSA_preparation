import java.util.*;

public class TrieApp {
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("*****Trie Data Structure*****");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1) Insert the String\n2) Search the String\n3) Search the Prefix String\n4) Exit");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 4)
                break;
            System.out.println("Enter the Word : ");
            String word = sc.nextLine().toLowerCase();

            if (choice == 1) {
                trie.insert(word);
                System.out.println("Word is Inserted Successfully.");
            } else if (choice == 2) {
                if (trie.search(word))
                    System.out.println("Word is Available.");
                else
                    System.out.println("Word is Not Available.");
            } else if (choice == 3) {
                if (trie.startsWith(word))
                    System.out.println("Word Found Starts with " + word);
                else
                    System.out.println("Word Not Found Starts with " + word);
            }
        } while (choice != 4);
    }
}
