import java.util.*;

public class TreeNode {
    Node root = null;

    
    public void add(int data) {
        root = addRec(root, data);
        // System.out.println(root);
    }

    private Node addRec(Node root,int data) {
        if (root == null)
            return new Node(data);
        if (data < root.data) {
            root.left = addRec(root.left, data);
        } else if (data > root.data) {
            root.right = addRec(root.right, data);
        }

        return root;
    }


//--------------------------------------------------------------------------------------------------------
//                                      using while loop
    // public void insert(int data){
    //     if(root==null){
    //         root = new Node(data);
    //         return ;
    //     }
    //     Node temp = root;
    //     Node parent = null;
    //     boolean fromLeft=true;
    //     while(temp!=null){
    //         if(data<temp.data){
    //             parent = temp;
    //             temp = temp.left;
    //             fromLeft = true;
    //         }else{
    //             parent = temp;
    //             temp = temp.right;
    //             fromLeft = false;
    //         }
    //     }
    //     Node newNode = new Node(data);
    //     if(fromLeft){
    //         parent.left = newNode;
    //     }
    //     else{
    //         parent.right = newNode;
    //     }
    // }
// ------------------------------------------------------------------------------------------------
    // public void add(Node node) {
    //     root = addRec(root, node);
    //     // System.out.println(root);
    // }

    // private Node addRec(Node root, Node node) {
    //     if (root == null)
    //         return node;
    //     if (node.data < root.data) {
    //         root.left = addRec(root.left, node);
    //     } else if (node.data > root.data) {
    //         root.right = addRec(root.right, node);
    //     }

    //     return root;
    // }
// ------------------------------------------------------------------------------------------------

    // InOrder Traversal  ------> It gives the element in Sorted Order
    public void inorder() {
        System.out.println("InOrder Traversal");
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root == null)
            return;
            // if(root.left==null && root.right==null)
            // System.out.println(root->data); //It can give leaf nodes
            inorderRec(root.left);
            System.out.print(root.data + "->");
            inorderRec(root.right);
            //------------Print the Elements in Reversed Order------
            // inorderRec(root.right);
            // System.out.print(root.data + "->");
            // inorderRec(root.left);
    }

    // PreOrder Traversal
    void preorder() {
        System.out.println("PreOrder Traversal");
        preOrderRec(root);
        System.out.println();
    }

    void preOrderRec(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + "->");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    // PostOrder Traversal
    void postorder() {
        System.out.println("Post Order Traversal");
        postOrderRec(root);
        System.out.println();
    }

    void postOrderRec(Node root) {
        if (root == null)
            return;
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.data + "->");
    }

    // LevelOrderTraversal
    void levelorder() {
        System.out.println("Level Order Traversal");
        levelOrder(root);
        System.out.println();
    }

    void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        Node temp = root;
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.poll();
            System.out.print(temp.data + "->");
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }

    int getHeight(Node root){
        if(root==null)
            return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return (left>right ? left : right) +1;
    }
    Node delete_leaf(Node root,int val){
        if(root==null)
            return root;
        if((root.left==null && root.right==null)&&root.data==val)
            return null;
        if(val<root.data)
            root.left = delete_leaf(root.left, val);
        else
            root.right = delete_leaf(root.right, val);
        return root;
    }

    // void print() {
    //     System.out.println(root.left.data);
    // }

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        t.add(10);
        t.add(5);
        t.add(30);
        t.add(8);
        t.add(25);
        t.add(50);
        t.add(65);
        // t.add(new Node(5));
        // t.add(new Node(4));
        // t.add(new Node(20));
        t.inorder();
        t.preorder();
        t.postorder();
        t.levelorder();
        System.out.println(t.getHeight(t.root));
        t.delete_leaf(t.root,65);//65 is leaf node
        t.inorder();
        // t.print();// To verify with diagram(Manually)
        
    }
}
