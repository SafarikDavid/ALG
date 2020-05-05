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
public class Parser {
    public static Command parse(String line){
        if(line.length() > 0){
            String[] p = line.split(" +");
            //TODO prazdny prikaz
            char first = Character.toUpperCase(p[0].charAt(0)); //D
            String name = Command.COMMAND_PACKAGE + "." + first + p[0].substring(1); //cmd.Dir
            try{
                Class c = Class.forName(name);
                Command command = (Command) c.newInstance();
                command.setParams(p);
                return command;
            }catch(Exception e){
                throw new RuntimeException("Nepodarilo se prikaz naparsovat.");
            }
        }else{
            return new Command() {
                @Override
                public String execute(File actualDir) {
                    return "";
                }
            };
        }
    }
}
