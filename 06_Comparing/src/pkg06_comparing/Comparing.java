package pkg06_comparing;

import java.text.Collator;
import pkg06_comparing.mycomparing.CompareInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import pkg06_comparing.mycomparing.MyComparing;

/**
 *
 * @author David Šafařík
 */
public class Comparing {
    public static void main(String[] args){
        Student[] students = DataSource.loadDataAsArray();
        System.out.println(students[0].equals(students[1]));
        
        MyComparing.print(students);
        
        System.out.println("sourt by firstname");
        Arrays.sort(students, new ComparatorByFirstName()); //nemusi byt uz typove kompatibilni
        MyComparing.print(students);
        
        System.out.println("sourt by lastname");
        //anonymni trida implementujici ComparatorInterface
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //takhle prevedu do cz, aby to sortilo podle ceskych pravidel
                Collator col = Collator.getInstance(new Locale("cs","CZ")); //tovarni metoda
                return col.compare(o1.getLastName(), o2.getLastName());
//                return o1.getLastName().compareTo(o2.getLastName()); //trideni podle ascii
            }
        });
        //lambda vyraz... je to zkraceny zapis, docela usporny
        //Arrays.sort(students, (Student o1, Student o2) -> o1.getLastName().compareTo(o2.getLastName()));
        MyComparing.print(students);
        
        
        System.out.println("Sort podle známek");
        MyComparing.print(students);
        Arrays.sort(students, new ComparatorByGrades());
        
        
//        System.out.println("sort by number");
//        print(students);
//        System.out.println("sorted:");
//        Arrays.sort(students); //student must be typove  kompatibilni s comparable<Student>
//        print(students);
//        
//        List<Student> students1 = DataSource.loadDataAsList();
//        print(students1);
//        System.out.println("SOrt bz number");
//        Collections.sort(students1);
//        print(students1);
    }
    
    public static void print(CompareInterface[] array){
        for (CompareInterface object : array) {
            System.out.println(object.toString());
        }
    }
    
    public static void print(List array){
        for (Object o : array) {
            System.out.println(o.toString());
        }
    }
}
