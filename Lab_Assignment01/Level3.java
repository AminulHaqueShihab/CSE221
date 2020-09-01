
package lab.assignment.pkg1.cse221;

import java.util.*;
import java.io.*;

public class Level3 {
    public static int target;
    public static void main(String[] args) throws Exception{
        
            File f=new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Lab Assignment 1 (CSE221)\\Input 3.txt");
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
            }
            
            
            for(int i=0; i<edges; i++){
                String []sArray= new String[2];
                st=br.readLine();
                sArray =st.split(" ");
                int vertex= Integer.parseInt(sArray[0]);
                int connect= Integer.parseInt(sArray[1]);
                list.get(vertex).add(connect);
            }
            
            st=br.readLine();
            target=Integer.parseInt(st);
            st=br.readLine();
            int participants=Integer.parseInt(st);
            int []k =new int[5];
            for(int i=0; i<participants; i++){
                st=br.readLine();
                k[i]=Integer.parseInt(st);
                k[i]= BFS(list, k[i], vertices, target);
            }
            
            Arrays.sort(k);
            System.out.println(k[0]);
            
    }
    

    public static int BFS(ArrayList<ArrayList<Integer>> list, int s, int v, int target) {

        String[] color = new String[v];
        int[] distance = new int[v];
        int[] parent = new int[v];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            color[i] = "white";
            distance[i] = 999999999;
            parent[i] = -1;
        }

        color[s] = "grey";
        distance[s] = 0;
        parent[s] = -1;

        que.add(s);
        while (!que.isEmpty()) {

            int u = que.remove();

            for (int j = 0; j < list.get(u).size(); j++) {

                if ( color[list.get(u).get(j)].equals("white")) {
                    color[list.get(u).get(j)] = "grey";
                    distance[list.get(u).get(j)] = distance[u] + 1;
                    parent[list.get(u).get(j)] = u;
                    que.add(list.get(u).get(j));
                    
                    if (list.get(u).get(j) == target) 
                        break;
                }
            }
            color[u] = "black";
        }
        return distance[target];
        
    }
}
