/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg2_03_PointClass;

/**
 *
 * @author David Šafařík
 */
public class Point {
    //data
    
    private float x;
    private float y;
    private float distance;
    
    //konstruktory
    
    public Point(){
        this.x = 0;
        this.y = 0;
    }
    
    public Point(float x, float y){
        this.x = x;
        this.y = y;
        this.distance = this.distance();
    }
    
    //metody
    
    public float getX(){
        return this.x;
    }
    
    public float getY(){
        return this.y;
    }
    
    public float getDistance(){
        return distance;
    }
    
    /**
     * Calculate distance from origin to this point
     * @return distance from origin
     */
    public float distance(){
        return (float) Math.sqrt((x*x)+(y*y));
        //return this.distanceTo(new Point(0,0));
    }
    
    /**
     * Calculates the distance from this point to another
     * @param other the other Point
     * @return distance between them
     */
    public float distanceTo(Point other){
        return (float) Math.sqrt((other.x - this.x)*(other.x - this.x) + (other.y - this.y)*(other.y - this.y));
    }
    
    /**
     * Calculates the distance between two points
     * If I wanted to implement this in a library, then I'd need to use getters
     * @param p1 one Point
     * @param p2 second Point
     * @return return the distance between two points
     */
    public static float distanceBetween(Point p1, Point p2){
        return (float) Math.sqrt(Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y, 2));
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
}
