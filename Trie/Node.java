public class Node {
    Node[] links;
    boolean flag;
    private int wordCtr;
    private int prefixCtr;

    Node() {
        links = new Node[26];
        flag = false;
        wordCtr = 0;
        prefixCtr = 0;
    }

    boolean containsKey(char c) {
        return (getNext(c) != null);
    }

    void put(char key, Node nextNode) {
        int idx = key - 'a';
        links[idx] = nextNode;
    }

    Node getNext(char key) {
        int idx = key - 'a';
        return links[idx];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }

    int getWordCtr() {
        return this.wordCtr;
    }

    int getPrefixCtr() {
        return this.prefixCtr;
    }

    void increaseWordCnt() {
        wordCtr++;
    }

    void increasePrefixCnt() {
        prefixCtr++;
    }

    void decreaseWordCnt() {
        wordCtr--;
    }

    void decreasePrefixCnt() {
        prefixCtr--;
    }
}