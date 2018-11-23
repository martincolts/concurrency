package com.resources;

import com.threads.Dwarf;

import java.util.concurrent.Semaphore;

public class Resources {

    private boolean snowWhiteIstaken = false ;
    private Dwarf dwarf = null;
    private static Resources instance = new Resources();

    public static Semaphore semaphoreDwarf = new Semaphore(1);
    public static Semaphore semaphoreSW = new Semaphore(1);

    private Resources(){}

    public synchronized static Resources getInstance(){
        return instance;
    }

    public void takeSnowWhite(Dwarf dwarf) throws InterruptedException {
        synchronized (this){
            System.out.println(dwarf.getName() + " is taking SW");
            snowWhiteIstaken = true;
            this.dwarf = dwarf;
        }
    }

    public void freeSnowWhite(){
        synchronized(this) {
            System.out.println(dwarf.getName() + " is freeing SW");
            snowWhiteIstaken = false;
            this.dwarf = null;
        }
    }

    public synchronized void serveFood(){
        System.out.println("Snow White is serving food to "+ dwarf.getName());
    }

    public synchronized boolean isSnowWhiteIstaken(){
        return this.snowWhiteIstaken;
    }
}
