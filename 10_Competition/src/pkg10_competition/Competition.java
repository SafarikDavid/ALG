package pkg10_competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
            sb.append(String.format("%-2d. %s%n", n, r));
            n++;
        }
        return sb.toString();
    }
    
    public void saveResults(String resultFilePath) throws IOException {
        Collections.sort(runners);
        Writer w;
        if(resultFilePath.endsWith(".txt")){
            w = new TextWriter();
        }else if(resultFilePath.endsWith(".dat")){
            w = new BinaryWriter();
        }else{
            throw new IllegalArgumentException("Nepodporovana koncovka souboru.");
        }
        w.save(resultFilePath, runners);
    }

    public void load(String startFilePath, String finishFilePath) throws FileNotFoundException, IOException {
//        start19.txt start2019v2 Strat19 Start2019 od 2000 2030
//        if(!(startFilePath.matches("^[Ss]tart(20)?([0-2][0-9]|30).*"))){
//            throw new IllegalArgumentException("Nepovoleny nazev souboru.");
//        }
//        if(!(startFilePath.endsWith(".txt") && finishFilePath.endsWith(".txt"))){
//            throw new IllegalArgumentException("Nepovolena koncovka souboru.");
//             throw new IllegalExtensionException("Nepovolena koncovka souboru."); //vlastni vyjimka
//        }
        //nacitani pomoci scanneru
        File startFileF = new File(startFilePath);
        Scanner inStart = new Scanner(startFileF); //vyhazuje cizi vyjimku
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
        File finishFile = new File(finishFilePath);
        BufferedReader inFinish = null;
        try{
            inFinish = new BufferedReader(new FileReader(finishFile));
            String line;
            while((line = inFinish.readLine()) != null){ //101 10:02:00:000
                String[] parts = line.split("[ ]+");
                try{
                    Runner r = findRunner(Integer.parseInt(parts[0]));
                    r.setFinishTime(parts[1]);
                }catch(NoSuchElementException e){
                    System.err.print(e.getMessage()); //neexistujici bezec se preskoci
                }
            }
        }finally{
            if(inFinish != null) inFinish.close();
        }
    }

    private Runner findRunner(int number) {
        for (Runner runner : runners) {
            if(runner.getNumber() == number){
                return runner;
            }
        }
        throw new NoSuchElementException("Bezec s cislem " + number + " nebyl na startu.");
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
