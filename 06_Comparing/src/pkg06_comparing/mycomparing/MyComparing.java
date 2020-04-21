package pkg06_comparing.mycomparing;

import pkg06_comparing.DataSource;
import pkg06_comparing.Student;

/**
 *
 * @author David Šafařík
 */
public class MyComparing {
    public static void main(String[] args){
        Student[] students = DataSource.loadDataAsArray();
        print(students);
        System.out.println("Sort by number");
        sort(students, new ComparatorStudentByNumber());
        print(students);
        System.out.println("Sort by first name");
        sort(students, new ComparatorStudentByFirstName());
        print(students);
//        System.out.println(students[0].equals(students[0].equals(students[1])));
//        print(students);
//        System.out.println("Sorting by number:");
//        sortByNumber(students);
//        print(students);
//        System.out.println("");
//        print(students);
//        System.out.println("Sorting by age:");
//        sortByAge(students);
//        print(students);
//        System.out.println("");
//        print(students);
//        System.out.println("Sorting by number:");
//        sort(students);
//        print(students);
    }
    
    public static void sort(CompareInterface[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = 1; j < array.length-i; j++){
                if(array[j-1].isSmaller(array[j])){
                    CompareInterface temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;  
                }
            }
        }
    }
    
    private static void sortByNumber(Student[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = 1; j < array.length-i; j++){
                if(array[j-1].startLater(array[j])){
                    Student temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    
    private static void sortByAge(Student[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = 1; j < array.length-i; j++){
                if(array[j-1].isOlder(array[j])){
                    Student temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    
    //tridi pole jakychkoliv objektu, metoda bigger objektu typove kompatibilniho s ComparatorInterface definuje jak tridit
    public static void sort(Object [] array, ComparatorInterface comparator){
        for(int i = 0; i < array.length-1; i++){
            for(int j = 1; j < array.length-i; j++){
                if(comparator.bigger(array[j-1],array[j])){
                    Object temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }   
    }
    
    public static void print(CompareInterface[] array){
        for (CompareInterface object : array) {
            System.out.println(object.toString());
        }
    }
}
