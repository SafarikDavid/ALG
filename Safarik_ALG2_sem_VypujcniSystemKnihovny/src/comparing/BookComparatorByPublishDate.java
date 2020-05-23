/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
