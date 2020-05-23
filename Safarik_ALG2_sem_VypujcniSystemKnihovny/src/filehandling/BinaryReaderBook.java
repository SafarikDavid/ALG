/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import App.Book;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class BinaryReaderBook extends Reader{

    @Override
    public ArrayList<Book> load(String path) throws IOException {
        ArrayList<Book> books = new ArrayList<>();
        FileInputStream fis = null;
        BufferedInputStream reader = null;
        try{
            fis = new FileInputStream(new File(path));
            reader = new BufferedInputStream(fis);
            while((line = reader.read()) != -1){
                
            }
        }finally{
            reader.close();
        }
        return books;
    }
    
}
