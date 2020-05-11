package safarik_hurricane;

import java.util.Comparator;

/**
 *
 * @author David
 */
public class ComparatorBySpeed implements Comparator<Hurricane>{

    @Override
    public int compare(Hurricane o1, Hurricane o2) {
        double epsilon = .01;
        double diff = o1.getSpeed() - o2.getSpeed();
        if(Math.abs(diff) < epsilon){
            return 0;
        }else if((diff) > 0){
            return 1;
        }else{
            return -1;
        }
    }
}
