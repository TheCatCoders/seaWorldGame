import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Scrore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    int totalScore;
    
    /**
     * Constructor
     */
    public Scoreboard() 
    {
        // Add your action code here.
        GreenfootImage image = new GreenfootImage( 125, 40 );
        setImage( image );
        setScore( 0 );
    }    
    
    /**
     * Get the score
     */
    public int getScore() {
        return totalScore;
    }
    
    /**
     * Set the score and display it properly on the screen
     * @param newScore int
     */
    public void setScore( int newScore ) {
        this.totalScore = newScore;
        
        GreenfootImage image = this.getImage();
        image.setColor( Color.white );
        image.fill();
        image.setFont( new Font("Serif", Font.BOLD, 32) );
        image.setColor( Color.blue );
        
        String str;
        if ( totalScore < 0 ) {
            str="-00" + -totalScore;
        } else if ( totalScore >= 0 && totalScore < 10 ) {
            str = "000" + totalScore;
        } else if ( totalScore >= 10 && totalScore < 100 ) {
            str = "00" + totalScore;
        } else if ( totalScore >= 1000 && totalScore < 10000 ) {
            str = "0" + totalScore;
        } else {
            str = "" + totalScore;
        }
        
        image.drawString( String.valueOf( str ), 30, 30 );
        this.setImage(image);
    }
}
