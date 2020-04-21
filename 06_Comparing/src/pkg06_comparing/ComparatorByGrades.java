/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg06_comparing;

import java.util.Comparator;

/**
 *
 * @author David Šafařík
 */
public class ComparatorByGrades implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
//        return o1.compareTo(o2);
        double epsilon = .0001;
        if(Math.abs(o1.getAverageG() - o2.getAverageG()) < epsilon){
            return 0;
        }else if((o1.getAverageG() - o2.getAverageG()) > 0){
            return 1;
        }else{
            return -1;
        }
    }
    
}
