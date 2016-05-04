/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gomoku");
        frame.setSize(717,796);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JPanel pane = (JPanel) frame.getContentPane();
        
        JPanel HUD = new GUI();
        
        JTextField greetings = new JTextField();
        greetings.setText("Welcome to Gomoku! Place five of the same color "
                + "vertically, horizontally or diagonally to win! "
                + "Please select game mode...");
        greetings.setEditable(false);
        HUD.add(greetings,BorderLayout.NORTH);
        
        pane.add(HUD,BorderLayout.NORTH);

        frame.setVisible(true);

        do
            System.out.println("Mode not selected");
        while (GUI.gameMode!=1&&GUI.gameMode!=2);
            
        do{
            if (GUI.gameMode==1){
                greetings.setVisible(false);
                JTextField soloNotice = new JTextField();
                soloNotice.setText("Now in 1P mode");
                soloNotice.setEditable(false);
                HUD.add(soloNotice,BorderLayout.NORTH);
                Coordinates.setAllEmpty();
                frame.setVisible(true);
                GUI.gameMode=0;
            }
            else if (GUI.gameMode==2){
                greetings.setVisible(false);
                JTextField multiNotice = new JTextField();
                multiNotice.setText("Now in 2P mode");
                multiNotice.setEditable(false);
                HUD.add(multiNotice,BorderLayout.NORTH);
                pane.add(new MultiBoard());
                frame.setVisible(true);
                while(Coordinates.blackWin==false&&Coordinates.whiteWin==false){
                    System.out.println("Game in progress");                   
                    if(Coordinates.blackWin==true){
                        multiNotice.setVisible(false);
                        JTextField P1_win = new JTextField();
                        P1_win.setText("P1 wins!");
                        P1_win.setEditable(false);
                        HUD.add(P1_win,BorderLayout.NORTH);
                        frame.setVisible(true);
                        Coordinates.setAllOccupied();
                    }
                    else if(Coordinates.whiteWin==true){
                        multiNotice.setVisible(false);
                        JTextField P2_win = new JTextField();
                        P2_win.setText("P2 wins!");
                        P2_win.setEditable(false);
                        HUD.add(P2_win,BorderLayout.NORTH);
                        frame.setVisible(true);
                        Coordinates.setAllOccupied();
                    }  
                }
                GUI.gameMode=0;
            }
       }while (true);
    }
}