package interfaceVariant;

/**
 *
 * @author David Šafařík
 */
public interface ShapeInterface {
    //data
    final String NAME = "Geometric shape";
    
    //methods
    public double computeArea();
    
    default String getShapeName(){
        return this.getClass().getSimpleName();
    }
}
