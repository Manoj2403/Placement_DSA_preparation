public class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    Node() {

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

}