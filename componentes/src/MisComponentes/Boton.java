/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MisComponentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author yael_
 */
public class Boton extends JButton implements MouseListener, Serializable{
    private Color color;
    private boolean cambio;
    
    public Boton(){
        cambio = true;
        color = Color.blue;
        /*this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
        this.setFont(new Font("Comic San Serif", Font.PLAIN, 14));
        this.setBackground(Color.red);
        this.setForeground(Color.white);
        this.setPreferredSize(new Dimension(200, 40));
        this.setSize(200, 40);
        this.setCursor(new Cursor(12));
        addMouseListener(this);*/
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiaColor();
            }
        });
    }//constructor

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.exit(0);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        this.setBackground(Color.blue);
        this.setFont(new Font("Comic San Serif", Font.BOLD, 14));
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        this.setFont(new Font("Comic San Serif", Font.PLAIN, 14));
        this.setBackground(Color.red);
    }
    
    public void cambiaColor(){
        if(cambio)
            this.setColor(Color.BLUE);
        else
            this.setColor(Color.red);
        this.setBackground(color);
        this.setBorder(null);
        cambio = !cambio;
    }//CambiarColor

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isCambio() {
        return cambio;
    }

    public void setCambio(boolean cambio) {
        this.cambio = cambio;
    }
    
    
}
