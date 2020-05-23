package App;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author David Šafařík
 */
public class Book {
    private String name;
    private String authorName;
    private int ISBN;
    private Date publishDate;
    public final static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yy");

    public Book(String name, String authorName, int ISBN, Date publishDate) {
        this.name = name;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getISBN() {
        return ISBN;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    @Override
    public String toString() {
        return name + " " + authorName + " " + ISBN + " " + SDF.format(publishDate);
    }
    
    public static void main(String[] args){
        Date date = new Date(1958, 5, 15);
        Book book = new Book("Pavel", "Honza Nedved", 789456, date);
        System.out.println(book);
    }
    
}
