/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;
import java.util.Scanner;
/**
 *
 * @author David Šafařík
 */
public class CmdUI {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        CmdInterface cmd = new CmdEditor();
        
        String line;
        while(cmd.isRunning()){
            System.out.print(cmd.getActualDir() + "> ");
            line = sc.nextLine();
            try{
                System.out.print(cmd.parseAndExecute(line));
            }catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
}
