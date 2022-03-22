package Paquete;


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
public class HiloMultiple {
    public static void main(String[] args) {
        VentanaHM v = new VentanaHM();
        v.setSize(680, 400);
        v.setLocationRelativeTo(null);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        v.setTitle("Juego de Pelota");
        v.setVisible(true);
    }//main
}//clase HiloUnico (Principal)

class VentanaHM extends JFrame {//implements Runnable{
    private JPanel pnlBotones;
    private JButton btnIniciar, btnDetener;
    private PjPanelHM pnlArea;
    //private Thread hilo;

    public VentanaHM() {
        setLayout(new BorderLayout());
        setResizable(false);
        //hilo = new Thread(this);
        pnlArea = new PjPanelHM();
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
            MoverCirculo();
        });//Evento ActionPerformed
        btnDetener.addActionListener((java.awt.event.ActionEvent e) -> {
            //hilo.suspend();
        });//Evento ActionPerformed
    }//constructor

    public void MoverCirculo(){
        PelotaHM p = new PelotaHM();
        Runnable r = new PelotaRunnable(p, pnlArea);
        Thread t = new Thread(r);
        t.start();
    }//MoverCirculo
    
}//clase ventana

class PelotaHM {
    private int x, y, dx, dy, radio;
    private Color colur;

    public PelotaHM() {
        x = 100;
        y = 100;
        dx = 1;
        dy = 1;
        radio = 25;
        colur = Color.red;
    }//constructor
    
    public void dibujar(Graphics g){
        g.setColor(colur);
        g.fillOval(x, y, radio, radio);
    }//dibujar
    
    public void Mover(PjPanelHM area){
        x += dx;
        y += dy;
        if(x <= 0){
            x = 0;
            dx = -dx;
        }//if rebote horizontal
        if(y <= 0){
            y = 0;
            dy = -dy;
        }//if rebote vertical
        if(x >= area.getWidth()){
            x = area.getWidth();
            dx = -dx;
        }//if
        if(y >= area.getHeight()){
            y = area.getHeight();
            dy = -dy;
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

class PjPanelHM extends JPanel{
   PelotaHM p = new PelotaHM();
   public void paintComponents(Graphics g){
        super.paintComponents(g);
        p.Mover(this);
        p.dibujar(g);
    }//metodo paint
}//Clase pelota

class PelotaRunnable implements Runnable{
    private PelotaHM PHM; 
    private PjPanelHM p;

    public PelotaRunnable(PelotaHM PHM, PjPanelHM p) {
        this.PHM = PHM;
        this.p = p;
    }//Constructor con parametros

    public PelotaRunnable() {
        PHM = new PelotaHM();
        p = new PjPanelHM();
    }//constructor vacio
    
    @Override
    public void run() {
        try {    
            for(int i = 0; i < 1000; i++){
                p.paintComponents(p.getGraphics());
                Thread.sleep(20);
            }//for
        } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//run
    
}
        
