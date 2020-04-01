/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg2_03_PointClass;

import java.util.ArrayList;
import java.util.Arrays;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author David Šafařík
 */
public class NShape {
    //date
    private ArrayList<Point> points = new ArrayList();
    
    //constructors
    //default empty constructor
    
    public NShape(){
        
    }
    
    /**
     * Přidá pole bodů
     * @param points 
     */
    public NShape(Point[] points){
        this.points.addAll(Arrays.asList(points));
    }
    
    /**
     * idealne ulozit kopii
     * @param points 
     */
    public NShape(ArrayList<Point> points){
        ArrayList<Point> pointsNew = (ArrayList<Point>)points.clone();
        this.points.addAll(pointsNew);
    }
    
    /**
     * prida bod, ale musim mu dat hotovej Point
     * @param p 
     */
    public void add(Point p){
        points.add(p);
    }
    
    /**
     * Vyzuzije constructor Pointu a udela si novej z parametru
     * @param x
     * @param y 
     */
    public void add(float x, float y){
        points.add(new Point(x, y));
    }
    
    //TODO
    /**
     * počítá obvod
     * @return float
     */
    public float perim(){
        float perim = 0;
        for(int i = 0; i < points.size() - 1; i++){
            perim += Point.distanceBetween(points.get(i), points.get(i+1));
        }
        perim += Point.distanceBetween(points.get(points.size()-1), points.get(0));
        return perim;
    }
    
    /**
     * počítá obsah
     * @return float
     */
    public float area(){
        float area = 0;
        for(int i = 0; i < points.size() - 1; i++){
            area += points.get(i).getX()*points.get(i+1).getY() - points.get(i+1).getX()*points.get(i).getY();
        }
        area += points.get(points.size()-1).getX()*points.get(0).getY() - points.get(0).getX()*points.get(points.size()-1).getY();
        return area;
    }
    
    /**
     * hledá bod nejbližší počátku
     * @return Point class
     */
    public Point nearestOrigin(){
        float distanceShortest = Float.MAX_VALUE;
        Point nearP = new Point(0,0);
        for(Point p : points){
            if(p.getDistance() < distanceShortest){
                distanceShortest = p.getDistance();
                nearP = p;
            }
        }
        return nearP;
    }
    
    /**
     * hledá bod nejdále od počátku
     * @return Point class
     */
    public Point farthestOrigin(){
        float distanceLongest = 0;
        Point farP = new Point(0,0);
        for(Point p : points){
            if(p.getDistance() > distanceLongest){
                distanceLongest = p.getDistance();
                farP = p;
            }
        }
        return farP;
    }
    
    /**
     * dva nejbližší body
     * @return Point class array
     */
    public Point[] nearestPoints(){
        float distance = Float.MAX_VALUE;
        Point[] resultP = {new Point(0,0), new Point(0,0)};
        for(int i = 0; i < points.size() -1 ; i++){
            for(int j = i + 1; j < points.size(); j++){
                float temp = Point.distanceBetween(points.get(i), points.get(j));
                if(temp < distance){
                    distance = temp;
                    resultP[0] = points.get(i);
                    resultP[1] = points.get(j);
                }
            }
        }
        return resultP;
    }
    
    /**
     * dva nejvzdálenější body
     * @return Point class array
     */
    public Point[] farthestPoints(){
        float distance = 0;
        Point[] resultP = {new Point(0,0), new Point(0,0)};
        for(int i = 0; i < points.size() -1 ; i++){
            for(int j = i + 1; j < points.size(); j++){
                float temp = Point.distanceBetween(points.get(i), points.get(j));
                if(temp > distance){
                    distance = temp;
                    resultP[0] = points.get(i);
                    resultP[1] = points.get(j);
                }
            }
        }
        return resultP;
    }

    @Override
    public String toString() {
        String result = "\n";
        for(Point p : points){
            result += p.toString() + "\n";
        }
        return result;
    }

    
    
}