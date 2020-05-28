package App;

import comparing.ClientComparatorByLastName;
import filehandling.BinaryReaderClient;
import filehandling.BinaryWriterClient;
import filehandling.TextReaderClient;
import filehandling.TextWriterClient;
import filehandling.WriterClient;
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
        WriterClient w;
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
     * Pokud je klient registrovaný, tak přidá knihu do seznamu vypůjčených.
     * @param ID ID klienta
     * @param book RentedBook
     * @return True, pokud byla kniha úspěšně přidána; False, pokud klient není registrovaný
     */
    public boolean rentBook(int ID, RentedBook book){
        int i = findClientByID(ID);
        if(i > 0){
            clients.get(i).rentBook(book);
            return true;
        }
        return false;
    }
    
    /**
     * Vrátí knihu podle zadaného ISBN.
     * @param ID ID klienta
     * @param ISBN ISBN hledané knihy
     * @return False, pokud klient neni v seznamu, nebo pokud kniha není v seznamu klienta, jinak true
     */
    public boolean returnBook(int ID, long ISBN){
        int i = findClientByID(ID);
        if(i >= 0){
            return clients.get(i).returnBook(ISBN);
        }
        return false;
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
     * @param ID ID klienta v seznamu
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
    
    /**
     * Zkontroluje, zda je klient se zadaným ID registrován.
     * @param ID ID klienta
     * @return true, pokud je ID v seznamu, jinak false
     */
    public boolean isIDRegistered(int ID){
        int i = findClientByID(ID);
        return i >= 0;
    }
    
    public ArrayList<Client> getClientList(){
        return clients;
    }
    
    /**
     * Setřídí seznam podle příjmení vzestupně.
     */
    public void sortByLastName(){
        for(int i = 0; i < clients.size(); i++){
            for(int j = 1; j < clients.size() - i; j++){
                if(new ClientComparatorByLastName().compare(clients.get(j-1), clients.get(j)) > 0){
                    Client temp = clients.get(j-1);
                    clients.set(j-1, clients.get(j));
                    clients.set(j, temp);
                }
            }
        }
    }
    
    /**
     * Setřídí seznam podle ID vzestupně.
     */
    public void sortByID(){
        for(int i = 0; i < clients.size(); i++){
            for(int j = 1; j < clients.size() - i; j++){
                if(clients.get(j-1).compareTo(clients.get(j)) > 0){
                    Client temp = clients.get(j-1);
                    clients.set(j-1, clients.get(j));
                    clients.set(j, temp);
                }
            }
        }
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
