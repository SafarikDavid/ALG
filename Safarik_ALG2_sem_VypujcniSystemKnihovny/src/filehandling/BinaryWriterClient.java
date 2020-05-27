/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import App.Client;
import App.RentedBook;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author David
 */
public class BinaryWriterClient extends WriterClient{

    @Override
    public void save(String path, List<Client> clientsList) throws IOException {
        try(DataOutputStream outFile = new DataOutputStream(new FileOutputStream(path))){
            for(Client c : clientsList){
                StringBuilder sb = new StringBuilder();
                sb.append(c.getFirstName());
                sb.append(" ");
                sb.append(c.getLastName());
                sb.append(" ");
                sb.append(c.getID());
                sb.append(" ");
                sb.append(c.getEmail());
                sb.append("\n");
                for(RentedBook b : c.getRentedBooks()){
                    sb.append(b.getName());
                    sb.append(" % ");
                    sb.append(b.getAuthorName());
                    sb.append(" % ");
                    sb.append(b.getISBN());
                    sb.append(" % ");
                    sb.append(b.getPublishDateString());
                    sb.append(" % ");
                    sb.append(b.getRentDateString());
                    sb.append("\n");
                }
                sb.append(";\n");
                outFile.writeUTF(sb.toString());
            }
        }
    }
    
}
