/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfdrivingcar;

import java.awt.Choice;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Abdelkader
 */
public class SelfDrivingCar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        FReader file = new FReader(); 
        ArrayList <Ride> Rides = file.read();
       // Choose(Rides, file.steps , file.num_vehicules , 1);
       
       String Line="";
       int taux =1;
        int step=0;
        int veh=1;
        int x=0 ; int y=0;
        boolean possible=true;
        try{
          File fil = new File("output.txt");
          PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter(fil)));
        

        
        
        while (possible){
            
        if (veh<= file.num_vehicules){
            Iterator it = Rides.iterator();
           // System.out.println(Line);
           int j=0;
            while((it.hasNext())&&(step < file.steps)){
                Ride r = (Ride) it.next();
                //System.out.println("Ride"+r.id+" Distance+length= "+r.distance(x, y)+" "+r.length+" late= "+r.latest*taux);
                if ((r.distance(x, y)+r.length) < (r.latest*taux)){
                    Line += " "+Integer.toString(r.id);
                    step +=  r.distance(x, y);
                    if (step < r.earliet){
                        step = r.earliet;
                    }
                    step += r.length;
                    x= r.end[0]; y = r.end[1];
                    it.remove();
                    j++;
                    
                }
                //Step ends 
                
            }
            // write in file
            out.println(Line);
            System.out.println(j+" "+Line);
            Line="";    
         }
        else possible=false;
       
        veh++;
        step = 0;
        
        //end while
          }
        }
        catch (Exception e){
            
        }
        
        
        
    
    }
        
        
    }
  
        
 