/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfdrivingcar;

import static java.lang.Math.abs;

/**
 *
 * @author Abdelkader
 */
public class Ride implements Comparable<Ride>{
    int id;
    int[]  begin ;
    int[] end ;
    int earliet;
    int latest;
    int length;

    public Ride(int id, int[] be, int[] en, int earl, int late) {
        this.id = id;
        this.begin = be;
        this.end = en;
        this.earliet = earl;
        this.latest = late;
        length=distance(end[0], end[1]);
    }
    public Ride(){
        
    }
    @Override
    public int compareTo(Ride o)
    {
        
         return(this.distance(0,0)- o.distance(0,0));
    }
    
    public int distance (int x,int y){
             
       return abs(begin[0]-x)+abs(begin[1]-y);
    }

}   

