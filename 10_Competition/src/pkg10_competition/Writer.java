/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_competition;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author David Šafařík
 */
public abstract class Writer {
    public abstract void save(String resultFilePath, List<Runner> runners) throws IOException
            ;
}
