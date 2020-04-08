package shapes;

/**
 *
 * @author David Šafařík
 */
public abstract class Shape {
    //data
    //protected je viditelne pro potomky
    //bez atributu je to package friendly.. vidi to veci z baliku
    protected String name = "Geometric shape";
    
    //methods
    //potomci zdedi ze maji tuto metodu, ale musi ji mit naimplementovanou sami
    public abstract double computeArea();
    
    public String getShapeName(){
        return this.getClass().getSimpleName();
    }
    
    @Override
    public String toString(){
        return name + " " + getShapeName();
    }
}
