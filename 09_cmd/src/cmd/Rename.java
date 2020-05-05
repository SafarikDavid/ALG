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
public class Rename extends Command{

    @Override
    public String execute(File actualDir) {
        if(params[1].contains(separator) && params[2].contains(separator)){
            File file = new File(params[1]);
            File newFileName = new File(params[2]);
            file.renameTo(newFileName);
        }else if(params[1].contains(separator)){
            File file = new File(params[1]);
            File newFileName = new File(file.getAbsolutePath() + separator + params[2]);
            file.renameTo(newFileName);
        }else{
            File file = new File(actualDir.getAbsolutePath() + separator + params[1]);
            File newFileName = new File(actualDir.getAbsolutePath() + separator + params[2]);
            file.renameTo(newFileName);    
        }
        return "Rename";
    }
    
}
