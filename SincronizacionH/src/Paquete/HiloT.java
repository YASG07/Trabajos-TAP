/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;


/**
 *
 * @author Lenovo
 */
public class HiloT extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.print("T");
            try {
            sleep(1000);
            } catch (InterruptedException ex) {
            System.out.print("Error alcanzado en hilo T");
            }
        }//for

    }//metodo run
    
}//clase HiloT
