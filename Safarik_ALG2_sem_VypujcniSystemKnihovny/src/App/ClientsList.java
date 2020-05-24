package App;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David Šafařík
 */
public class ClientsList {
    private ArrayList<Client> clients;    

    public ClientsList() {
        clients = new ArrayList<>();
    }

    public ClientsList(ArrayList<Client> clients) {
        this.clients = clients;
    }
    
    public void loadData(String path) {
        
    }
    
    public void saveData(String path){
        
    }
    
    /**
     * Přidá klienta do seznamu.
     * @param client Client class instance
     */
    public void addClient(Client client){
        clients.add(client);
    }
    
    /**
     * Odstraní klienta ze seznamu.
     * @param ID číslo přidělené klientovi
     */
    public void removeClient(int ID){
        for(Client c : clients){
            if(c.getID() == ID){
                clients.remove(c);
            }
        }
    }
    
    /**
     * Najde klienta podle čísla ID. Vrátí index v seznamu klientů.
     * @param ID
     * @return -1 pokud nenalezen, jinak index v seznamu klientů
     */
    private int findClientByID(int ID){
        int i = 0;
        for(Client c : clients){
            if(c.getID() == ID){
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Client c : clients){
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
        ClientsList cl = new ClientsList();
        cl.addClient(new Client("Pavel","Vorisek",32));
        Date da = new Date(345,543,543);
        cl.addClient(new Client("Ahoj", "Jak", 32));
        System.out.println(cl.toString());
    }
    
}
