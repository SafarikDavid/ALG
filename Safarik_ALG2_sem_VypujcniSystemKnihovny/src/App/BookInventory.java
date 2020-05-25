package App;

import filehandlingbookinventory.BinaryWriterBook;
import filehandlingbookinventory.TextReaderBook;
import filehandlingbookinventory.TextWriterBook;
import filehandlingbookinventory.Writer;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import comparing.*;
import filehandlingbookinventory.BinaryReaderBook;

/**
 *
 * @author David Šafařík
 */
public class BookInventory {
    private ArrayList<Book> books = new ArrayList<>();

    public BookInventory() {
    }
    
    /**
     * Načte data o inventáři ze souboru.
     * @param path cesta k souboru
     * @throws IOException 
     */
    public void loadData(String path) throws IOException {
        if(path.endsWith(".txt")){
            books = new TextReaderBook().load(path);
        }else if(path.endsWith(".dat")){
            books = new BinaryReaderBook().load(path);
        }else{
            throw new IllegalArgumentException("Nepodporovana koncovka souboru.");
        }
    }
    
    /**
     * Ukládá data o inventáři do souboru.
     * @param path cesta k souboru
     * @throws IOException 
     */
    public void saveData(String path) throws IOException{
        Writer w;
        if(path.endsWith(".txt")){
            w = new TextWriterBook();
        }else if(path.endsWith(".dat")){
            w = new BinaryWriterBook();
        }else{
            throw new IllegalArgumentException("Nepodporovana koncovka souboru.");
        }
        File out = new File(path);
        out.delete();
        w.save(path, books);
    }
    
    /**
     * Přidá novou knihu do inventáře.
     * @param book instance Book class
     */
    public void addBook(Book book) {
        books.add(book);
    }
    
    /**
     * Vypůjčí knihu. Změní stav knihy na vypůjčeno.
     * @param ISBN
     * @return True, pokud je kniha v inventáři; False, pokud se nepodařilo knihu najít
     */
    public boolean rentOutBook(int ISBN){
        int i = findBookByISBN(ISBN);
        if(i >= 0){
            books.get(i).setIsRented(true);
            return true;
        }
        return false;
    }
    
    /**
     * Vrátí knihu. Změní stav knihy v inventáři na nevypůjčeno.
     * @param ISBN
     * @return pokud nebude nalezena kniha s daným ISBN v seznamu, vrátí false, jinak true
     */
    public boolean returnBook(int ISBN){
        int i = findBookByISBN(ISBN);
        if(i >= 0){
            books.get(i).setIsRented(false);
            return true;
        }
        return false;
    }
    
    /**
     * Najde knihu podle ISBN hodnoty, vrátí její index v listu.
     * @param ISBN
     * @return index v listu, nebo -1 když neni v seznamu
     */
    private int findBookByISBN(int ISBN){
        int i = 0;
        for(Book b : books){
           if(b.getISBN() == ISBN){
               return i;
           }
           i++;
        }
        return -1;
    }
    
    /**
     * Setřídí seznam knih podle názvu knihy.
     */
    public void sortByName(){
        Collections.sort(books, new BookComparatorByName());
    }
    
    /**
     * Setřídí seznam knih podle jména autora.
     */
    public void sortByAuthorName(){
        Collections.sort(books, new BookComparatorByAuthorName());
    }
    
    /**
     * Setřídí seznam knih podle data vydání.
     */
    public void sortByPublishDate(){
        Collections.sort(books, new BookComparatorByPublishDate());
    }
    
    public ArrayList<Book> getBooksList(){
        return books;
    }
    
    /**
     * Najde a vrátí knihu v seznamu podle ISBN.
     * @param ISBN ISBN knihy
     * @return Book podle ISBN; Null, pokud se nepodaří knihu nalézt v seznamu
     */
    public Book getBookByISBN(int ISBN){
        if(findBookByISBN(ISBN) >= 0){
            return books.get(findBookByISBN(ISBN));
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Book b : books){
            sb.append(b.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws ParseException, IOException{
        BookInventory bi = new BookInventory();
        try{
            bi.loadData("data/BooksInventory.txt");
        }catch(IOException e){
            System.out.println("soubor neexistuje");
        }
        System.out.println(bi.toString());
        bi.addBook(new Book("Petr", "Petr", 789, "12/5/188"));
        bi.addBook(new Book("FD","F",789789,"12/1/1597"));
        System.out.println("bi\n"+bi.toString());
        bi.saveData("data/BooksInventorynew.dat");
        BookInventory bitch = new BookInventory();
        bitch.loadData("data/BooksInventorynew.dat");
        System.out.println("Bitch\n"+bi.toString());
    }

    
    
}
