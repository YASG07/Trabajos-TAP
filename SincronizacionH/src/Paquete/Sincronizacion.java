/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author Lenovo
 */
public class Sincronizacion {
    
    public static void main(String[] args) {
        Letra rt = new Letra();
        Thread T = new Thread(rt, "T"); 
        Thread A = new Thread(rt, "A");
        Thread P = new Thread(rt, "P\n");
        T.start();
        /*try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {}*/
        A.start();
        /*try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {}*/
        P.start();
        /*try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {}*/
    }//main

    
}//clase sincronizacion

class Letra implements Runnable{
    private String L = "T";

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                imprimeL();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Algo salio mal");
            }
        }//for
    }//metodo run
    
    public synchronized void imprimeL(){
        System.out.print(L);
        L = Thread.currentThread().getName();
    }//Imprime Letra
    
}//clase Letra