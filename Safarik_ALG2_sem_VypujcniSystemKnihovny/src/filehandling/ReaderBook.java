/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import App.Book;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public abstract class ReaderBook {
    public abstract ArrayList<Book> load(String path) throws IOException;
}
