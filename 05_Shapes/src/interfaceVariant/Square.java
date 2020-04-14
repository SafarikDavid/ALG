package interfaceVariant;

/**
 *
 * @author David Šafařík
 */
public class Square extends Rectangle {//IS A each square is a rectangle
    //data
    private double a;
    private double area;
    
    //musim pouzit constructor z puvodni tridy
    //ale tim super to obejdu a muzu mu dat treba jenom takhle min parametru
    public Square (double a){
        super(a,a);
        this.a = a;
        this.area = computeArea();
    }

    @Override
    public String toString() {
        return this.getShapeName() + String.format(" a = %.2f", a);
    }
    
    public static void main(String[] args){
        Square s = new Square(4);
        System.out.println(s.toString());
        System.out.println(s.computeArea());
        System.out.println(s.getArea());
    }
    
}
