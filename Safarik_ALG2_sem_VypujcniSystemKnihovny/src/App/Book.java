package App;

import comparing.BookComparatorByPublishDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author David Šafařík
 */
public class Book {
    private String name;
    private String authorName;
    private long ISBN;
    private Date publishDate;
    protected final static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private boolean isRented;

    public Book(String name, String authorName, long ISBN, String publishDate) throws ParseException {
        this.name = name;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.publishDate = SDF.parse(publishDate);
        this.isRented = false;
    }
    
    public Book(String name, String authorName, long ISBN, Date publishDate) {
        this.name = name;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.isRented = false;
    }

    public Book(String name, String authorName, long ISBN, String publishDate, boolean isRented) throws ParseException {
        this.name = name;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.publishDate = SDF.parse(publishDate);
        this.isRented = isRented;
    }

    public Book(String name, String authorName, long ISBN, Date publishDate, boolean isRented) {
        this.name = name;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.isRented = isRented;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public long getISBN() {
        return ISBN;
    }

    public Date getPublishDate(){
        return publishDate;
    }
    
    public String getPublishDateString() {
        return SDF.format(publishDate);
    }

    public boolean isIsRented() {
        return isRented;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    @Override
    public String toString() {
        return name + ", " + authorName + ", " + ISBN + ", " + SDF.format(publishDate);
    }
    
    public static void main(String[] args) throws ParseException{
        Date date = new Date(1997-1900, 1, 12);
        Book book = new Book("Yavel", "Honza Nedved", 789456, "13/1/1998", false);
        Book book1 = new Book("Aavel", "Honza Nedved", 789456, date, false);
        System.out.println(book.isIsRented());
        System.out.println(book);
        System.out.println(book1);
        ArrayList<Book> ar = new ArrayList<>();
        ar.add(book);
        ar.add(book1);
        System.out.println(new BookComparatorByPublishDate().compare(book1, book));
        Collections.sort(ar, new BookComparatorByPublishDate());
        for (Book b : ar) {
            System.out.println(b.toString());
        }
    }
    
}
