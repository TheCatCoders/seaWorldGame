import greenfoot.*;
import java.util.*;

/**
 * This wolrd represent the sea where a dolphin is floating around.  
 * There are obstacles that will need to be avoid by the dolphin.
 * You make points when you eat a Star fish or destroy a turtle or a lobster.  You lose point if you destroy a Star fish.
 * Bullet are fired by pressing the "f" key.
 * 
 * @author Charlotte, Olivier and Felix Roberge
 * @version March 2016
 */
public class SeaWorld extends World
{
    int steps = 0;
    int SPACE_OBS = 150;
    
    Scoreboard scoreboard = null;
    
    /**
     * Constructor for objects of class SeaWorld.
     */
    public SeaWorld() {
        
        // Create a new world 700x500 cells with a cell size of 1x1 pixels. With no boundry
        super(700, 500, 1, false); 
        
        //Set the painting Order
        setPaintOrder( GameOver.class, Scoreboard.class, Dolphin.class, Obstacles.class );
        
        // Create the main caracter, the dolphin and add it to the sea at a given position
        Dolphin dolphin = new Dolphin();
        addObject(dolphin,100, this.getHeight() / 2 );

        // Add the scoreboard to the world at a given position
        addObject(getScoreboard(),590, 20 );
    }
    
    /**
     * Default method in Greenfoot.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        steps++;
        
        if ( steps == SPACE_OBS ) {
            addObstacles();
            steps = 0;
        }
    }
    
    /** 
     * Get the object scoreboard from the world.
     * 
     * return scoreboard Scoreboard
     */
    public Scoreboard getScoreboard() {
        if ( this.scoreboard == null ) {
            this.scoreboard = new Scoreboard();
        }
        
        return this.scoreboard;
    }
        
    /**
     * Add an Obstacle to the screen
     */
    private void addObstacles() {

        Random r = new Random();
        
        // Get a random height;
        addObject( generateObstacle(), this.getWidth(), r.nextInt( this.getHeight() ) );
    }
    
    /**
     * Generate Obstacle.
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
