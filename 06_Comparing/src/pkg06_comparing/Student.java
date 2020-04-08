package pkg06_comparing;

/**
 *
 * @author David Šafařík
 */
public class Student implements CompareInterface, Comparable<Student>{
    //data
    private String firstName;
    private String lastName;
    private int age;
    private int number;
    private int[] grades; //max 10
    private double averageG;
    
    //TODO
    //umoznit pridavat studentovi znamky
    //vypocitat prumer
    //zmenit compareTo, aby se tridilo podle prumeru, ale bacha na to, ze je to realne cislo -- pouzit porovnani realnych cisel
    //rozdil podle nejakeho epsilon, vracet -1 0 1

    public Student(String firstName, String lastName, int age, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", number=" + number + '}';
    }
    
    boolean startLater(Student student){
        return this.number > student.number;
    }

    boolean isOlder(Student student) {
        return this.age > student.age;
    }

    @Override
    public boolean isSmaller(CompareInterface o) {
        return this.number > ((Student)o).number;
    }

//    @Override
//    public int compareTo(Object o) { //yaporne, 0, kladne
//        return this.number - ((Student)o).number;
//    }

    //genericita
    @Override
    public int compareTo(Student o) {//zaporne, 0, kladne
        return this.number - o.number;
    }
}
