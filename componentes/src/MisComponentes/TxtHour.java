/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MisComponentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author yael_
 */
public class TxtHour extends JTextField implements Serializable{
    private Color color;
    
    public TxtHour() {
        color = Color.black;
    }//constructor

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void ValidarCaja(){
        if(this.getText().equals("")){
            setColor(Color.gray);
            setText("hh:mm:ss");
        }//if
        else{
            String H[] = this.getText().split(":");
            if(H.length != 3){
                setColor(Color.gray);
                setText("hh:mm:ss");
            }//if
            int h = Integer.parseInt(H[0]), m = Integer.parseInt(H[0]), s = Integer.parseInt(H[0]);
            if(h < 0 || h > 23){
                setColor(Color.red);
                setText("0-23:mm:ss");
            }//if
            if(m < 0 || m > 59){
                setColor(Color.red);
                setText("hh:0-59:ss");
            }//if
            if(s < 0 || s > 59){
                setColor(Color.red);
                setText("hh:mm:0-59");
            }//if
        }//else
    }//ValidarCaja
    
    class Manejador implements FocusListener{
        @Override
        public void focusGained(FocusEvent e) {
            setForeground(Color.black);
            setText("");
        }//focusGained
        @Override
        public void focusLost(FocusEvent e) {
            ValidarCaja();
        }//focusLost
    }//Manejador
    
}//class
