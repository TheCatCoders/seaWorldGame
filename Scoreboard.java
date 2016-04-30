import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Scoreboard object.  This object is there to display the socre of the user.
 * 
 * @author Charlotte, Olivier and Felix Roberge
 * @version March 2016
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
     * 
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
            str = editNegativeScore(totalScore);
        } else {
            str = editPositiveScore(totalScore);
        }
        
        image.drawString( String.valueOf( str ), 30, 30 );
        this.setImage(image);
    }
    
    /**
     * Edit the score properly iif the score is positive
     * We always want 4 digit.
     * 
     * @param the score to display int.
     * @return the edited score String
     */
    private String editPositiveScore( int totalScore ) {
        String str;
        
        if ( totalScore >= 0 && totalScore < 10 ) {
            str = "000" + totalScore;
        } else if ( totalScore >= 10 && totalScore < 100 ) {
            str = "00" + totalScore;
        } else if ( totalScore >= 1000 && totalScore < 10000 ) {
            str = "0" + totalScore;
        } else {
            str = "" + totalScore;
        }
        
        return str;
    }
    
    /**
     * Edit the score properly iif the score is negative
     * We always want 4 digit.
     * 
     * @param the score to display int.
     * @return the edited score String
     */
    private String editNegativeScore( int totalScore ) {
        String str;
        
        if ( totalScore < 0 && totalScore > -10 ) {
            str = "-000" + -totalScore;
        } else if ( totalScore <= -10 && totalScore > -100 ) {
            str = "-00" + -totalScore;
        } else if ( totalScore >= -100 && totalScore > -1000 ) {
            str = "-0" + -totalScore;
        } else {
            str = "" + totalScore;
        }
        
        return str;
    }
    
}
