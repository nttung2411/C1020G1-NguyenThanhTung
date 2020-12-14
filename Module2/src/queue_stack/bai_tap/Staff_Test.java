package queue_stack.bai_tap;

import java.text.ParseException;
import java.util.*;

public class Staff_Test {
    public static void main(String[] args) throws ParseException {
        Queue<Staff> nam = new LinkedList<>();
        Queue<Staff> nu = new LinkedList<>();
        List<Staff> listStaff = new ArrayList<>();

        Staff staff1 = new Staff("A","Nam","24/11/1995");
        Staff staff2 = new Staff("B","Nữ","23/11/1993");
        Staff staff3 = new Staff("C","NỮ","22/11/1992");
        Staff staff4 = new Staff("D","Nam","20/11/2000");

        listStaff.add(staff1);
        listStaff.add(staff2);
        listStaff.add(staff3);
        listStaff.add(staff4);

        Collections.sort(listStaff);

        while(listStaff.size() != 0){
            if(listStaff.get(0).genderOfStaff == "Nam"){
                nam.add(listStaff.remove(0));
            } else {
                nu.add(listStaff.remove(0));
            }
        }

        int sumSize = nu.size() + nam.size();
        for(int index = 0 ; index < sumSize ; index++){
            if (nu.size() != 0){
                listStaff.add(nu.poll());
            }
            else {
                listStaff.add(nam.poll());
            }
        }

        System.out.println(listStaff);
    }
}
