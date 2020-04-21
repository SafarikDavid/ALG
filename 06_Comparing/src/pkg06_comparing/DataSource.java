package pkg06_comparing;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author David Šafařík
 */
public class DataSource {
    private static Student[] data = {
        new Student("Jan", "Maly", 21, 6234, new int[]{1,5}), 
        new Student("Saul", "Heavy", 17, 5432, new int[]{1,5,3,4}),
        new Student("Elizabeth", "grace", 18, 3533, new int[]{1,1,1,2,5})
    };
    
    public static Student[] loadDataAsArray(){
        return Arrays.copyOf(data, data.length);
    }
    
    public static List<Student> loadDataAsList(){
        return Arrays.asList(data);
    }
}
