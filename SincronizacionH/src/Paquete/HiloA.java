/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author Lenovo
 */
public class HiloA extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.print("A");
            try {
            sleep(1000);
            } catch (InterruptedException ex) {
            System.out.print("Error alcanzado en Hilo A");
            }
        }//for
        
    }//metodo run
    
}//clase HiloA
