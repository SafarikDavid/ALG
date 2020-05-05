/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

/**
 *
 * @author David Šafařík
 */
public interface CmdInterface {
    //napsat dokumentaci abych vedel co od toho cekat
    
    public boolean isRunning();
    
    public String getActualDir();
    
    public String parseAndExecute(String line);
    
}
