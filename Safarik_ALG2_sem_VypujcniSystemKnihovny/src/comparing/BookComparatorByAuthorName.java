/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
