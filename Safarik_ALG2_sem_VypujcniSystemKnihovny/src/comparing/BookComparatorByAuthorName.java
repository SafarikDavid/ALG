package comparing;

import App.Book;
import java.util.Comparator;

/**
 *
 * @author David
 */
public class BookComparatorByAuthorName implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getAuthorName().compareTo(o2.getAuthorName());
    }
    
}
