/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoPiece {
    private int xPos = -70;
    private int yPos = -70;
    private int diameter = 40;
    private int yIndice;
    private int xIndice; 

    public void setX(int xPos){ 
        this.xPos = xPos;
        xIndice = (xPos+20)/50;
    }

    public int getX(){
        return xPos;
    }
    
    public int getXIndice(){
        return xIndice;
    }

    public void setY(int yPos){
        this.yPos = yPos;
        yIndice = (yPos+20)/50;
    }

    public int getY(){
        return yPos;
    }
    
    public int getYIndice(){
        return yIndice;
    }

    public int getDiameter(){
        return diameter;
    } 
    
    public void setDiameter(int diameter){
        this.diameter = diameter;
    }

    public void paintBlackPiece(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(xPos,yPos,diameter,diameter);
    }
    
    public void paintWhitePiece(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(xPos,yPos,diameter,diameter);
    }
}