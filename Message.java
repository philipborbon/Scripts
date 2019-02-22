/*
 * Copyright (C) 2013 Philip John Ladua Borbon
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

/**
 *
 * @author  Philip John Ladua Borbon
 */
public class Message {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println("");
            printFirstPhase();   
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("");
            printSecondPhase();
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("");
            printThirdPhase();
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("");
            printFourthPhase();
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("");
            printFifthPhase();
        }
        System.out.println("");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Print Phases">
    /**
     * print the First Phase of the text
     */    
    public static void printFirstPhase(){
        printDot(15);
        printBlank(10);
        printDot(5);
        printBlank(15);
        printDot(15);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(15);
        printBlank(10);
        printDot(5);
        printBlank(5);        
        printDot(5);
        printBlank(5);
        printDot(15);
        printBlank(5);
        printDot(5);    
        printBlank(5);
        printDot(5);
    }

    /**
     * print the Second Phase of the text
     */        
    public static void printSecondPhase(){
        printBlank(5);
        printDot(5);
        printBlank(15);
        printDot(5);
        printBlank(15);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(20);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
    }

    /**
     * print the Third Phase of the text
     */        
    public static void printThirdPhase(){
        printBlank(5);
        printDot(5);
        printBlank(15);
        printDot(5);
        printBlank(15);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(10);
        printBlank(15);
        printDot(15);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
    }

    /**
     * print the Fourth Phase of the text
     */        
    public static void printFourthPhase(){
        printBlank(5);
        printDot(5);
        printBlank(15);
        printDot(5);
        printBlank(15);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(25);
        printDot(5);
        printBlank(10);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
        printBlank(5);
        printDot(5);
    }

    /**
     * print the Fifth Phase of the text
     */    
    public static void printFifthPhase(){
        printDot(15);
        printBlank(10);
        printDot(15);
        printBlank(5);
        printDot(15);
        printBlank(10);
        printDot(5);
        printBlank(10);
        printDot(15);
        printBlank(15);
        printDot(5);
        printBlank(10);
        printDot(15);
        printBlank(5);
        printDot(15);
    }

    /**
     * Print dots
     * @param num the number of dots to print
     */        
    public static void printDot(int num){
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
    }

    /**
     * Print white spaces
     * @param num the number of white space to print
     */    
    public static void printBlank(int num){
        for (int i = 0; i < num; i++) {
            System.out.print(" ");
        }
    }
    // </editor-fold>
}
