package safarik_hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class HurricanesData {
    private ArrayList<Hurricane> hurricaneData = new ArrayList<>();
    
    /**
     * Loads data from a text file into ArrayList
     * @param dataPath
     * @throws FileNotFoundException 
     */
    public void load(String dataPath) throws FileNotFoundException{
        //Load with Scanner
        File dataFile = new File(dataPath);
        Scanner inData = new Scanner(dataFile);
        while(inData.hasNext()){
            int year = inData.nextInt();
            String month = inData.next();
            int pressure = inData.nextInt();
            int knots = inData.nextInt();
            String name = inData.next();
            Hurricane h = new Hurricane(year, month, pressure, knots, name);
            hurricaneData.add(h);
        }
    }
    
    /**
     * Finds all hurricanes through given years and gives all info about them
     * @param yearMin
     * @param yearMax
     * @return String with Hurricane information
     */
    public String getInfoThgroughYears(int yearMin, int yearMax){
        StringBuilder sb = new StringBuilder();
        for(Hurricane h : hurricaneData){
            int hYear = h.getYear();
            if(yearMin <= hYear && hYear <= yearMax){
                sb.append(h.toString()).append("\n");
            }
        }
        return sb.toString();
    }
    
    /**
     * Gets category and speed info about a hurricane
     * @param name
     * @return String with category and speed of hurricane with input name
     */
    public String getCategoryAndSpeedByName(String name){
        StringBuilder sb = new StringBuilder();
        Hurricane h = findHurricaneByName(name);
        sb.append(h.getCategory()).append(" ").append(h.getSpeed());
        return sb.toString();
    }
    
    /**
     * Finds a hurricane by input name
     * @param name
     * @return Hurricane object
     */
    private Hurricane findHurricaneByName(String name){
        for(Hurricane h : hurricaneData){
            if(h.getName().equals(name)){
                return h;
            }
        }
        return null;
    }
    
    /**
     * Makes a string of sorted ArrayList<Hurricane>
     * @return String with sorted hurricane data
     */
    public String getDataSortedBySpeed(){
        ArrayList<Hurricane> tempHurricanes = sortBySpeed(hurricaneData);
        StringBuilder sb = new StringBuilder();
        for(Hurricane h : tempHurricanes){
            sb.append(h.toString()).append("\n");
        }
        return sb.toString();
    }
    
    /**
     * Takes an ArrayList<Hurricane>, copies it and sorts the copy
     * @param hurricanes
     * @return a sorted copy of ArrayList<Hurricane>
     */
    private static ArrayList<Hurricane> sortBySpeed(ArrayList<Hurricane> hurricanes){
        ArrayList<Hurricane> newHurricanes = hurricanes;
        ComparatorBySpeed c = new ComparatorBySpeed();
        Collections.sort(hurricanes, c);
        return newHurricanes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Hurricane h : hurricaneData){
            sb.append(h.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
        HurricanesData h = new HurricanesData();
        try{
            h.load("hurricanedata.txt");
            //System.out.println(h.getInfoThgroughYears(1999, 2003));
            System.out.println(h.getCategoryAndSpeedByName("Rina"));
            System.out.println(h);
            System.out.println(h.getDataSortedBySpeed());
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
    
}
