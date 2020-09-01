package lab.assignment.pkg1.cse221;

import java.io.*;
import java.util.*;

public class Level4 {
    public static void main(String[] args) throws Exception{
        
            File f=new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Lab Assignment 1 (CSE221)\\Input 4.txt");
            FileReader fr= new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String st = br.readLine();
            int vertices= Integer.parseInt(st);
            st = br.readLine();
            int edges=Integer.parseInt(st);
            
            ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
            
            for(int i=0; i<vertices; ++i){
               ArrayList<Integer> bList = new ArrayList<Integer>();
               list.add(bList);
               for(int j=0; j<vertices; ++j)
                   list.get(i).add(0);
            }
            
            String []sArray= new String[2];
            for(int i=0; i<edges; i++){
                
                st=br.readLine();
                sArray =st.split(" ");
                int vertex= Integer.parseInt(sArray[0]);
                int connect= Integer.parseInt(sArray[1]);
                list.get(vertex).add(connect, 1);
            }
                     
            int [] indegree= new int[vertices];
            
            for (int i = 0; i <vertices ; i++) {
                for (int j = 0; j < vertices; j++) {
                    if ((list.get(i).get(j)).equals(1))
                        indegree[j]++;
                }
            }
            int position = 0;
            int min = indegree[0];

            for (int i = 0; i < vertices; i++) {
                if (indegree[i] < min) {
                    min = indegree[i];
                    position = i;
                }
            }
            System.out.println(position);
            

            
    }
}
