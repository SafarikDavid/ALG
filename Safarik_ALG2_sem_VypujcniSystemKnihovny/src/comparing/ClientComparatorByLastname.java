/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparing;

import App.Client;
import java.util.Comparator;

/**
 *
 * @author David
 */
public class ClientComparatorByLastname implements Comparator<Client>{

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
    
}
