import java.util.*;

public class TrieApp {
    private static int FLAG_VALUE_END = 7;

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("*****Trie Data Structure*****");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("=================================");
            System.out.println("1) Insert the String\n" +
                    "2) Search the String\n" +
                    "3) Search the Prefix String\n" +
                    "4) Count Number of Words in the Trie\n" +
                    "5) Count Number of Words Equal in Trie\n" +
                    "6) Count Number of Prefix Equal in Trie\n" +
                    "7) Exit");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == TrieApp.FLAG_VALUE_END)
                break;

            if (choice == 1) {
                System.out.println("Enter the Word : ");
                String word = sc.nextLine().toLowerCase();
                trie.insert(word);
                System.out.println("Word is Inserted Successfully.");
            } else if (choice == 2) {
                System.out.println("Enter the Word : ");
                String word = sc.nextLine().toLowerCase();
                if (trie.search(word))
                    System.out.println("Word is Available.");
                else
                    System.out.println("Word is Not Available.");
            } else if (choice == 3) {
                System.out.println("Enter the Word : ");
                String word = sc.nextLine().toLowerCase();
                if (trie.startsWith(word))
                    System.out.println("Word Found Starts with " + word);
                else
                    System.out.println("Word Not Found Starts with " + word);
            } else if (choice == 4) {
                int wordsCount = trie.wordsCount();
                System.out.println(wordsCount + " Words are present in the Trie.");
            } else if (choice == 5) {
                System.out.println("Enter the Word : ");
                String word = sc.nextLine().toLowerCase();
                int wordCnt = trie.countWordsEqualTo(word);
                System.out.println(wordCnt + " Words are Equal to the Given Word " + word);
            } else if (choice == 6) {
                System.out.println("Enter the Word : ");
                String prefix = sc.nextLine().toLowerCase();
                int prefixCnt = trie.countPrefixEqualTo(prefix);
                System.out.println((prefixCnt == -1) ? ("No Prefix are Equal to the Word " + prefix)
                        : (prefixCnt + " Words are Equal to the Given Word " + prefix));
            }
        } while (choice != FLAG_VALUE_END);
    }
}
