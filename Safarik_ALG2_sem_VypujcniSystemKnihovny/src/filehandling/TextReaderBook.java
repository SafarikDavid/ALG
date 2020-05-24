/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import App.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author David
 */
public class TextReaderBook extends Reader{

    @Override
    public ArrayList<Book> load(String path) throws IOException {
        ArrayList<Book> books = new ArrayList<>();
        File pathToFile = new File(path);
        BufferedReader bookInv = null;
        try{
            bookInv = new BufferedReader(new FileReader(pathToFile));
            String line;
            while((line = bookInv.readLine()) != null){
                String[] parts = line.split("[ ]*&[ ]*");
                try{
                    boolean part4 = false;
                    if(parts[4].equalsIgnoreCase("true")){
                        part4 = true;
                    }
                    books.add(new Book(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], part4));
                }catch(NoSuchElementException e){
                    if(bookInv != null) bookInv.close();
                } catch (ParseException ex) {
                    System.out.println("Nepodporovaný formát data.");
                }
            }
        }finally{
            if(bookInv != null) bookInv.close();
        }
        return books;
    }
    
}
