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
            // travers with next Node
            node = node.getNext(word.charAt(i));
        }
        node.setEnd();
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

}