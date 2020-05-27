/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import App.Book;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author David
 */
public abstract class WriterBook {
    public abstract void save(String path, List<Book> books) throws IOException;
}
