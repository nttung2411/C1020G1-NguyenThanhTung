package collection_map_tree.thuc_hanh.TreeNode;

public interface Tree<E> {
    public boolean insert(E e);
    public void inorder();
    public void postOrder();
    public void preOrder();
    public int getSize();
    public void breakFirst();
}
