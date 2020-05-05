/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;

/**
 *
 * @author David Šafařík
 */
public class Mkdir extends Command{

    @Override
    public String execute(File actualDir) {
        File newDir = new File(actualDir.getAbsolutePath() + separator + params[1]);
        newDir.mkdir();
        return "Made dir";
    }
    
}
