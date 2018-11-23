package com.threads;

import com.resources.Resources;


public class SnowWhite implements Runnable {


    Resources resources = Resources.getInstance();

    public void run() {
        try {
            while (true) {
                if (resources.isSnowWhiteIstaken()) {
                    resources.serveFood();
                    Thread.sleep(500);
                    resources.freeSnowWhite();
                    resources.semaphoreDwarf.release();
                }
                else{
                    System.out.println("Snow white is fucking with the Prince");
                    Thread.sleep(500);
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
