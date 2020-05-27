/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import App.Client;
import App.RentedBook;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class BinaryReaderClient extends ReaderClient{

    @Override
    public ArrayList<Client> load(String path) throws IOException {
        ArrayList<Client> clientList = new ArrayList<>();
        try(DataInputStream dis = new DataInputStream(new FileInputStream(new File(path)))){
            while(dis.available() > 0){
                String c = dis.readUTF();
                String[] wholeClientParts = c.split("\n");
                
                //výtah klienta
                String[] onlyClientParts = wholeClientParts[0].split("[ ]+");
                Client tempClient = new Client(onlyClientParts[0], onlyClientParts[1], Integer.parseInt(onlyClientParts[2]), onlyClientParts[3]);
                
                //výtah půjčených knih
                for (int i = 1; i < wholeClientParts.length - 1; i++) {
                    String[] bookParts = wholeClientParts[i].split("[ ]*%[ ]*");
                    try {
                        tempClient.rentBook(new RentedBook(bookParts[0], bookParts[1], Long.parseLong(bookParts[2]), bookParts[3], bookParts[4]));
                    } catch (ParseException ex) {
                        throw new IllegalArgumentException("Wrong date format.");
                    }
                }
                
                //pridat klienta do seznamu
                clientList.add(tempClient);
            }
        }
        return clientList;
    }
    
}
