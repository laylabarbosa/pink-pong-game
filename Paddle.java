/**	The Paddle program implements an application that create a public class
*  for for final project in Programming fundamentals course at Georgian at Ilac course. 
*	Author: Lizandra Esterque
*	Date: 11/23/2022
*	Time: 4:25 PM
*/

import java.awt.*;
import java.awt.event.*;
// import java.util.*;
// import javax.swing.*;

public class Paddle extends Rectangle{

    //the players 
    int id;

    //how fast the paddle is moving
    int yVelocity;
    //how much/fast the paddle will move
    int speed = 10;
    
    //constructor for our paddle 
    Paddle (int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id=id;
    }

    public void keyPressed(KeyEvent e) {
        switch(id) {
         //paddle 1
            case 1:
                //when the user press W paddle 1 will move down Y direction
                if (e.getKeyCode()==KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                //when the user press S paddle 1 will move up Y direction
                if (e.getKeyCode()==KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();     
                }
            break;        
            case 2:
                //when the user press up paddle 1 will move down Y direction
                if (e.getKeyCode()==KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                //when the user press down paddle 1 will move up Y direction
                if (e.getKeyCode()==KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();          
                }
            break;
        }
    }
     
    public void KeyReleased(KeyEvent e) {
        switch(id) {
            //paddle 1
           case 1:
                //Realese W and the paddle stops
                if (e.getKeyCode()==KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                //Realese S and the paddle stops
                if (e.getKeyCode()==KeyEvent.VK_S) {
                   setYDirection(0);
                   move();          
                }
            break;
            case 2:
                //Realese up and the paddle stops
                if (e.getKeyCode()==KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                //Realese down and the paddle stops
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                   setYDirection(0);
                   move();    
                }
            break;
        }
    }        

    public void setYDirection (int yDirection){
        yVelocity = yDirection;
    }

    public void move () {
        y = y + yVelocity; 
    }

    public void draw(Graphics g) {
      //paddles colors 
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }
}


    

