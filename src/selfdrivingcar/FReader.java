/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfdrivingcar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import javafx.collections.transformation.SortedList;

/**
 *
 * @author Abdelkader
 */
public class FReader {
    public int rows;
    public int colums;
    int num_vehicules;
    int num_rides;
    int bonus;
    int steps;
    
    
    public void FileReader (){
        
    }
    
    public ArrayList <Ride> read() throws IOException{
        // TODO code application logic here
        int [] x ;      
  //      SortedSet <Ride> Rides = new SortedSet()<Ride>;
   //     Map<Integer, Ride> map = new TreeMap<Integer, Ride>();
        ArrayList <Ride> Rides = new ArrayList<Ride>();
        
       
        try {
            int i=0;
            BufferedReader in = new BufferedReader(new java.io.FileReader(new File("file.txt")));
            String line;
            line=in.readLine();
            String[] data = line.split(" ");
            rows = Integer.parseInt(data[0]);
            colums = Integer.parseInt(data[1]);
            num_vehicules = Integer.parseInt(data[2]);
            num_rides = Integer.parseInt(data[3]);
            bonus = Integer.parseInt(data[4]);
            steps = Integer.parseInt(data[5]);
            line=in.readLine();
             int distance;
            while(line != null){
                
                data = line.split(" ");
                int[] h1={0,0};
                int[] h2={0,0};
                h1[0] = Integer.parseInt(data[0]); h1[1]=Integer.parseInt(data[1]); 
                h2[0] = Integer.parseInt(data[2]); h2[1]=Integer.parseInt(data[3]);
                distance = abs(h1[0]-0)+abs(h1[1]-0) ; 
                Ride ride = new Ride(i,h1, h2, Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                Rides.add(ride);
                 
              
                //map.put(distance, ride);
                 //Rides.add(ride);
                line=in.readLine();
                i++;
                
            }
           
            Collections.sort(Rides, new Comparator<Ride>() {
            @Override
            public int compare(Ride ride1 , Ride ride2)
             {
                 //System.out.println("Ride"+ride1.id+" and "+ ride2.id +" ");
                 return (ride2.length - ride1.length);
              }
            });
           /* System.out.println("/n-----------------------------");
           for (Ride e : Rides){
                System.out.println(e.begin[0]+" "+e.begin[1]+" "+e.end[0]+" "+e.end[1]+" "+e.earliet+" "+e.latest);
                
            }*/
            //Collections.sort(Rides);
          /*  for (Ride e:Rides){
                System.out.println(e.id);
            }*/
           
            
        }
        catch (FileNotFoundException e) {
            
        } 
        return Rides;
    }
    
    public void write(int car , Collection<Ride> e) throws FileNotFoundException{
        try{ 
            BufferedWriter out = new BufferedWriter(new FileWriter(new File("output.txt")));
            String Line = "";
            Line += Integer.toString(car);
            for (Ride r : e){
                Line+= "/t"+Integer.toString(r.id);             
            }
            out.write(Line);       
        }
        catch(Exception ex){
            
        }
    }





}

    

