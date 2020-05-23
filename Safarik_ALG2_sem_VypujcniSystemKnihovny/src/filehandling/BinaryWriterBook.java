/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import App.Book;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author David
 */
public class BinaryWriterBook extends Writer{

    @Override
    public void save(String path, List<Book> books) throws IOException {
        try(DataOutputStream outFile = new DataOutputStream(new FileOutputStream(path))){
            for (Book b : books) {
                StringBuilder sb = new StringBuilder();
                sb.append(b.getName());
                sb.append(" & ");
                sb.append(b.getAuthorName());
                sb.append(" & ");
                sb.append(b.getISBN());
                sb.append(" & ");
                sb.append(b.getPublishDateString());
                sb.append("\n");
                outFile.writeUTF(sb.toString());
            }
        }
    }
    
}
