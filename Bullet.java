import greenfoot.*;
import java.util.List;

/**
 * Bullet object.
 * 
 * @author Charlotte, Olivier and Felix Roberge
 * @version March 2016
 */
public class Bullet extends ControlActors
{
    /**
     * Default method in Greenfoot.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if ( !obstacleDestroy() ) {
           // Check if the bullet is outside of the screen.  If so destroy the bullet, else move
           if ( isOutsideWorld() ) {
               this.getWorld().removeObject(this);
           } else {
               move(1);
               // This make sure there is only 1 bullet at a time on the same path.
               this.getWorld().removeObjects(this.getIntersectingObjects(Bullet.class));
            }
        }
    }    

        
    /**
     * Check if the bullet is touching an obstacle.  If so destroy the obstacle
     * Destroying a Starfish will remove 2 pts otherwise it added 2.
     * Return true is the object was destroyed
     * 
     * @return boolean 
     */
    private boolean obstacleDestroy() {
        Actor obstacle = this.getOneIntersectingObject(Obstacles.class);
        
        if ( obstacle != null ) {
            int s = 0;

            if ( obstacle instanceof StarFish ) {
               s = -2;
            } else {
               s =  2;
            }

           updateScore( s );

            // Remove the obstacle and the bullet
            this.getWorld().removeObject(obstacle);  
            this.getWorld().removeObject(this);
            
            return true;
        } else {
            return false;
        }
    }
}