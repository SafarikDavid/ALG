package inheritanceVariant;

/**
 *
 * @author David Šafařík
 */
public class Circle extends Shape {
    //data
    private double r;
    private double area;

    public Circle(double r) {
        this.r = r;
        this.area = computeArea();
    }
    
    //udelat za DU
    //TODO udelat pomoci tovarni metody
    public static Circle getInstanceD(double d) {
        return new Circle(d/2);
    }
    
    public static Circle getInstanceR(double r){
        return new Circle(r);
    }
    
    public double getR(){
        return r;
    }
    
    @Override
    public double getArea(){
        return area;
    }

    @Override
    public String toString() {
        //return "Circle{" + "r=" + r + '}';
        return super.toString() + String.format(" r = %.2f", r);
    }
    
    @Override
    public double computeArea(){
        return Math.PI*r*r;
    }
    
    public static void main(String[] args){
        Circle c = new Circle(5);
        System.out.println(c.getR());
        System.out.println(c.toString());
        System.out.println(c.computeArea());
        System.out.println(c.name);
        System.out.println(c.getShapeName());
    }
}
