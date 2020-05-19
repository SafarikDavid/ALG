package App;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author David
 */
public class Book {
    private String name;
    private String authorFirstName;
    private String authorLastName;
    private int ISBN;
    private Date publishDate;
    public final static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yy");

    public Book(String name, String authorFirstName, String authorLastName, int ISBN, Date publishDate) {
        this.name = name;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public int getISBN() {
        return ISBN;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    @Override
    public String toString() {
        return name + " " + authorFirstName + " " + authorLastName + " " + ISBN + " " + SDF.format(publishDate);
    }
    
    public static void main(String[] args){
        Date date = new Date(1958, 5, 15);
        Book book = new Book("Pavel", "Honza", "Nedved", 789456, date);
        System.out.println(book);
    }
    
}
