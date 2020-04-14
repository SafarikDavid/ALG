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
    private final int GRADE_CAPACITY = 10;
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
        this.grades = new int[0];
    }
    
    public Student(String firstName, String lastName, int age, int number, int[] grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.number = number;
        this.grades = new int[0];
        addGrades(grades);
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", number=" + number + ", averageG=" + averageG + '}';
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
        double epsilon = .0001;
        if(Math.abs(this.averageG - o.averageG) < epsilon){
            return 0;
        }else if((this.averageG - o.averageG) > 0){
            return 1;
        }else{
            return -1;
        }
    }
    
    private void checkGradeCapacity(){
        if (grades.length > GRADE_CAPACITY){
            int temp[] = new int[GRADE_CAPACITY];
            System.arraycopy(this.grades, 0, temp, 0, temp.length);
            this.grades = temp;
        }
    }
    
    public void addGrades(int[] grades){
        if(this.grades.length > 0){
            int temp[] = new int[this.grades.length + grades.length];
            System.arraycopy(this.grades, 0, temp, 0, this.grades.length);
            System.arraycopy(grades, 0, temp, this.grades.length, grades.length);
            this.grades = temp;
        }else{
            this.grades = grades;
        }
        checkGradeCapacity();
        computeAverageGrade();
    }
    
    public void computeAverageGrade(){
        double average = 0;
        for(int g : grades){
            average += g;
        }
        average /= this.grades.length;
        this.averageG = average;
    }
    
    public void displayGrades(){
        System.out.print("{ ");
        for(int i : grades){
            System.out.print(i + " ");
        }
        System.out.print("}\n");
    }
    
    public static void main(String [] args){
        Student s = new Student("Pavel","Podhorsky",15,1234);
        System.out.println(s.toString());
        int grades[] = {1 , 5 , 4};
        s.addGrades(grades);
        System.out.println(s.toString());
        Student s2 = new Student("Petr","Podhorsky",16,4321,grades);
        System.out.println(s2.toString());
        System.out.println(s2.compareTo(s));
        s2.addGrades(grades);
        s2.addGrades(grades);
        s2.addGrades(grades);
        System.out.println(s2.toString());
        s2.displayGrades();
        System.out.println(s2.compareTo(s));
        System.out.println(s.compareTo(s2));
    }
}
