package hashing;

import java.util.HashMap;
import java.util.Map;

public class ReconstructItinerary {
/**
 *
 1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
 2. You have to find the itinerary in order using the given list of tickets.

 Assumption - The input list of tickets is not cyclic and there is one ticket from every city except the final destination.
 Ex: 4
 Chennai Bangalore
 Bombay Delhi
 Goa Chennai
 Delhi Goa

 Output:
 Bombay -> Delhi -> Goa -> Chennai -> Bangalore
 * */
    public static void main(String[] args) {

        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bangalore");
        tickets.put("Bombay", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        constructItinerary(tickets);
    }

    private static void constructItinerary(HashMap<String, String> tickets) {

        HashMap<String, Boolean> srcDestMap = new HashMap<>();
        //put all the cities to true
        for(String city: tickets.keySet()){
            srcDestMap.put(city, true);
        }
        for(String city: tickets.keySet()){
            srcDestMap.put(tickets.get(city),false);
        }
        //Now, only the src city is true and rest all the cities are false. Start with the source city
        //Get the source city
        String src = " ";
        for(String city: srcDestMap.keySet()){
            if(srcDestMap.get(city)){
                src = city;
                break;
            }
        }

        System.out.print(src + " ");
        getRoute(src, tickets);
    }

    private static void getRoute(String src, HashMap<String, String> tickets) {

        if(!tickets.containsKey(src)){
            System.out.print(".");
            return;
        }
        System.out.print( " -> " + tickets.get(src));
        getRoute(tickets.get(src),tickets);
    }
}
