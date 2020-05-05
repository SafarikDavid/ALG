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
public class Help extends Command{

    @Override
    public String execute(File actualDir) {
        String help = "HELP\n"
                + String.format("%-7s %s\n", "help", "Display help")
                + String.format("%-7s %s\n", "dir", "Display list of files and folders")
                + String.format("%-7s %s\n", "cd [folder]", "Change directory - move to a specific folder")
                + String.format("%-7s %s\n", "cd ..", "Change directory - move to parent folder")
                + String.format("%-7s %s\n", "mkdir [folder name]", "Create new folder")
                + String.format("%-7s %s\n", "exit", "Exit program cmd");
        return help;
    }
    
}
