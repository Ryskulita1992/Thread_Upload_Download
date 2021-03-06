package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {
    Semaphore sm;
    CountDownLatch cdl2;
    int id;

    public Downloader(Semaphore sm, CountDownLatch cdl2, int id) {
        this.sm = sm;
        this.id = id;
        this.cdl2 = cdl2;
    }
    @Override
    public void run() {
        try {
            sm.acquire();
        } catch (InterruptedException e) { }
        System.out.print(System.lineSeparator());
        System.out.println("Пользователь № " + id + " начал загрузку ");
        try {
            sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("Пользователь № " + id + "  уже загрузил файл ");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        sm.release();
        cdl2.countDown();
        super.run();
    }
}
