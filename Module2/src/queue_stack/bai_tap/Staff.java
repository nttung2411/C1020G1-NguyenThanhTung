package queue_stack.bai_tap;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Staff implements Comparable<Staff>  {

    String nameOfStaff;
    String genderOfStaff;
    Date dateOfStaff;
    DateFormat date1 = new SimpleDateFormat("dd/MM/YYYY");

    public Staff(String nameOfStaff, String genderOfStaff, String dateOfStaff) throws ParseException {
        this.nameOfStaff = nameOfStaff;
        this.genderOfStaff = genderOfStaff;
        this.dateOfStaff = date1.parse(dateOfStaff);
    }


    @Override
    public int compareTo(Staff o){
        return this.dateOfStaff.compareTo(o.dateOfStaff);
    }

    @Override
    public String toString() {
        return "nameOfStaff='" + nameOfStaff + '\'' +
                ", genderOfStaff='" + genderOfStaff + '\'' +
                ", dateOfStaff='" + date1.format(dateOfStaff) + '\''
                + '\n';
    }
}
