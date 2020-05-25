package App;

import filehandlingclients.BinaryReaderClient;
import filehandlingclients.BinaryWriterClient;
import filehandlingclients.TextReaderClient;
import filehandlingclients.TextWriterClient;
import filehandlingclients.Writer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
    
    public void loadData(String path) throws IOException {
        if(path.endsWith(".txt")){
            clients = new TextReaderClient().load(path);
        }else if(path.endsWith(".dat")){
            clients = new BinaryReaderClient().load(path);
        }else{
            throw new IllegalArgumentException("Nepodporovaná koncovka souboru.");
        }
    }
    
    public void saveData(String path) throws IOException{
        Writer w;
        if(path.endsWith(".txt")){
            w = new TextWriterClient();
        }else if(path.endsWith(".dat")){
            w = new BinaryWriterClient();
        }else{
            throw new IllegalArgumentException("Nepodporovaná koncovka souboru.");
        }
        File out = new File(path);
        out.delete();
        w.save(path, clients);
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
     * @return true, pokud se podařilo odstranit klienta ze seznamu, jinak false
     */
    public boolean removeClient(int ID){
        int i = findClientByID(ID);
        if(i >= 0){
            clients.remove(i);
            return true;
        }
        return false;
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
    
    public static void main(String[] args) throws IOException{
        ClientsList cl = new ClientsList();
        cl.loadData("data/ClientsList.txt");
        System.out.println(cl.toString());
        cl.saveData("data/ClientsListCopy.txt");
        cl.saveData("data/ClientsListCopy.dat");
        cl.loadData("data/ClientsListCopy.dat");
        System.out.println("Ahooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n"+cl.toString());
    }
    
}
