package collection_map_tree.thuc_hanh.comparable_comparator;

import collection_map_tree.thuc_hanh.hashmap_hashset.Student;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge()-o2.getAge();
    }
}
