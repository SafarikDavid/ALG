/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import App.Book;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class BinaryReaderBook extends ReaderBook{

    @Override
    public ArrayList<Book> load(String path) throws IOException {
        ArrayList<Book> books = new ArrayList<>();
        try(DataInputStream dis = new DataInputStream(new FileInputStream(new File(path)))){
            while(dis.available() > 0){
                String k = dis.readUTF();
                String[] parts = k.split("[ ]*%[ ]*");
                boolean part4 = false;
                if(parts[4].equalsIgnoreCase("true")){
                    part4 = true;
                }
                try {
                    Book b = new Book(parts[0], parts[1], Long.parseLong(parts[2]), parts[3], part4);
                } catch (ParseException ex) {
                    System.out.println("Chyba formátu data.");
                }
            }
        }
        return books;
    }
    
    public static void main(String[] args) throws IOException{
        ReaderBook r = new BinaryReaderBook();
        ArrayList<Book> p = r.load("data/BooksInventorynew.dat");
        for(Book b : p){
            System.out.println(b.toString());
        }
    }
    
}
