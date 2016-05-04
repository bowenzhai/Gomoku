/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultiBoard extends JPanel{
    
    GoPiece blackPiece = new GoPiece();
    GoPiece whitePiece = new GoPiece();
    static double counter;
    
    public MultiBoard(){
        counter=1.0;
        Coordinates.setAllEmpty();
        Coordinates.blackWin=false;
        Coordinates.whiteWin=false;
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                    placePiece(e.getX(),e.getY());
                }
        }); 
    }
    
    public void placePiece(int x, int y){ 
        blackPiece.setX(Coordinates.closestX(x)-20);
        blackPiece.setY(Coordinates.closestY(y)-20);
        whitePiece.setX(Coordinates.closestX(x)-20);
        whitePiece.setY(Coordinates.closestY(y)-20);

        if (counter/2!=(int)(counter/2)){
            if (Coordinates.detectOverlay(blackPiece.getYIndice(),blackPiece.getXIndice())==false){
                repaint(blackPiece.getX(),blackPiece.getY(),
                    blackPiece.getDiameter(),blackPiece.getDiameter());
                counter++;
                Coordinates.hasBlackPiece[blackPiece.getYIndice()][blackPiece.getXIndice()]=true;
                Coordinates.blackWin=Coordinates.detectBlackWin(blackPiece.getYIndice(),blackPiece.getXIndice());
            }
        }
        else if (counter/2==(int)(counter/2)){
            if (Coordinates.detectOverlay(whitePiece.getYIndice(),whitePiece.getXIndice())==false){
                repaint(whitePiece.getX(),whitePiece.getY(),
                    whitePiece.getDiameter(),whitePiece.getDiameter());
                counter++;
                Coordinates.hasWhitePiece[whitePiece.getYIndice()][whitePiece.getXIndice()]=true;
                Coordinates.whiteWin=Coordinates.detectWhiteWin(whitePiece.getYIndice(),whitePiece.getXIndice());
            }
        }
    }
 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color boardColor = new Color(242,196,111);
        g.setColor(boardColor);
        g.fillRect(0,0,700,700);
        
        g.setColor(Color.black);
        int positionX; int positionY;
        for (positionX = 0; positionX<=700; positionX+=50)
            g.drawLine(positionX,0,positionX,700);
        for (positionY = 700; positionY>=0; positionY-=50)
            g.drawLine(0,positionY,700,positionY);
        
        if (counter/2!=(int)(counter/2))
            whitePiece.paintWhitePiece(g);
        else if (counter/2==(int)(counter/2))
            blackPiece.paintBlackPiece(g);
    }
}