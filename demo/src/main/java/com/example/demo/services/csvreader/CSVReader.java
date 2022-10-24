package com.example.demo.services.csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {
    public static void main (String [] args) throws IOException {
        String file = "/home/nick/workspaces/techno-brain-interview/demo/src/main/java/com/example/demo/services/csvreader/log.csv";
        String line;
        List<String> ipAddresses = new ArrayList<> ();
        BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) );
        while ( (line =bufferedReader.readLine ()) != null){
            String[] cols = line.split ( "," );
            String ipAddress =  cols[2] ;
            ipAddresses.add ( ipAddress );
        }


        List<String> tenIpsWithMostAccess = findTheTenIpsWithMostAccess(ipAddresses);

        System.out.println (tenIpsWithMostAccess);
    }

    private static List<String> findTheTenIpsWithMostAccess ( List<String> ipAddresses ) {
       Map<String, Integer> elementCount = new HashMap<> ();
       for(String ipAddress : ipAddresses){
           if(elementCount.containsKey ( ipAddress )){
               int count = elementCount.get ( ipAddress ) + 1;
               elementCount.put ( ipAddress, count );
           }else{
               elementCount.put ( ipAddress, 1 );
           }
       }

       return findFirstTenElements(elementCount);

    }

    private static List<String> findFirstTenElements ( Map<String, Integer> elementCount ) {

        List<String> keys = elementCount.entrySet().stream()
                .map(Map.Entry::getKey)
                .sorted()
                .limit(10)
                .collect(Collectors.toList());

        return keys;
    }

}
