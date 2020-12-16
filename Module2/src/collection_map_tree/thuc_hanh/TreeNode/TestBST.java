package collection_map_tree.thuc_hanh.TreeNode;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(45);
        tree.insert(57);
        tree.insert(59);
        tree.insert(100);
        tree.insert(67);
        tree.insert(107);
        tree.insert(101);
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());

        System.out.println(tree.searchTree(55));


    }
}
