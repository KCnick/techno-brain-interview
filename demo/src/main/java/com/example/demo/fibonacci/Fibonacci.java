package com.example.demo.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        List<Integer> fibonacciNumbers = generateFibonacci();
        System.out.print(fibonacciNumbers);

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter fibonacci position ");
        int a= sc.nextInt();

        int fibonacciNumber = fibonacciNumbers.get ( a );
        System.out.println (fibonacciNumber);
    }

    private static List<Integer> generateFibonacci ( ) {
        int firstTerm = 0;
        int secondTerm = 1;
        int limit = 100; //Limit our fibonacciSeries to 20 items
        List<Integer> fibonacciSeries = new ArrayList<> ();
        fibonacciSeries.add ( firstTerm );
        fibonacciSeries.add ( secondTerm );
        for(int i=1; i <= limit; i++){
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
            fibonacciSeries.add ( nextTerm );

        }

        return fibonacciSeries;
    }
}
