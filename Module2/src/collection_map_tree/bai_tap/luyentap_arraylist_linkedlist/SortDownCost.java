package collection_map_tree.bai_tap.luyentap_arraylist_linkedlist;

import java.util.Comparator;

public class SortDownCost implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
         if (o2.getCostProduct() -  o1.getCostProduct() > 0){
             return 1;
         } else if (o2.getCostProduct() - o1.getCostProduct() < 0){
             return -1;
         } else {
             return 0;
         }
    }
}
