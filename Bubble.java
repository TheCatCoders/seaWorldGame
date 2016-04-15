import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Bubblr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble extends Actor
{
    /**
     * Act - do whatever the Bubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       touchingObstacle();
    }    

        
    /**
     * Check if the bubble is touching an obstacle before moving
     * 
     * Destroying a Starfish will remove 2 pts otherwise it added 2.
     */
    private void touchingObstacle() {
        Actor a = this.getOneIntersectingObject(Obstacles.class);
        
        if ( a != null ) {
            // Get the scroreboard from the world to change the score
            List<Scoreboard> listSb  = this.getWorld().getObjects( Scoreboard.class );
            Scoreboard sb = listSb.get(0);
            int score = sb.getScore();
            
            if ( a instanceof StarFish ) {
               sb.setScore(score - 2 );
            } else {
               sb.setScore(score + 2 );
            }
            
            // Remove the objects
            this.getWorld().removeObject(a);  
            this.getWorld().removeObject(this);
        } else {
            this.setLocation( this.getX() + 1, this.getY()  );
            // This make sure there is only 1 bubble at a time on the same path.
            this.getWorld().removeObjects(this.getIntersectingObjects(Bubble.class));

        }
    }
}

/*
 *             
    //        this.getWorld().removeObject( actor );
            
    /*        if ( this.getOneIntersectingObject( StarFish.class ) != null ) {
                // Get the scroreboard from the world
               List<Scoreboard> listSb  = this.getWorld().getObjects( Scoreboard.class );
               Scoreboard sb = listSb.get(0);
               eatenStarFish++;
               sb.setScore(eatenStarFish);
               
               this.getWorld().removeObject( this.getOneIntersectingObject( StarFish.class ) );
    */
