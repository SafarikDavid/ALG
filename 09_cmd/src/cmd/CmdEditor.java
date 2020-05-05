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
public class CmdEditor implements CmdInterface {
    static private boolean isRunning;
    static private File actualDir;
    private Command command;
    
    public CmdEditor() {
        isRunning = true;
        actualDir = new File(System.getProperty("user.dir"));
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }
    
    public static void renameActualDir(File newDir){
        actualDir = newDir;
    }
    
    public static void setIsRunning(boolean isRunning){
        CmdEditor.isRunning = isRunning;
    }

    @Override
    public String parseAndExecute(String line) {
        //parse
        command = Parser.parse(line);
        //execute
        return command.execute(actualDir);
    }
    
}
