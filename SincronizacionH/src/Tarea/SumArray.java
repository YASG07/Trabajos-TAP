/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class SumArray {
    private int sum;
    
    synchronized int SumArray(int nums []){
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += sum;
            System.out.println("Total acumulado de "+Thread.currentThread().getName()+" es "+ sum);
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido");
        }
        }//for
        return sum;
    }//SumArray
}//clase sumArray

class MiHilo implements Runnable{
    Thread hilo;
    static SumArray sumarray = new SumArray();
    int a[];
    int resp;
    
    MiHilo(String Nombre, int nums[]){
        hilo = new Thread(this, Nombre);
        a = nums;
    }//MiHilo
    
    public static MiHilo creaEInicia (String Nombre, int nums[]){
        MiHilo miHilo = new MiHilo(Nombre, nums);
        miHilo.hilo.start();
        return miHilo;
    }//crea e inicia
    
    @Override
    public void run() {
        int sum;
        System.out.println(hilo.getName()+ "iniciando...");
        resp = sumarray.SumArray(a);
        System.out.println("Suma para "+hilo.getName()+" es "+resp);
        System.out.println(hilo.getName()+" terminado");
    }//metodo run
    
}//clase MiHilo

class Sincronizacion{
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        MiHilo mh1 = MiHilo.creaEInicia("#1", a);
        MiHilo mh2 = MiHilo.creaEInicia("#2", a);
        
        try {
            mh1.hilo.join();
            mh2.hilo.join();
        } catch (InterruptedException ex) {
            System.out.println("Hilo principal interrumpido");
        }
    }//main
    
}//clase Sincronizacion