package comparing;

import App.Client;
import java.util.Comparator;

/**
 *
 * @author David
 */
public class ClientComparatorByLastName implements Comparator<Client>{

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
    
}
