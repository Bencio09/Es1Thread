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
public class ThreadUnsafeCounter {
    int contatore = 0;
    
    
    public synchronized void incrementatore(){
        contatore++;
    }
    
    public synchronized void decrementatore(){
        contatore--;
    }
    
    public void stampaValore(){
        System.out.println("Il contatore vale: " + contatore);
    }
}
