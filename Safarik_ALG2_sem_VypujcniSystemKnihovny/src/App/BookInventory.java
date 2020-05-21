package App;

import java.util.ArrayList;

/**
 *
 * @author David Šafařík
 */
public class BookInventory {
    private ArrayList<Book> books = new ArrayList<>();

    public BookInventory() {
    }
    
    public BookInventory(ArrayList<Book> books) {
        this.books = books;
    }

    public void loadData(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void saveData(String path){
        
    }
    
}
