package comparing;

import App.Book;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author David
 */
public class BookComparatorByPublishDate implements Comparator<Book>{
    
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPublishDate().compareTo(o2.getPublishDate());
    }
    
}
