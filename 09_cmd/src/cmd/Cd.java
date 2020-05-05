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
public class Cd extends Command{

    @Override
    public String execute(File actualDir) {
        if("..".equals(params[1])){
            File newDir = new File(actualDir.getParent());
            CmdEditor.renameActualDir(newDir);
        }else if(params[1].contains(separator)){
            File newDir = new File(params[1]);
            if(newDir.isDirectory()){
                CmdEditor.renameActualDir(newDir);
            }
        }else{
            File newDir = new File(actualDir.getAbsolutePath() + separator + params[1]);
            CmdEditor.renameActualDir(newDir);
        }
        return "Change dir";
    }
    
}
