/**	The GameFrame program implements an application that create a public class
*  for for final project in Programming fundamentals course at Georgian at Ilac course. 
*	Author: Layla de Souza Barbosa 
*	Date: 11/23/2022
*	Time: 6:25 PM
*/

import java.awt.*;
import javax.swing.*;

//subclass
public class GameFrame extends JFrame {

   //instace for game panel 
    GamePanel panel;

    //constructor for our game Frame
    GameFrame () {
        panel = new GamePanel ();
        this.add(panel);
       //this settle the tittle
        this.setTitle ("Pink Pong Game");
       
        //preventing the user from resizing game
        this.setResizable (false);
       
        //set our game background
        this.setBackground(Color.PINK);
       
        //close the application
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adjust to fit the size of the game 
        this.pack();
        this.setVisible(true);    
    }   
}
