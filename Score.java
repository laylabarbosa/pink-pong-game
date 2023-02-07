/**	The Score program implements an application that create a public class
*  for for final project in Programming fundamentals course at Georgian at Ilac course. 
*	Author: Layla de Souza Barbosa 
*	Date: 11/23/2022
*	Time: 5:25 PM
*/

import java.awt.*;


//subclass
public class Score extends Rectangle {
    
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    
    //take the score for the players
    int player1;
    int player2;

    //constructor for our score 
    Score (int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }

    //Color of the score, position, line to divide the sides of the players 
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Century", Font.BOLD, 55));
        g.drawLine (GAME_WIDTH/2, 0,GAME_WIDTH/2, GAME_HEIGHT);
        g.drawString (String.valueOf(player1/10) + String.valueOf(player1%10), (GAME_WIDTH/2)-85,100);
        g.drawString (String.valueOf(player2/10) + String.valueOf(player2%10), (GAME_WIDTH/2)+20,100);
        g.drawString ( "Pink Pong Game", (GAME_WIDTH/4 + 38),45);
    } 
}
