package com.example.demo.reverse;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ReverseString {


    public static void main(String[] args){
        String reversedString = reverseString ( "I love Java" );

        System.out.println (reversedString);
    }

    public static String reverseString ( String s ) {
        Pattern pattern = Pattern.compile ( "\\s" );

        String[] temp =  pattern.split ( s );

        String result = "";

        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }
        return result;
    }

}
