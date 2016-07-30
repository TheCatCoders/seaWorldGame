import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is the super class for all user control objects
 * 
 * @author Charlotte, Olivier and Felix Roberge
 * @version March 2016
 */
public class ControlActors extends Actor
{
    public boolean isOutsideWorld() {
           // Check if the dolphin is outside of the screen
       if ( this.getY() > this.getWorld().getHeight() || 
            this.getX() > this.getWorld().getWidth()  ||
            this.getY() == 0  ||
            this.getX() == 0 ) {
           return true;
       } else {
           return false;
       }
    }
    
    /**
     * Change the score.
     * 
     * @param number to add.
     */
    protected void updateScore( int scoreChange ) {
      int s = this.getWorldOfType(SeaWorld.class).getScoreboard().getScore();
      this.getWorldOfType(SeaWorld.class).getScoreboard().setScore( s + scoreChange );
    }
}

