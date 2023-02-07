/**	The Ball program implements an application that create a public class
*  for for final project in Programming fundamentals course at Georgian at Ilac course. 
*	Author: Lizandra Esterque & Layla Barbosa
*	Date: 11/23/2022
*	Time: 1:25 PM
*/

import java.awt.*;
import java.util.*;


//subclass
public class Ball extends Rectangle{
    
    //where the ball is gona move
    Random random;
    
    //how fast the ball is gona move in both directions
    int xVelocity;
    int yVelocity;

    //ball speed
    int initialSpeed=3;
   
    //constructor for the Ball 
    //random directions for the ball
    Ball (int x, int y, int width, int height) {
        super( x,y,width,height);
        random = new Random();
        int RandomXDirection = random.nextInt(2);
        if (RandomXDirection == 0)
             RandomXDirection--;
        SetXDirection(RandomXDirection*initialSpeed);

        int RandomYDirection = random.nextInt(2);
        if (RandomYDirection == 0)
             RandomYDirection--;
        SetYDirection(RandomYDirection*initialSpeed);
    }
    
    public void SetXDirection(int RandomXDirection) {
        xVelocity = RandomXDirection;
    }

    public void SetYDirection (int RandomYDirection){
        yVelocity = RandomYDirection;
    }

    //direction of the ball
    public void move() {
        x += xVelocity;
        y += yVelocity;    
    }

    //color for the ball
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x,y,width,height);
    }
}
