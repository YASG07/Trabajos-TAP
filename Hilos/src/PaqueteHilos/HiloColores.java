/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteHilos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
//import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author yael_
 */
public class HiloColores {
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setSize(680, 400);
        v.setLocationRelativeTo(null);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        v.setTitle("Juego de Pelota");
        v.setVisible(true);
    }//main
}//clase HiloUnico (Principal)

class Ventana extends JFrame {//implements Runnable{
    private JPanel pnlBotones;
    private JButton btnIniciar, btnDetener;
    private PjPanel pnlArea;
    //private Thread hilo;

    public Ventana() {
        setLayout(new BorderLayout());
        setResizable(false);
        //hilo = new Thread(this);
        pnlArea = new PjPanel();
        pnlBotones = new JPanel();
        btnIniciar = new JButton("Iniciar");
        btnDetener = new JButton("Detener");
        //inicializacion de los componentes
        pnlArea.setBackground(Color.black);
        pnlArea.setVisible(true);
        add(pnlArea, BorderLayout.CENTER);
        //definicion de caracteristicas y agregado a la ventana
        pnlBotones.setBackground(Color.white);
        pnlBotones.setVisible(true);
        pnlBotones.setLayout(new FlowLayout());
        add(pnlBotones, BorderLayout.SOUTH);
        //definicion de caracteristicas y agregado a la ventana
        btnIniciar.setHorizontalTextPosition(SwingConstants.CENTER);
        pnlBotones.add(btnIniciar);
        //definicion de caracteristicas y agregado al panel
        btnDetener.setHorizontalTextPosition(SwingConstants.CENTER);
        pnlBotones.add(btnDetener);
        //definicion de caracteristicas y agregado al panel
        btnIniciar.addActionListener((java.awt.event.ActionEvent e) -> {
            /*if(hilo.isAlive()){
                hilo.resume();
                return;
            }
            hilo.start();
            btnIniciar.setText("Reanudar");*/
            MoverCirculo();
        });//Evento ActionPerformed
        btnDetener.addActionListener((java.awt.event.ActionEvent e) -> {
            //hilo.suspend();
        });//Evento ActionPerformed
    }//constructor

    public void MoverCirculo(){
        try {    
            for(int i = 0; i < 1000; i++){
                pnlArea.paintComponents(pnlArea.getGraphics());
                Thread.sleep(10);
            }//for
        } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//MoverCirculo
    /*@Override
    public void run() {
        MoverCirculo();
    }//run*/
    
}//clase ventana

class Pelota {
    private int x, y, dx, dy, radio;
    private Color colur;

    public Pelota() {//x = 100;y = 100;dx = 1;dy = 1;radio = 25;
        x = (int) (Math.random()*100);
        y = (int)(Math.random()*100);
        if(x < 50)
            dx = -1;
        else
            dx = 1;
        if(y < 50)
            dy = -1;
        else 
            dy = 1;
        radio = (int) (Math.random()*100);
        colur = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    }//constructor
    
    public void dibujar(Graphics g){
        g.setColor(colur);
        g.fillOval(x, y, radio, radio);
    }//dibujar
    
    public void Mover(PjPanel area){
        x += dx;
        y += dy;
        if(x < 0){
            x = 0;
            dx = -1 * dx;
        }//if rebote horizontal
        if(y < 0){
            y = 0;
            dy = -1 * dy;
        }//if rebote vertical
        if(x > area.getWidth()){
            x = area.getWidth();
            dx = -1 * dx;
        }//if
        if(y > area.getHeight()){
            y = area.getHeight();
            dy = -1 * dy;
        }//if
        //System.out.println("X="+dx+"\nY="+dy);
    }//MOver

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Color getColur() {
        return colur;
    }

    public void setColur(Color colur) {
        this.colur = colur;
    }
    
}//clase pelota

class PjPanel extends JPanel{
   //Pelota p = new Pelota();
    private Pelota p[];

    public PjPanel() {
        p = new Pelota[5];
        for(int i = 0; i < 5; i++)
            p[i] = new Pelota();
    }//Constructor
    
   public void paintComponents(Graphics g){
        super.paintComponents(g);
        for(Pelota c:p){
        c.Mover(this);
        c.dibujar(g);
        }//for
    }//metodo paint
}//Clase pelota
