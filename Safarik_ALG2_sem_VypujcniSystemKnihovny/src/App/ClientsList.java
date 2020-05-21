package App;

import java.util.ArrayList;

/**
 *
 * @author David Šafařík
 */
public class ClientsList {
    private ArrayList<Client> clients = new ArrayList<>();    

    public ClientsList() {
    }

    public ClientsList(ArrayList<Client> clients) {
        this.clients = clients;
    }
    
    public void loadData(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void saveData(String path){
        
    }
    
}
