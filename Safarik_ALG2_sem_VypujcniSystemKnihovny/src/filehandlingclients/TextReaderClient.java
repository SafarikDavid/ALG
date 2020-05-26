/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandlingclients;

import App.Client;
import App.RentedBook;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class TextReaderClient extends Reader{

    @Override
    public ArrayList<Client> load(String path) throws IOException {
        ArrayList<Client> clientsList = new ArrayList<>();
        try(BufferedReader clientsListReader = new BufferedReader(new FileReader(new File(path)))){
            String clientLine;
            while((clientLine = clientsListReader.readLine()) != null){
                String[] clientParts = clientLine.split("[ ]+");
                Client tempClient = new Client(clientParts[0], clientParts[1], Integer.parseInt(clientParts[2]), clientParts[3]);
                String bookLine;
                while(!(bookLine = clientsListReader.readLine()).contains(";")){
                    String[] bookParts = bookLine.split("[ ]*%[ ]*");
                    try {
                        tempClient.rentBook(new RentedBook(bookParts[0], bookParts[1], Long.parseLong(bookParts[2]), bookParts[3], bookParts[4]));
                    } catch (ParseException ex) {
                        System.out.println("Špatný formát data.");
                    }
                }
                clientsList.add(tempClient);
            }
        }
        return clientsList;
    }
    
}
