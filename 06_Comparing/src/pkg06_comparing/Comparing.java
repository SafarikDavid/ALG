package pkg06_comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author David Šafařík
 */
public class Comparing {
    public static void main(String[] args){
        Student[] students = DataSource.loadDataAsArray();
        System.out.println("sort by number");
        print(students);
        System.out.println("sorted:");
        Arrays.sort(students); //student must be typove  kompatibilni s comparable<Student>
        print(students);
        
        List<Student> students1 = DataSource.loadDataAsList();
        print(students1);
        System.out.println("SOrt bz number");
        Collections.sort(students1);
        print(students1);
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
