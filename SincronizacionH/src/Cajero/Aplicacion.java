/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cajero;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Aplicacion {
    public static void main(String[] args) {
        CajeroAutomatico c = new CajeroAutomatico();
        Thread A = new Thread(c, "Yael");
        Thread B = new Thread(c, "Alejandro");
        A.start();
        B.start();
    }//main
    
}//Aplicacion

class CajeroAutomatico implements Runnable{
    CuentaBancaria c = new CuentaBancaria();
    
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                transaccion(20);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.print("Error en el hilo");
            }
        }
    }//run
    
    private synchronized void transaccion(int cant){
        if(c.consulta() <= 0)
            System.out.println("Saldo insuficiente\nSaldo actual: "+c.consulta());
        else{
            if(c.consulta() >= cant){
                System.out.println("Saldo = "+c.consulta());
                c.retiro(cant);
                System.out.println("El usuario "+Thread.currentThread().getName()+" retiró "+ cant);
            }//if
        }//else
    }
}//CajeroAutomatico

class CuentaBancaria {
    private int saldo = 100;

    public int consulta() {
        return saldo;
    }

    public void retiro(int cant) {
        this.saldo = saldo - cant;
    }

}//Cuenta bancaria
