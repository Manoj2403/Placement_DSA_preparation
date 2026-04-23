public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            // checks already key(character) presents or not ., if not presents put the
            // character in the node
            if (word.charAt(i) == ' ')
                continue;
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            // traverse with next Node
            node = node.getNext(word.charAt(i));

            // Tracking the Prefix Count
            node.increasePrefixCnt();
        }
        node.setEnd();
        // Tracking the Word Count
        node.increaseWordCnt();
    }

    public boolean search(String word) {
        if (root == null) {
            return false;
        }

        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            // checks already key(character) presents or not
            if (word.charAt(i) == ' ')
                continue;
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.getNext(word.charAt(i));
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefixWord) {
        if (root == null) {
            return false;
        }
        Node node = root;
        for (int i = 0; i < prefixWord.length(); i++) {
            // checks already key(character) presents or not
            if (prefixWord.charAt(i) == ' ')
                continue;
            if (!node.containsKey(prefixWord.charAt(i))) {
                return false;
            }
            node = node.getNext(prefixWord.charAt(i));
        }
        return true;
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.containsKey(c)) {
                node = node.getNext(c);
            } else {
                return -1;
            }
        }
        return node.getWordCtr();
    }

    public int countPrefixEqualTo(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.containsKey(c)) {
                node = node.getNext(c);
            } else {
                return -1;
            }
        }
        return node.getPrefixCtr();
    }

    public int wordsCount() {
        return wordsCountHelper(root);
    }

    public int wordsCountHelper(Node root) {
        // Base case
        if (root == null)
            return 0;

        int count = 0;

        if (root.isEnd()) {
            count = 1;
        }

        // Traverse all 26 possible children
        for (int i = 0; i < 26; i++) {
            if (root.links[i] != null) {
                count += wordsCountHelper(root.links[i]); // Recurse into child
            }
        }

        return count;
    }

}