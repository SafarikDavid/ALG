/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_competition;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author David Šafařík
 */
public class BinaryWriter extends Writer {

    @Override
    public void save(String resultFilePath, List<Runner> runners) throws IOException {
        try(DataOutputStream outResultFile = new DataOutputStream(new FileOutputStream(resultFilePath))){
            int n = 1;
            for (Runner r : runners) {
                outResultFile.writeInt(n);
                outResultFile.writeChar('.');
                outResultFile.writeUTF(r.toString());
                n++;
            }
        }
    }
    
}
