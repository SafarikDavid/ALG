/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_competition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author David Šafařík
 */
public class TextWriter extends Writer{

    @Override
    public void save(String resultFilePath, List<Runner> runners) throws IOException{
        try(PrintWriter outResultFile = new PrintWriter(new BufferedWriter(new FileWriter(new File(resultFilePath), true)))){
            //outResultFile = new PrintWriter(ne OutputStreamWriter(<File>, <encoding>, <append>)
            int n = 1;
            for (Runner r : runners) {
                outResultFile.print(n + ". ");
                outResultFile.println(r);
                n++;
            }
        }
    }
    
}
