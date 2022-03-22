/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alternativo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author yael_
 */
public class Hilo {
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setSize(680,400);
        v.setLocationRelativeTo(null);
        v.setTitle("Juego de Pelota");
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        v.setVisible(true);
    }//main
}//Clase Principal Hilo

class Ventana extends JFrame {
    private final JPanel pnlArea, pnlBotones;
    private final JButton btnIniciar, btnDetener;//Declaracion de instancias

    public Ventana() {
        setLayout(new BorderLayout());
        setResizable(false);
        pnlArea = new JPanel();
        pnlBotones = new JPanel();
        btnIniciar = new JButton("Iniciar");
        btnDetener = new JButton("Detener");//Inicializacion de instanscias
        pnlArea.setBackground(Color.black);
        pnlArea.setVisible(true);
        add(pnlArea, BorderLayout.CENTER);//agregado a la ventana y posicionamiento en el centro
        pnlBotones.setLayout(new FlowLayout());
        pnlBotones.setBackground(Color.white);
        pnlBotones.setVisible(true);
        add(pnlBotones, BorderLayout.SOUTH);//agregado a la ventana y posicionamiento en el sur
        btnIniciar.setHorizontalTextPosition(SwingConstants.CENTER);
        pnlBotones.add(btnIniciar);//agregado del boton iniciar al panel pnlBotones
        btnDetener.setHorizontalTextPosition(SwingConstants.CENTER);
        pnlBotones.add(btnDetener);//agregado del boton detener al panel pnlBotones
        btnIniciar.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnIniciar.setText("Reanudar");
        });//btnIniciar ActionPerformed
        btnDetener.addActionListener((java.awt.event.ActionEvent evt) -> {
            remove(pnlArea);
            repaint();
        });//btnDetener ActionPerformed
    }//Constructor Ventana
    
}//Clase interna Ventana

class Pelota {
    private int x, y, dx, dy, radio;
    private Color colur;

    public Pelota() {
        x = 100;
        y = 100;
        dx = 1;
        dy = 1;
        radio = 25;
        colur = Color.red;
    }//Constructor pelota

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
    
}//Clase interna pelota