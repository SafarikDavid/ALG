package App;

import filehandling.BinaryWriterBook;
import filehandling.TextReaderBook;
import filehandling.TextWriterBook;
import filehandling.Writer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import sun.text.normalizer.UTF16;
import comparing.*;

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

    /**
     * Načte data o inventáři ze souboru.
     * @param path cesta k souboru
     * @throws IOException 
     */
    public void loadData(String path) throws IOException {
        if(path.endsWith(".txt")){
            books = new TextReaderBook().load(path);
        }else if(path.endsWith(".dat")){
            books = null;
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
     * Přidá knihu do inventáře.
     * @param book instance Book class
     */
    public void addBook(Book book) {
        books.add(book);
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
            bi.loadData("data/BooksInventorynew.txt");
        }catch(IOException e){
            System.out.println("soubor neexistuje");
        }
        System.out.println(bi.toString());
//        bi.addBook(new Book("Petr", "Petr", 789, "12/5/188"));
//        System.out.println(bi.toString());
//        bi.saveData("data/BooksInventorynew.dat");
    }

    
    
}
