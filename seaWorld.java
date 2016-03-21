import greenfoot.*;
import java.util.*;

/**
 * Write a description of class myWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class seaWorld extends World
{
    int steps = 0;
    int SPACE_OBS = 150;

    /**
     * Constructor for objects of class seaWorld.
     * 
     */
    public seaWorld() {
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. With no boundry
        super(700, 500, 1, false); 
        
        //Set the painting Order
        setPaintOrder( GameOver.class, Scoreboard.class, Dolphin.class, Obstacles.class );
        
        // Create a new dolphin and add it to the sea
        Dolphin dolphin = new Dolphin();
        addObject(dolphin,100, this.getHeight() / 2 );

        // Add the scoreboard
        addObject(new Scoreboard(),590, 20 );
    }
    
    public void act() {
        steps++;
        
        if ( steps == SPACE_OBS ) {
            addObstacles();
            steps = 0;
        }
    }
    
    /**
     * Add a button pipe to the screen
     */
    private void addObstacles() {

        Random r = new Random();
        
        // Get a random height;
        addObject( generateObstacle(), this.getWidth(), r.nextInt( this.getHeight() ) );
    }
    
    /**
     * Generate and obstacle
     */
    private Obstacles generateObstacle() {
        Random r = new Random();
    
        switch( r.nextInt(3) ) {
            case 0 : 
                return new Lobster();
            case 1 : 
                return new StarFish();
            case 2 : 
                return new Turtle();
            default :
                return new Lobster();
        }
    }
}
