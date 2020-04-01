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
public class MainStaticArray {
    static Point[] a = new Point[4];
    
    public static void main(String[] args){
        a[0] = new Point(3, 4);
        a[0] = new Point(6, 4);
        a[0] = new Point(6, 0);
        a[0] = new Point(3, 0);
    }
    
    //dam ho bez parametra, protoze je to frajer a pracuje rovnou nad a
    //to vedlo k vytvoreni noveho datoveho typu
    public static float perimeter(){
    //public static float perimeter(Point[] a){
        //a[0] a[1] a[2] a[3] a[0]
        float perim = 0;
        for(int i = 0; i < a.length - 1; i++){
            perim += a[i].distanceTo(a[i+1]); //a[i] ukazuje na nejaky bod
        }
        perim += a[3].distanceTo(a[0]);
        return perim;
    }
}
