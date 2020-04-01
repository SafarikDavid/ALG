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
public class ArrayOfPoints {
    public static void main(String[] args){
        Point A = new Point(0,4);
        Point B = new Point(4,5);
        System.out.println(A.distance());
        System.out.println(B.distance());
        System.out.println(A.distanceTo(B));
        System.out.println(Point.distanceBetween(A, B));
    }
}
