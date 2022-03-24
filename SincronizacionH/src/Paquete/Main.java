/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author Lenovo
 */
public class Main {
    
    public static void main(String[] args) {
        HiloT ht = new HiloT();
        HiloA ha = new HiloA();
        HiloP hp = new HiloP();
        ht.start();
        try {
            ht.sleep(10);
        } catch (InterruptedException ex) {
            System.out.print("Error alcanzado");
        }
        ha.start();
        try {
            ha.sleep(10);
        } catch (InterruptedException ex) {
            System.out.print("Error alcanzado");
        }
        hp.start();
        try {
            hp.sleep(10);
        } catch (InterruptedException ex) {
            System.out.print("Error alcanzado");
        }
    }//main
    
}//Clase Main

