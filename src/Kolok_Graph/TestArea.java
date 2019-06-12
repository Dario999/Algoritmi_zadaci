/*
package Kolok_Graph;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class TestArea {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        EdgeWeightedDigraph G = new EdgeWeightedDigraph(6);

        HashMap<String, Integer> cityIndexPairs = new HashMap<>();
        int individualCities = 0;

        HashMap<Integer, String> reverseHash = new HashMap<>();

        int E = reader.nextInt();
        for(int i = 0; i < E; ++i){

            String sourceCity = reader.next();
            String destCity = reader.next();
            double weight = reader.nextDouble();

            int sourceCityID = -1;
            int destCityID = -1;

            if(cityIndexPairs.containsKey(sourceCity)){

                sourceCityID = cityIndexPairs.get(sourceCity);
            } else {

                cityIndexPairs.put(sourceCity, individualCities);
                reverseHash.put(individualCities, sourceCity);
                sourceCityID = individualCities;
                individualCities++;
            }

            if(cityIndexPairs.containsKey(destCity)){

                destCityID = cityIndexPairs.get(destCity);
            } else {

                cityIndexPairs.put(destCity, individualCities);
                reverseHash.put(individualCities, destCity);
                destCityID = individualCities;
                individualCities++;
            }

            G.addEdge(new DirectedEdge(sourceCityID, destCityID, weight));
        }

        DijkstraSP solution = new DijkstraSP(G, 0);

        for(DirectedEdge e : solution.pathTo(3)){


            System.out.println( reverseHash.get(e.from()) + " " + reverseHash.get(e.to()));
        }


        String policeCity = reader.next();

        G.addStanica(cityIndexPairs.get(policeCity));


    }
}*/
