package com.threads;

import com.resources.Resources;

public class Dwarf implements Runnable{

    private String name = "default";

    private Resources resources = Resources.getInstance();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                resources.semaphoreDwarf.acquire();
                resources.takeSnowWhite(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
