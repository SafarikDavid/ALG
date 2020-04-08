package pkg06_comparing;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author David Šafařík
 */
public class DataSource {
    private static Student[] data = {
        new Student("Jan", "Maly", 21, 6234),
        new Student("Saul", "Heavy", 17, 5432),
        new Student("Elizabeth", "Grace", 18, 3533)
    };
    
    public static Student[] loadDataAsArray(){
        return Arrays.copyOf(data, data.length);
    }
    
    public static List<Student> loadDataAsList(){
        return Arrays.asList(data);
    }
}
