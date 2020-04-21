package inheritanceVariant;

/**
 *
 * @author David Šafařík
 */
public abstract class Shape implements Comparable<Shape>{
    //data
    //protected je viditelne pro potomky
    //bez atributu je to package friendly.. vidi to veci z baliku
    protected String name = "Geometric shape";
    
    //methods
    //potomci zdedi ze maji tuto metodu, ale musi ji mit naimplementovanou sami
    public abstract double computeArea();
    
    public abstract double getArea();
    
    public String getShapeName(){
        return this.getClass().getSimpleName();
    }
    
    @Override
    public String toString(){
        return name + " " + getShapeName();
    }
    
    @Override
    public int compareTo(Shape s){
        double EPS = 0.0001;
        double diff = this.getArea() - s.getArea();
        
        if(Math.abs(diff) < EPS){
            return 0;
        }else if(diff < 0){
            return -1;
        }else{
            return 1;
        }
    }
}
