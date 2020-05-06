package pkg10_competition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Šafařík
 */
class Competition {
    private ArrayList<Runner> runners = new ArrayList<>();
    
    public String getResults() {
        Collections.sort(runners);
        Iterator<Runner> iterator = runners.iterator();
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        while(iterator.hasNext()){
            Runner r = iterator.next();
            sb.append(String.format("%-4d. %s", n, r));
            n++;
        }
        return sb.toString();
    }

    public String saveResults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void load(String startFile, String finishFile) throws FileNotFoundException {
        //nacitani pomoci scanneru
        File startFileF = new File(startFile);
        Scanner inStart = new Scanner(startFileF);
        while(inStart.hasNext()){
            int number = inStart.nextInt();
            String firstName = inStart.next();
            String lastName = inStart.next();
            String startTime = inStart.next();
            Runner r = new Runner(firstName, lastName, number);
            r.setStartTime(startTime);
            runners.add(r);
        }
        //nacitani BufferBreeder
        File finishFileF = new File(finishFile);
        BufferedReader inFinish = null;
        try{
            inFinish = new BufferedReader(new FileReader(finishFileF));
            String line;
            while((line = inFinish.readLine()) != null){ //101 10:02:00:000
                String[] parts = line.split("[ ]+");
                Runner r = findRunner(Integer.parseInt(parts[0]));
                r.setFinishTime(parts[1]);
            }
        }finally{
            if(inFinish != null) inFinish.close();
        }
    }

    private Runner findRunner(int parseInt) {
        
    }
    
    @Override
    public String toString() {
        return runners.toString();
    }
    
    public static void main(String[] args){
        Competition c = new Competition();
        try {
            c.load("start.txt", "finish.txt");
            System.out.println(c);
        } 
        catch (FileNotFoundException ex) {
            System.out.println("Soubor nenalezen.");
        }
       // System.out.println(c.getResults);
    }

}
