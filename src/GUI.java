/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JPanel implements ActionListener{
    
    public static int gameMode;
    public static int movePiece;
    
    public GUI(){
        setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        JButton button1 = new JButton("New 1P Game");
        button1.addActionListener(this);
        buttons.add(button1);
        JButton button2 = new JButton("New 2P Game");
        button2.addActionListener(this);   
        buttons.add(button2);
        add(buttons);
    }
    
    public void actionPerformed (ActionEvent e){
        if (e.getActionCommand().equals("New 1P Game"))
            gameMode=1;
        else if (e.getActionCommand().equals("New 2P Game"))
            gameMode=2;
        else
            gameMode=0;
    }
}