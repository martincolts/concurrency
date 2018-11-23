package com;

import com.threads.Dwarf;
import com.threads.SnowWhite;

public class Main {

    public static void main (String[] args){
        System.out.println ("Hello World");

        Runnable dwarf1 = new Dwarf();
        ((Dwarf) dwarf1).setName("1");
        Thread threadD1 = new Thread(dwarf1);

        Runnable dwarf2 = new Dwarf();
        ((Dwarf) dwarf2).setName("2");
        Thread threadD2 = new Thread(dwarf2);

        Runnable snowWhite = new SnowWhite();
        Thread threadSW = new Thread(snowWhite);

        threadD1.start();
        threadD2.start();
        threadSW.start();
    }

}
