package App;

import java.io.IOException;

/**
 *
 * @author David
 */
public class MainApp {
    private BookInventory booksInv = new BookInventory();
    private ClientsList clients = new ClientsList();
    
    public void loadAllData(String pathToBookInventory, String pathToClientsList) throws IOException{
        booksInv.loadData(pathToBookInventory);
        clients.loadData(pathToClientsList);
    }
    
    public void saveAllData(String pathToBookInventory, String pathToClientsList) throws IOException{
        booksInv.saveData(pathToBookInventory);
        clients.saveData(pathToClientsList);
    }
    
    
    
}
