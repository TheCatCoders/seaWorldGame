import greenfoot.*;
import java.util.List;


/**
 * Dolphin object. Main character of the game.
 * 
 * @author Charlotte, Olivier and Felix Roberge
 * @version March 2016
 */
public class Dolphin extends ControlActors {   
    
    int gravity = 2;
    
    /**
     * Default method in Greenfoot.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {     
       // Check if the dolphin is touching something. 
       touchingObstacle();
       
       // Check if the dolphin is outside of the screen.  If so the game is over
       if ( isOutsideWorld() ) {
           this.gameOver();
       }
       
       // Move the Dolphin, by default the dolphin is falling down.
       this.setLocation( this.getX(), this.getY() + 2 );
       this.keyPress();
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

        // Fire a bullet.  Add the bullet to the world infront of the dolphin
        if ( Greenfoot.isKeyDown( "f" ) ) {
            this.getWorld().addObject( new Bullet(), this.getX()+38, this.getY()+20 );
        }
    }
    
    /**
     * Check if the dolphin is touching an obstacle.
     * 
     * If touching a Starfish we have 1 pts, otherwise the game is over.
     */
    private void touchingObstacle() {
        
        Actor obs = this.getOneIntersectingObject(Obstacles.class);
        
        if ( obs != null ) {
            
            if ( obs instanceof StarFish ) {
               updateScore( 1 );
               this.getWorld().removeObject( obs );
            } else {
                gameOver();
            }
        }
    }
    
    /**
     * Method to end the game
     */
    private void gameOver() {
        this.getWorld().addObject( new GameOver(), this.getWorld().getWidth() / 2 , this.getWorld().getHeight() /2 );
        Greenfoot.stop();
    }
}

