package main;

import java.util.ArrayList;
import java.util.Objects;

public class Task2 {

    private ArrayList<String> cities; 
    private Integer[][] weights;
    private int limit;


    public Task2(int amount){
        limit = amount;
        cities = new ArrayList<>();
        weights = new Integer[limit][limit];
    }
    public void addCity(String name){
        if (!cities.contains(name) && cities.size() < limit){
            cities.add(name);
        }
    }
    public void setWeight(String from, String to, int value){
        if (cities.contains(from) && cities.contains(to)){
            weights[cities.indexOf(from)][cities.indexOf(to)] = value;
        }
    }
    /**
     * Method implements Dijkstra's algorithm
     * that finds minimal transition costs for every vertice
     * from the given one
     * @return desired transition cost
     */
    public int findMin(String from, String to){
        //Checking whether the graph is full
        if (cities.contains(from) && cities.contains(to) && cities.size() == limit){

            boolean[] visited = new boolean[limit];
            Integer[] marks = new Integer[limit];
            //Initialization
            for (int i = 0; i < limit; i++){
                if (i == cities.indexOf(from)){
                    marks[i] = 0;
                }else{
                    marks[i] = null;
                }
                visited[i] = false;
            }
            do{
                
                int cur = minMark(marks, visited);

                //Resolving new marks
                for (int i = 0; i < limit; i++){
                    if (visited[i] || i == cur){
                        continue;
                    }
                    if (!Objects.isNull(weights[cur][i]) && (Objects.isNull(marks[i]) || marks[i] > marks[cur] + weights[cur][i])){
                        marks[i] = marks[cur] + weights[cur][i];
                    }
                }
                visited[cur] = true;

                /*for (int i = 0; i < limit; i++){
                    if (!Objects.isNull(marks[i])){
                        System.out.print(marks[i] + "(" + visited[i] +  ")" + " ");
                    }else{
                        System.out.print("*" + "(" + visited[i] +  ")" + " ");
                    }
                }
                System.out.println();*/

            }while (!isEnd(visited));
            return marks[cities.indexOf(to)];
        }
        return -1;
    }
    /**
     * Method finds minimal mark amongst unvisited vertices
     * (null considered as infinity)
     * @return
     */
    private int minMark(Integer[] marks, boolean[] visited){

        int min = 0;

        for (int i = 0; i < limit; i++){
            if (!visited[i] && !Objects.isNull(marks[i]) && (visited[min] || Objects.isNull(marks[min]) || marks[i] < marks[min])){
                min = i;
            }
        }
        return min;
    }
    //Algorithm terminates when all the vertices are visited
    private boolean isEnd(boolean[] visited){

        boolean end = true;

        for (int i = 0; i < limit; i++){
            end = end && visited[i];
        }
        return end;
    }
}
