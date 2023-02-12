/**	The GamePanel program implements an application that create a public class
*  for for final project in Programming fundamentals course at Georgian at Ilac course. 
*	Author: Layla de Souza Barbosa & Lizandra Esterque
*	Date: 11/24/2022
*	Time: 8:25 PM
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//subclass
public class GamePanel extends JPanel implements Runnable {

    //Size of our ping pong "table"
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension (GAME_WIDTH,GAME_HEIGHT);

    //size of the ball
    static final int BALL_DIAMETER =25;

    //size of the paddle
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;


    //constructor for our Panel
    GamePanel () {

        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }

    //method to created a new ball on the screen 
    public void newBall () {

        random = new Random();
        ball = new Ball((GAME_WIDTH/2)- (BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT/2)- (BALL_DIAMETER), BALL_DIAMETER,BALL_DIAMETER);
    }
    
    //method to created a new paddle on the screen 
    public void newPaddles () {

        //where the paddle will be 
        paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new Paddle((GAME_WIDTH-PADDLE_WIDTH),(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }

    //method to paint on the screen
    public void paint(Graphics g) {
        
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }

    //method to draw on the screen, showing the paddles, ball and the score
    public void draw(Graphics g) {

        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    //method to move and have interation
    public void move() {

        paddle1.move();
        paddle2.move();
        ball.move();
    }

    //method to check collision 
    public void Collision () {  
        //stops paddles off the game
        if(paddle1.y<=0)
        paddle1.y=0;
        if(paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
        paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;

        if(paddle2.y<=0)
        paddle2.y=0;
        if(paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
        paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;

        //give a player 1 point and creates a new game 
        if(ball.x <= 0) {
            score.player2++;
            newPaddles();
            newBall();
            System.out.println("Player 2:" + score.player2);
        }

        if(ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player1++;
            newPaddles();
            newBall();
            System.out.println("Player 1: "+ score.player1);
        }

        //stops ball off the game
        if (ball.y <=0 ){
            ball.SetYDirection(-ball.yVelocity);
        }
        if (ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
            ball.SetYDirection(-ball.yVelocity);
        }

        //bouces ball off paddles
        if (ball.intersects(paddle1)) {
            //change the directios 
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //increasing difficulty

		    if(ball.yVelocity>0)

			    ball.yVelocity++; //optional for more difficulty     
            else 
                 ball.yVelocity--;

           ball.SetXDirection(ball.xVelocity);
           ball.SetYDirection(ball.yVelocity);
        }

        if (ball.intersects(paddle2)) {
            //change the directios 
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //optional for more difficulty

		if(ball.yVelocity>0)
            ball.yVelocity++; //optional for more difficulty
          
        else 
           ball.yVelocity--;
           ball.SetXDirection(-ball.xVelocity);
           ball.SetYDirection(ball.yVelocity);
        }  
    }

    //game loop 
    public void run(){
        long lastTime = System.nanoTime();
        double amountofTicks = 60.0;
        double ns = 1000000000/ amountofTicks;
        double delta = 0;        
        
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if (delta>=1) {
                move();
                Collision();
                repaint();
                delta--;       

            }
        }
     }

    //class to received from user keyboard  
    public class AL extends KeyAdapter{

		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {

			paddle1.KeyReleased(e);
			paddle2.KeyReleased(e);
		}
	}
}
