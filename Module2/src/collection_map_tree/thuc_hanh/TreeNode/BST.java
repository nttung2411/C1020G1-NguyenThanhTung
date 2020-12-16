package collection_map_tree.thuc_hanh.TreeNode;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    TreeNode<E> current = null;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }
    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void breakFirst() {
        breakFirst(root);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void breakFirst(TreeNode<E> root){
        if(root == null) return;
        System.out.println(root.element);
    }

    private void preOrder(TreeNode<E> root) {
        if(root == null) return;
        System.out.println(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void postOrder(TreeNode<E> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.element + " ");
    }


    private void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    public boolean searchTree(E e){
        current = root;
        while (current != null){
            if (current.element == e){
                return true;
            } else if(e.compareTo(current.element) < 0){
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }
}
