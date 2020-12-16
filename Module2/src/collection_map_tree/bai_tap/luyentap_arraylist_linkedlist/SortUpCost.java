package collection_map_tree.bai_tap.luyentap_arraylist_linkedlist;

import java.util.Comparator;

public class SortUpCost implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getCostProduct() -  o2.getCostProduct() > 0){
            return 1;
        } else if (o1.getCostProduct() - o2.getCostProduct() < 0){
            return -1;
        } else {
            return 0;
        }
    }
}
