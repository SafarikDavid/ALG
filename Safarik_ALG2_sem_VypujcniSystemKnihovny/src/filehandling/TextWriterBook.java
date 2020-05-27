/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import App.Book;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author David
 */
public class TextWriterBook extends WriterBook{

    @Override
    public void save(String path, List<Book> books) throws IOException {
        try(PrintWriter outFile = new PrintWriter(new BufferedWriter(new FileWriter(new File(path), true)))){
            for (Book b : books) {
                outFile.print(b.getName());
                outFile.print(" % ");
                outFile.print(b.getAuthorName());
                outFile.print(" % ");
                outFile.print(b.getISBN());
                outFile.print(" % ");
                outFile.print(b.getPublishDateString());
                outFile.print(" % ");
                outFile.println(b.isIsRented());
            }
        }
    }
    
}
