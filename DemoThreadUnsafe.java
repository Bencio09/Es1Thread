/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.es1threads;

/**
 *
 * @author loreb
 */
public class DemoThreadUnsafe {
    
    public static void main(String[] args) throws InterruptedException{
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();
        
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        System.err.println(ex);
                    }
                    badCounter.incrementatore();
                }
            }
        });
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        System.err.println(ex);
                    }
                    badCounter.decrementatore();
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        badCounter.stampaValore();
    }
}
