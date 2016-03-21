import greenfoot.*;
import java.util.List;


/**
 * Write a description of class Gator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dolphin extends Actor {   
    
    int gravity = 2;
    int eatenStarFish;
    
    /**
     * Act - do whatever the Dolphin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {     
       touchingObstacle();

       // Move the Dolphin 
       this.setLocation( this.getX(), this.getY() + 2 );
       this.keyPress();
       
       // Check if the dolphin is outside of the screen
       if ( this.getY() > this.getWorld().getHeight() || 
            this.getX() > this.getWorld().getWidth()  ||
            this.getY() == 0  ||
            this.getX() == 0 ) {
           this.gameOver();
       }
    }   
    
    /**
     * Method call when a key is press
     */
    private void keyPress() {
        
        if ( Greenfoot.isKeyDown( "up" ) ) {
            this.setLocation( this.getX(), this.getY() - 5 );
        } else if ( Greenfoot.isKeyDown( "down" ) ) {
            this.setLocation( this.getX(), this.getY() + 5 );
        } else if ( Greenfoot.isKeyDown( "right" ) ) {
            this.setLocation( this.getX() + 5, this.getY() );
        }else if ( Greenfoot.isKeyDown( "left" ) ) {
            this.setLocation( this.getX() - 5, this.getY() );
        }

        if ( Greenfoot.isKeyDown( "f" ) ) {
            System.out.println( "f" );
            // Add bubble
            Bubble b = new Bubble();
            this.getWorld().addObject(b,this.getX(), this.getY() );
        }
    }
    
    /**
     * Method that stops the game
     */
    private void gameOver() {
        this.getWorld().addObject( new GameOver(), this.getWorld().getWidth() / 2 , this.getWorld().getHeight() /2 );
        Greenfoot.stop();
    }

    /**
     * Check if the dolphin is touching an obstacle.
     * 
     * If touching a Starfish we have 1 pts, otherwise the game is over.
     */
    private void touchingObstacle() {
        
        if ( this.getOneIntersectingObject( Obstacles.class ) != null ) {
            
            if ( this.getOneIntersectingObject( StarFish.class ) != null ) {
                // Get the scroreboard from the world
               List<Scoreboard> listSb  = this.getWorld().getObjects( Scoreboard.class );
               Scoreboard sb = listSb.get(0);
               eatenStarFish++;
               sb.setScore(eatenStarFish);
               
               this.getWorld().removeObject( this.getOneIntersectingObject( StarFish.class ) );
            } else {
                gameOver();
            }
        }
    }
}

