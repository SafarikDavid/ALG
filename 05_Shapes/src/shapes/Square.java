package shapes;

/**
 *
 * @author David Šafařík
 */
public class Square extends Rectangle {//IS A each square is a rectangle
    //data
    private double a;
    
    //musim pouzit constructor z puvodni tridy
    //ale tim super to obejdu a muzu mu dat treba jenom takhle min parametru
    public Square (double a){
        super(a,a);
        this.a = a;
    }

    @Override
    public String toString() {
        return "Square{" + "a=" + a + '}';
    }
    
    public static void main(String[] args){
        Square s = new Square(4);
        System.out.println(s.toString());
        System.out.println(s.area());
    }
    
}
