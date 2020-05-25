/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandlingclients;

import App.Client;
import App.RentedBook;
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
public class TextWriterClient extends Writer{

    @Override
    public void save(String path, List<Client> clientsList) throws IOException {
        try(PrintWriter outWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(path), true)))){
            for(Client c : clientsList){
                outWriter.print(c.getFirstName());
                outWriter.print(" ");
                outWriter.print(c.getLastName());
                outWriter.print(" ");
                outWriter.print(c.getID());
                outWriter.print(" ");
                outWriter.println(c.getEmail());
                for(RentedBook b : c.getRentedBooks()){
                    outWriter.print(b.getName());
                    outWriter.print(" % ");
                    outWriter.print(b.getAuthorName());
                    outWriter.print(" % ");
                    outWriter.print(b.getISBN());
                    outWriter.print(" % ");
                    outWriter.print(b.getPublishDateString());
                    outWriter.print(" % ");
                    outWriter.println(b.getRentDateString());
                }
                outWriter.println(";");
            }
        }
    }
    
}
