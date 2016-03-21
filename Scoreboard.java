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
     * 
     */
    public void setScore( int score ) {
        GreenfootImage image = this.getImage();
        image.setColor( Color.white );
        image.fill();
        image.setFont( new Font("Serif", Font.BOLD, 32) );
        image.setColor( Color.blue );
        
        String s;
        if ( score < 10 ) {
            s = "000" + score;
        } else if ( score >= 10 && score < 100 ) {
            s = "00" + score;
        } else if ( score >= 1000 && score < 10000 ) {
            s = "0" + score;
        } else {
            s = "" + score;
        }
        
        image.drawString( String.valueOf( s ), 30, 30 );
        this.setImage(image);
    }
}
